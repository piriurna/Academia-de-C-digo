/**
 * Classe de teste
 */
public class EncapsulationTest {

	public static void main(String args[]) {

		Empregado emp1 = new Empregado(); //criar um empregado
		emp1.setNome("José"); //definir o nome do empregado
		emp1.setSalario(1230.50); //definir o salario do empregado
		emp1.setEmpId(2783764); //definir o id do empregado
		emp1.setSsn("1234567890"); //definir o ssn do empregado

		emp1.mostrar_dados();
		
		//criar um empregado com os atributos todos, numa so linha
		Empregado emp2 = new Empregado(1, "Ana", "9876543210", 1230.45);
		
	
		emp2.mostrar_dados();
	}
}
