package test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import modulo.Seguridad;
import modulo.Sistema;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sistema sistema = new Sistema();

		System.out.println("\n1)");
		sistema.agregarVisita("Martino", "Marcelo", 44444444, "Coop TIC");
		sistema.agregarEmpleado("Lopez", "Martin", 33333333, 3829);
		sistema.agregarVisita("Molina", "Rocio", 22222222, "UNLa");
		sistema.agregarVisita("Martino", "Marcelo", 44444444, "Coop TIC");
		sistema.agregarEmpleado("Rodriguez", "Lucia", 11111111, 3840);
		System.out.println(sistema.getLstaPersona().toString());

		System.out.println("\n2)");
		System.out.println(sistema.traerPersona(1).toString());

		System.out.println("\n3)");

		try {
			sistema.agregarSeguridad(LocalDate.of(2021, 9, 1), LocalTime.of(7, 50), true, sistema.traerPersona(1));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		try {
			sistema.agregarSeguridad(LocalDate.of(2021, 9, 1), LocalTime.of(8, 00), true, sistema.traerPersona(2));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		try {
			sistema.agregarSeguridad(LocalDate.of(2021, 9, 1), LocalTime.of(18, 10), false, sistema.traerPersona(1));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		try {
			sistema.agregarSeguridad(LocalDate.of(2021, 9, 1), LocalTime.of(18, 20), false, sistema.traerPersona(2));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		try {
			sistema.agregarSeguridad(LocalDate.of(2021, 9, 2), LocalTime.of(9, 00), true, sistema.traerPersona(3));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		try {
			sistema.agregarSeguridad(LocalDate.of(2021, 9, 2), LocalTime.of(9, 10), true, sistema.traerPersona(4));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
//		Para intentar ver si funciona la Excepcion -> Funciona
//		try {
//			sistema.agregarSeguridad(LocalDate.of(2021, 9, 2), LocalTime.of(9, 10), true, sistema.traerPersona(4));
//		} catch (Exception e) {
//			System.err.println(e.getMessage());
//		}
		
		try {
			sistema.agregarSeguridad(LocalDate.of(2021, 9, 2), LocalTime.of(18, 10), false, sistema.traerPersona(3));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		try {
			sistema.agregarSeguridad(LocalDate.of(2021, 9, 2), LocalTime.of(18, 20), false, sistema.traerPersona(4));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		System.out.println("\n4)");
		List<Seguridad> lstSeg = new ArrayList<Seguridad>();
		lstSeg = sistema.traerSeguridad(LocalDate.of(2021, 9, 2), sistema.traerPersona(3));
		System.out.println(lstSeg.toString());

		System.out.println("\n4)");
		List<Seguridad> lstSeg2 = new ArrayList<Seguridad>();
		lstSeg2 = sistema.traerVisitas(LocalDate.of(2021, 9, 2));
		System.out.println(lstSeg2.toString());

	}

}
