package th_week9;

import java.util.Objects;

public class Product {
	private String productID;
	private String name;
	private String manufacture;
	private String description;
	
	private Supplier supplier;
	private double price;
	
	public Product(String productID, String name, String manufacture, String description, Supplier supplier,
			double price) {
		super();
		this.productID = productID;
		this.name = name;
		this.manufacture = manufacture;
		this.description = description;
		this.supplier = supplier;
		this.price = price;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String productID) {
		super();
		this.productID = productID;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufacture() {
		return manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(productID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(productID, other.productID);
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", name=" + name + ", manufacture=" + manufacture + ", description="
				+ description + ", supplier=" + supplier + ", price=" + price + "]";
	}
}
