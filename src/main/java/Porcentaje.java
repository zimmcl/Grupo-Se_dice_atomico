package main.java;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Porcentaje {
	
	private static  ArrayList<String> arreglo;
	private static  ArrayList<Double> arreglo2;
	private static  ArrayList<Double> arreglo3;
	private static  ArrayList<String> arreglo4;
	private static String strToken;
	
	public static void porcentaje()
	{
		char aux=' ';
		double Resultado=0;
		double operador=0;
		arreglo = new ArrayList<String>();
		arreglo2 = new ArrayList<Double>();
		arreglo3 = new ArrayList<Double>();
		arreglo4 = new ArrayList<String>();
		
		//-INGRESA OPERACION POR TECLADO-
		strToken=JOptionPane.showInputDialog(null,"INGRESE LA OPERACION: ","Ingrese la Operacion");		
		//-ALMACENO ELEMENTOS EN ARREGLO EXTRAIDOS DE LA CADENA "STRTOKEN"-
		for(int i=0;i<strToken.length();i++)
		{
			arreglo.add(Character.toString(strToken.charAt(i)));
		}
		arreglo.add("Fin");
		if(arreglo.contains("+")||arreglo.contains("/")||arreglo.contains("*")||arreglo.contains("-"))
		{
			JOptionPane.showMessageDialog(null,"Error en el operador");
			Calculadora.Menu();
			System.exit(0);
		}
		/*-VERIFICA EXISTENCIA DE OPERADOR "%". LUEGO AGRUPO OPERANDOS. Ejemplo: strToken->[2,0,%,2,0,0] -> arreglo->[20,%,200]
		   SE UTILZAN ARREGLOS AUXILIARES PARA TAL FIN-*/
		for(int i=0;i<arreglo.size();i++)
		{
			if(arreglo.get(i).equals("%") || arreglo.get(i).equals("Fin"))
			   {
				for(int j=0;j<arreglo2.size();j++)
				{
				   arreglo3.add(j,Double.parseDouble(arreglo.get(i-j-1)));
				   arreglo3.add(j,(arreglo3.get(j)*Math.pow(10,j+1))/10);
				   operador=operador+arreglo3.get(j);
				   aux=arreglo.get(i).charAt(0);
				}
				
				if(i<=arreglo.size())
				   {
					   arreglo4.add(Double.toString(operador));
					   arreglo4.add(Character.toString(aux));
					   operador=0;
					   arreglo2.clear();
				   }
			   } 
			   else {
				   arreglo2.add((Double.parseDouble(arreglo.get(i))));
			   }
			   arreglo3.clear();
		}
		//-ELIMINO ULTIMO ELEMENTO DEFINIDO COMO "F"-
		arreglo4.remove(arreglo4.size()-1);
		/*-VERIFICO QUE LA CANTIDAD DE OPERADORES NO SEA SUPERIOR A 2-*/
		if(arreglo4.size()>3)
		{
			JOptionPane.showMessageDialog(null,"Cantidad de operandos superior a 2");
			Calculadora.Menu();
			System.exit(0);
		}
		arreglo3.add(Double.parseDouble(arreglo4.get(0)));
		//-RESUELVO OPERACION-
		for(int k=0; k<arreglo4.size()-1;k++)
		   {
			   if(arreglo4.get(k+1).equals("%"))
			   {
				   Resultado=((arreglo3.get(0))*Double.parseDouble(arreglo4.get(k+2))/100);
				   arreglo3.add(0,Resultado);
			   }
		   }
		if(arreglo3.size()==1)
		{	
		JOptionPane.showMessageDialog(null, "OPERACION: "+strToken+" = "+arreglo3.get(0));}
		else JOptionPane.showMessageDialog(null, "OPERACION: "+strToken+" = "+Resultado);	
	}
}
