/*
	Programación Orientada a Objetos
	Driver
	22-09-2016
*/
import java.util.Scanner;

public class Driver
{
	public static void main(String[] args)
	{
		System.out.println("+------------------------+");
		System.out.println("|Bienvenido a mi programa|");
		System.out.println("+------------------------+");
		System.out.println();
		
		boolean opcion = true;
		Scanner entrada = new Scanner(System.in);
		
		do{
			System.out.println("Ingresando un trabajador");
			System.out.println("------------------------");
			
			
			System.out.println("Ingrese el nombre completo del trabajador:");
			String nombre = entrada.nextLine();
			System.out.println("Ingrese el area en la que trabaja el empleado:");
			String area = entrada.nextLine();
			try{
				System.out.println("Ingrese el salario base del trabajador:");
				double salarioBase = entrada.nextDouble();
				System.out.println("Ingrese la cantidad de horas en que estuvo ausente:");
				double[] ausencia = new double[24];
				//Se entran las horas de ausencia para los 24 días laborables del mes
				for (int i = 1; i<=24; i++)
				{
					System.out.println("Dia "+i); 
					double horas = entrada.nextDouble(); //Se inicializó el i en 1 por eso se le resta 1
					if (horas <= 8 ) //No se puede faltar más de 8 horas
						ausencia[i-1] = horas;
					else
						i--;
				}
				int tipo = 0; //Tipo de trabajador
				//Solo pueden entrar dos valores posibles para el tipo de trabajador
				do{
					System.out.println("Diga el tipo de trabajador \n 1: Docente, 2: NO Docente");
					tipo = entrada.nextInt();
					System.out.println("tipo="+tipo);
				}while (tipo != 1 && tipo!= 2);
				
				if (tipo  == 1)
				{
					System.out.println("Años de antiguedad en el CES");
					int antiguedad = entrada.nextInt();
					int grado = 0;
					do{
						System.out.println("Ingrese el grado científico base del trabajador \n 0: Ninguno, 1: Master, 2: Doctor");
						grado = entrada.nextInt();
					}while (grado<0 && grado >3);
					String gradoCient = "";
					if (grado==1)
						gradoCient = "master";
					if (grado == 2)
						gradoCient = "doctor";
					//Se crea el trabajador docente
					TrabajadorDocente trabDocente = new TrabajadorDocente(nombre,area,salarioBase,ausencia,antiguedad,gradoCient);
					System.out.println("El salario del trabajador docente es: "+trabDocente.salario());
				}
				if (tipo  == 2)
				{
					System.out.println("Cantidad de días feriados trabajados");
					int feriados = entrada.nextInt();
					//Se crea el trabajador no docente
					TrabajadorNoDocente trabNoDocente = new TrabajadorNoDocente(nombre,area,salarioBase,ausencia,feriados);
					System.out.println("El salario del trabajador no docente es: "+trabNoDocente.salario());
				}
				String rptaUpper = ""; //inicializando la variable
				do{
					entrada.nextLine();
					System.out.println("¿Desea ingresar otro trabajador? (Si/No)");
					String rpta = entrada.nextLine();
					rptaUpper = rpta.toUpperCase();
					if (rptaUpper.equals("SI")) 
						opcion = true;// Se repite la entrada de datos
					if (rptaUpper.equals("NO"))
						opcion = false; //Se sale del ciclo de la entrada de datos
				}while (!rptaUpper.equals("SI") && !rptaUpper.equals("NO"));
				
			}
			catch (Exception e)
			{
				System.out.println("Debe ingresar un número");
				entrada.nextLine();
			}
		}while (opcion);
		
		System.out.println("\n\n+----------------------------+");
		System.out.println("|Gracias por usar mi programa|");
		System.out.println("+----------------------------+");
		System.out.println();
	}
}