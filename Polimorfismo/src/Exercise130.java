import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Exercise130 {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Pessoa> pessoas = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char person = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Annual income: ");
			Double annualIncome = sc.nextDouble();
			
			if (person=='i') {
				System.out.print("Health expenditures: ");
				Double healthExpenditures = sc.nextDouble();
				pessoas.add(new PessoaFisica(name, annualIncome, healthExpenditures));
			} else {
				System.out.print("Number of employees: ");
				Integer employees = sc.nextInt();
				sc.nextLine();
				pessoas.add(new PessoaJuridica(name, annualIncome, employees));
			}
		}
		
		System.out.println();
		System.out.println("TAXES PAID:");
		
		Double totalTaxes = 0.0;
		
		for (Pessoa p : pessoas) {
			System.out.println(p.getName() + ": $ " + String.format("%.2f", p.calculateTax()));
			totalTaxes += p.calculateTax();
		}
		
		System.out.println();
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", totalTaxes));
		
		sc.close();
		
	}

}
