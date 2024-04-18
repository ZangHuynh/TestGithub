package th_week9;

import java.util.Scanner;

public class Test {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int choice;
		ManageProduct dom = new ManageProduct();
		boolean flag = true;
		
		do {
			createMenu();
			choice = sc.nextInt();
			switch (choice) {
			case 1: {
				Product p = createProduct();
				dom.addProduct(p);
				break;
			}
			case 2: {
				System.out.print("Enter productID: ");
				String productID = sc.next();
				dom.deleteProduct(productID);
				break;
			}
			case 3: {
				System.out.print("Enter productID: ");
				String productID = sc.next();
				System.out.print("Enter price: ");
				Double price = sc.nextDouble();
				dom.updatePrice(productID, price);
				break;
			}
			case 4: {
				dom.printAll();
				break;
			}
			case 5: {
				dom.writeXMLFile();
				break;
			}
			default:
				flag = false;
				break;
			}
		} while (flag);
	}
	
	public static void createMenu() {
		System.out.println("=======MENU=======");
		System.out.println("1. Add product");
		System.out.println("2. Delete product");
		System.out.println("3. Update price");
		System.out.println("4. Print all");
		System.out.println("5. Write XML file");
		System.out.println("0. Exit");
		System.out.print("Your choice: ");
	}
	
	public static Product createProduct() {
		System.out.print("ProductID: ");
		String productID = sc.next();
		System.out.print("Name Product: ");
		String name = sc.next();
		System.out.print("Manufacture: ");
		String manu = sc.next();
		System.out.print("Description: ");
		String des = sc.next();
		Supplier sup = createSupplier();
		System.out.print("Price: ");
		Double price = sc.nextDouble();
		
		return new Product(productID, name, manu, des, sup, price);
	}
	
	public static Supplier createSupplier() {
		System.out.print("Name Supplier: ");
		String name = sc.next();
		System.out.print("Country: ");
		String country = sc.next();
		System.out.print("Website: ");
		String web = sc.next();
		
		return new Supplier(name, country, web);
	}
}
