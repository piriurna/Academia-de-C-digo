
public class Conditionals {

	public static void main(String[] args) {


		//Usando o operador ternario
		int x = 4, y = 9, z = 4, d = 9;

		if((y / x) < 3) {
			x += y;
		}else {
			x *= y;
		}

		System.out.println("X: " + x);

		z = ((d / z) < 3) ? (z += d) : (z *= d);

		System.out.println("Z: " + z);




		//Exemplo de switch
		int month = 4	9;
		boolean isLeapYear = true;

		switch (month){
		case 1: case 3: case 5: case 7:
		case 8: case 10: case 12:
			System.out.println("Mês com 31 dias.");
			break;
		case 2:
			if(!isLeapYear) {
				System.out.println("Mês com 28 dias");
			}else {
				System.out.println("Mês com 29 dias");
			}
			break;
		case 4: case 6: case 9: case 11:
			System.out.println("Mês com 30 dias");
			break;
		default:
			System.out.println("Mês Inválido");
		}


	}

}
