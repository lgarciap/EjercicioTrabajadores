/*
	Programación Orientada a Objetos
	Clase Trabajador
	22-09-2016
*/
public class Trabajador
{
	//Atributos
	private String nombre; //Contendrá el nombre y los dos apellidos del trabajador
	private String area; //Contendrá el área donde trabaja el empleado
	protected double salarioBase;
	private double[] horasAusenciaDia; //horas de ausencia diaria. Una casilla del arreglo por día laborable
	
	//Constructores
	public Trabajador() //sin parámetros
	{
		nombre = "";
		area = "";
		salarioBase = 0;
		horasAusenciaDia = new double[24]; //una casilla por cada dia laborable
	}
	//con parámetros
	public Trabajador(String nombre, String area, double salarioBase, double[] horasAusenciaDiaria) //Con parámetros
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
	
	public int totalAusencias()//Calcula el total de horas en las que se ausentó el trabajador en el mes
	{
		double total = 0; //Tendrá la cantidad de horas totales
		for (double hora:horasAusenciaDia) //Se recorre el arreglo diario y se le suma a total la cantidad de horas ausentes de cada día
		{
			total += hora; 
		}
		return (int)total; //se convierte a entero para devolverlo
	}
	public double salario()
	{ 
		//Calcula el salario de un trabajador restándole 
		//al salario básico el descuento por las ausencias
		//Esta parte del cálculo del salario es común a todos los 
		//trabajadores
		return salarioBase - descuentoPorAusencias(); 
	}
}