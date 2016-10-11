/*
	Programación Orientada a Objetos
	Clase TrabajadorNoDocente
	22-09-2012
*/
public class TrabajadorNoDocente extends Trabajador
{
	//Atributos:
	private int cantidadFeriados; // Contendrá la cantidad de días feriados que el trabajador no docente ha trabajado
	
	//Constructores
	public TrabajadorNoDocente()
	{
		super();////Se llama al constructor sin parámetros de la clase padre
	}
	//Al constructor con parámetros le entran todos los parámetros también de la clase padre
	public TrabajadorNoDocente(String nombre, String area, double salarioBase, double[] horasAusenciaDiaria, int cantFeriados)
	{
		super(nombre,area,salarioBase,horasAusenciaDiaria); //Se llama al constructor con parámetros de la clase padre
		this.cantidadFeriados = cantFeriados;//Se inicializa su atributo particular
	}
	
	//Sets y Gets
	public void setCantidadFeriados(int cantFeriados)
	{
		this.cantidadFeriados = cantFeriados;
	}
	
	public int getCantidadFeriados()
	{
		return cantidadFeriados;
	}
		
	//Servicios
	public double extraFeriados() //calcula el aumento cantidad de días feriados trabajados por el trabajador no docente
	{
		return tarifaDiaria()*2*cantidadFeriados;
	}
	
	public double tarifaDiaria() //Calcula la tarifa diaria dependiendo del salario base
	{
		return salarioBase/24; //usando el atributo protegido de la clase padre
	}
	
	public double salario() 
	{
		/*Calcula el salario total del trabajador 
		no docente
		Se llama al método salario de la clase padre 
		y se le agrega lo que es propio de esta*/
		return super.salario() + extraFeriados();
	}
}