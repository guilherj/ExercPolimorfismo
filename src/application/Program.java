package application;

import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		Product product = new Product("Notebook", 1000.00);
		
		System.out.println(product.priceTag());
		
		teclado.close();
	}

}
