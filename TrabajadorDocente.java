/*
	Programaci�n Orientada a Objetos
	Clase TrabajadorDocente
	22-09-2012
*/
public class TrabajadorDocente extends Trabajador
{
	//Atributos:
	private int antiguedad; // Contendr� la cantidad de a�os que lleva el trabajador en el centro de educaci�n superior
	private String gradoCientifico; // Master o Doctor
	
	//Constructores
	public TrabajadorDocente()
	{
		super(); //Se llama al constructor sin par�metros de la clase padre
	}
	//Al constructor con par�metros le entran todos los par�metros tambi�n de la clase padre
	public TrabajadorDocente(String nombre, String area, double salarioBase, 
							double[] horasAusenciaDiaria, int antiguedad, 
							String gradoCientifico)
	{
		super(nombre,area,salarioBase,horasAusenciaDiaria); //Se llama al constructor con par�metros de la clase padre
		this.antiguedad = antiguedad;
		this.gradoCientifico = gradoCientifico;
	}
	
	//Sets y Gets
	public void setAntiguedad(int antiguedad)
	{
		this.antiguedad = antiguedad;
	}
	public int getAntiguedad()
	{
		return antiguedad;
	}
	public void setGradoCientifico(String grado)
	{
		gradoCientifico = grado;
	}
	public String getGradoCientifico()
	{
		return gradoCientifico;
	}
	
	//Servicios
	public double plusAntiguedad() //calcula el aumento por antiguedad del trabajador docente
	{
		return antiguedad/5*20;
	}
	public double plusGradoCientifico() //Calcula el aumento por grado cient�fico del trabajador docente
	{
		int plus = 0;
		if (gradoCientifico.equals("master"))
			plus = 80;
		if (gradoCientifico.equals("doctor"))
			plus = 120;
		return plus;
	}
	public double salario() 
	{
		//Calcula el salario total del trabajador docente
		/*Se llama al m�todo salario de la clase padre que tiene lo 
		que es com�n para todos los tipos de trabajadores y a eso se 
		le suma lo que es espec�fico del trabajador docente*/
		return super.salario()+plusAntiguedad()+plusGradoCientifico(); 
	}
	
}

