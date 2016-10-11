/*
	Programaci�n Orientada a Objetos
	Clase Trabajador
	22-09-2016
*/
public class Trabajador
{
	//Atributos
	private String nombre; //Contendr� el nombre y los dos apellidos del trabajador
	private String area; //Contendr� el �rea donde trabaja el empleado
	protected double salarioBase;
	private double[] horasAusenciaDia; //horas de ausencia diaria. Una casilla del arreglo por d�a laborable
	
	//Constructores
	public Trabajador() //sin par�metros
	{
		nombre = "";
		area = "";
		salarioBase = 0;
		horasAusenciaDia = new double[24]; //una casilla por cada dia laborable
	}
	//con par�metros
	public Trabajador(String nombre, String area, double salarioBase, double[] horasAusenciaDiaria) //Con par�metros
	{
		this.nombre = nombre;
		this.area = area;
		this.salarioBase = salarioBase;
		this.horasAusenciaDia = horasAusenciaDiaria;
	}
	
	//Sets y Gets
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	public String getNombre()
	{
		return nombre;
	}
	public void setArea(String area)
	{
		this.area = area;
	}
	public String getArea()
	{
		return area;
	}
	public void setSalarioBase(double salarioBase)
	{
		this.salarioBase = salarioBase;
	}
	public double getSalarioBase()
	{
		return salarioBase;
	}
	public void setHorasAusenciaDia(double[] horasDia)
	{
		this.horasAusenciaDia = horasDia;
	}
	public double[] getHorasAusenciaDia()
	{
		return horasAusenciaDia;
	}
	
	//Servicios
	public double tarifaHoraria() //Calcula la tarifa horaria dependiendo del salario base
	{
		return salarioBase/192;
	}
	public double descuentoPorAusencias() //Calcula el descuento por ausencias
	{
		return tarifaHoraria()*totalAusencias();
	}
	
	public int totalAusencias()//Calcula el total de horas en las que se ausent� el trabajador en el mes
	{
		double total = 0; //Tendr� la cantidad de horas totales
		for (double hora:horasAusenciaDia) //Se recorre el arreglo diario y se le suma a total la cantidad de horas ausentes de cada d�a
		{
			total += hora; 
		}
		return (int)total; //se convierte a entero para devolverlo
	}
	public double salario()
	{ 
		//Calcula el salario de un trabajador rest�ndole 
		//al salario b�sico el descuento por las ausencias
		//Esta parte del c�lculo del salario es com�n a todos los 
		//trabajadores
		return salarioBase - descuentoPorAusencias(); 
	}
}