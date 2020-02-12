package application.models.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import application.DBConnector;

public class UserDAO {
	private static DBConnector dbConnector = DBConnector.getConnector();
	
	public static ArrayList<User> getAllUsers() {
		ArrayList<User> users = new ArrayList<>();
		Connection conn = dbConnector.getConnection();
		String sql = "SELECT * FROM Users";
		try (Statement stat = conn.createStatement(); ResultSet rs = stat.executeQuery(sql)) {
			while(rs.next()) {
				String username = rs.getString(1);
				String password = rs.getString(2);
				users.add(new User(0, username, password, username, username));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return users;
	}
	
	public static boolean login(String username, String password) {
		boolean connected = false;
		Connection conn = dbConnector.getConnection();
		String sql = "SELECT * FROM Users WHERE username = ? AND password = ?";
		ResultSet rs = null;
		try (PreparedStatement stat = conn.prepareStatement(sql)) {
			stat.setString(1, username);
			stat.setString(2, password);
			rs = stat.executeQuery();
			if(rs.next())
				connected = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connected;
	}
	
	public static boolean register(User user, String password) {
		if(alreadyRegistered(user.getUsername())) return false;
		boolean success = false;
		Connection conn = dbConnector.getConnection();
		String sql = "INSERT INTO Users VALUES (?, ?)";
		try (PreparedStatement stat = conn.prepareStatement(sql)) {
			stat.setString(1, user.getUsername());
			stat.setString(2, password);
			stat.executeUpdate();
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return success;
	}
	
	private static boolean alreadyRegistered(String username) {
		Connection conn = dbConnector.getConnection();
		String sql = "SELECT * FROM Users WHERE  username= ?";
		ResultSet rs = null;
		try (PreparedStatement stat = conn.prepareStatement(sql)) {
			stat.setString(1, username);
			rs = stat.executeQuery();
			if(rs.next())
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
