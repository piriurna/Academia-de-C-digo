/**
 * Classe Encapasulamento
 *
 */
public class Empregado {
	//atributos do objeto
	private int empId;
	private String nome;
	private String ssn;
	private double salario;

	/**
	 * Maneira 1 de criar um construtor
	 */
	public Empregado() {

	}
	/**
	 * Maneira 2 de criar um constutor
	 * @param empId id do empregado
	 * @param nome nome do empregado
	 * @param ssn ssn do empregado
	 * @param salario salario do empregado
	 */
	public Empregado(int empId, String nome, String ssn, double salario) {
		this();
		String a = Integer.toString(empId);
		if (a.length() ==7 )
			this.empId = empId;
		else {
			System.out.println("Id invalido, novo id = 1234567");
			this.empId = 1234567;
		}
		this.nome = nome;
		this.ssn = ssn;
		this.salario = salario;
	}
	//metodos getters e setters
	public int getEmpId() {
		return empId;
	}
	//setter with checking
	public void setEmpId(int empId) { 
		String idString = Integer.toString(empId);
		if (idString.length()== 7)
			this.empId = empId;
		else {
			System.out.println("Id invalido, novo id = 1234567");
			this.empId = 1234567;
		}

	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome != null)
			this.nome = nome;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}

	public void mostrar_dados() {
		System.out.println("Empregado: " + empId + ", Nome : " 
				+ nome + ", SSN : " + ssn + ", Salario: " + salario);
	}


}

