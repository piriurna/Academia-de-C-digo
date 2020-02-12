package Default.BackEnd;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;


public class DataBase {


	public Connection con;
	public Statement stmt;

	public DataBase(String sqlURL, String dbUser, String dbPass){    
		this.con= null;
		this.stmt= null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(sqlURL, dbUser, dbPass);
			this.stmt = this.con.createStatement();
		}catch (Exception e){
			e.printStackTrace();
			System.err.println("Problems setting the connection");
		};
	}


	public void consultTable(){
		try{
			Statement stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from Colaborador");
			if (resultSet != null) {
				while(resultSet.next()) {
					System.out.println("Name: " + resultSet.getString("nome"));
					System.out.println("Identification_number: " + resultSet.getString("num_doc_ident"));
					System.out.println("");
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("\n");
	} 


	public void insertNewColaborator(Colaborator colab) {
		try {
			PreparedStatement pstmt = con.prepareStatement("insert into Colaborador values(?, ?, ?, ?, ?, ?, ?, ?)");
			pstmt.setString(1, colab.getName());
			pstmt.setString(2, colab.getAdress());
			pstmt.setString(3, colab.getIdentification_number());
			pstmt.setString(4, colab.getAge());
			pstmt.setString(5, colab.getEmail());
			pstmt.setString(6, colab.getPhone_number());
			pstmt.setBinaryStream(7, colab.getPhotoStream());
			pstmt.setBinaryStream(8, colab.getCv());
			pstmt.execute();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}


	public void deleteColaborator(String name) {
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("DELETE FROM Colaborador " +  "WHERE nome = '"+name+"'");
		}catch (SQLException e) { 
			e.printStackTrace();
		}
	}


	public void updateColaborator(Colaborator colab) {
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("UPDATE Colaborador " +  "SET idade = '"+colab.getAge()+"' WHERE nome = '"+colab.getName()+"'");
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	public void consultColaborator(String name) {
		try{
			Statement stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from Colaborador " + 
					"WHERE nome = '"+name+"'");
			if (resultSet != null) {
				resultSet.next();
				ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
				for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
					int type = resultSetMetaData.getColumnType(i);
					if (type == Types.VARCHAR || type == Types.CHAR) {
						System.out.print(resultSet.getString(i) + " | ");
					}else if(type == Types.BLOB) {
						System.out.println(resultSet.getBlob(i));
					}else {
						System.out.print(resultSet.getLong(i) + " | ");
					}
				}
				System.out.println("");

			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("\n");
	}
	

	/**
	 * Fecha a ligação com a base de dados
	 */
	public void closeBD(){
		try {
			stmt.close();
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}

