package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner teclado = new Scanner(System.in);
		List<Product> products = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = teclado.nextInt();
		
		for(int i = 0; i < n; i++) {
			
			System.out.println();
			
			System.out.println("Product #" + (i+1) + " data:");
			
			System.out.print("Common, used, or imported (c/u/i)? ");
			char op = teclado.next().charAt(0);
			teclado.nextLine();
			
			switch (op) {
			
			case 'c':
		
				System.out.print("Name: ");
				String name = teclado.nextLine();
				
				System.out.print("Price: ");
				double price = teclado.nextDouble();
				
				Product product = new Product(name, price);
				products.add(product);
			
				break;
				
			case 'u':
				System.out.print("Name: ");
				name = teclado.nextLine();
				
				System.out.print("Price: ");
				price = teclado.nextDouble();
				
				System.out.print("Manufacture Date: ");
				teclado.nextLine();
				String manufactureDate = teclado.nextLine();
				
						
				product = new UsedProduct(name, price, sdf.parse(manufactureDate));
				products.add(product);
			
				break;
				
			case 'i':
				System.out.print("Name: ");
				name = teclado.nextLine();
				
				System.out.print("Price: ");
				price = teclado.nextDouble();
				
				System.out.print("Customs Fee: ");
				double customsFee = teclado.nextDouble();
				
				product = new ImportedProduct(name, price, customsFee);
				products.add(product);
				break;
			
				default: 
			
				System.out.println("Invalid Option!");
					break;
			
			}
						
		}
		
		System.out.println();
		System.out.println("***PRICE TAGS***");
		System.out.println();
		
		for(Product p : products) {
			System.out.println(p.priceTag());
		}
		
		teclado.close();
	}

}
