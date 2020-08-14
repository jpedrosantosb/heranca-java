package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		List <Employee> list = new ArrayList<>();
		
		System.out.print("Entre com o nº de funcionários por gentileza: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Employee #" + i + " data: ");
			System.out.print("O funcionário é terceirizado? (y/n)? ");
			char yn = sc.next().charAt(0);
			System.out.print("Nome do funcionário: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Horas: ");
			Integer hora = sc.nextInt();
			System.out.print("Valor por hora: ");
			double valuePerHours = sc.nextDouble();
			if (yn == 'y') {
				System.out.print("Adicional (110%): ");
				Double adicional = sc.nextDouble();
				Employee emp = new OutsourcedEmployee(nome, hora, valuePerHours, adicional);
				list.add(emp);
			}
			else {
				Employee emp = new Employee(nome, hora, valuePerHours);
				list.add(emp);
			}
		}
			System.out.println();
			System.out.println("PAYMENTS: ");
			for (Employee emp : list) {
				System.out.println(emp.getName() +  " - $ " + String.format("%.2f", emp.payment()));
			}
		
		
		sc.close();
	}

}
