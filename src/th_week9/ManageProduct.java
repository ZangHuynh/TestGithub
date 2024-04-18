package th_week9;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ManageProduct {
	private static final String FILEPATH = "data/test_XML.xml";
	private static DocumentBuilderFactory factory;
	private static DocumentBuilder builder;
	private static Document document;
	
	public ManageProduct() {
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			document = builder.parse(FILEPATH);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeXMLFile() {
		TransformerFactory factory = null;
		Transformer transformer = null;
		
		try {
			factory = TransformerFactory.newInstance();
			transformer = factory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(new DOMSource(document), new StreamResult(FILEPATH));
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
	
	public void printAll() {
		TransformerFactory factory = null;
		Transformer transformer = null;
		
		try {
			factory = TransformerFactory.newInstance();
			transformer = factory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(new DOMSource(document), new StreamResult(System.out));
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
	
	public void addProduct(Product pd) {
	    Element root = document.getDocumentElement();
	    
	    Element product = document.createElement("product");
	    product.setAttribute("productID", pd.getProductID());
	    
	    Element namePro = document.createElement("name");
	    product.appendChild(namePro);
	    namePro.setTextContent(pd.getName());
	    
	    Element manufacture = document.createElement("manufacture");
	    product.appendChild(manufacture);
	    manufacture.setTextContent(pd.getManufacture());
	    
	    Element description = document.createElement("description");
	    product.appendChild(description);
	    description.setTextContent(pd.getDescription());
	    
		    Element supplier = document.createElement("supplier");
		    product.appendChild(supplier);
		    
		    Element supName = document.createElement("name");
		    supplier.appendChild(supName);
		    supName.setTextContent(pd.getSupplier().getName());
		    
		    Element country = document.createElement("country");
		    supplier.appendChild(country);
		    country.setTextContent(pd.getSupplier().getCountry());
		    
		    Element website = document.createElement("website");
		    supplier.appendChild(website);
		    website.setTextContent(pd.getSupplier().getWebsite());
	    
	    Element price = document.createElement("price");
	    product.appendChild(price);
	    price.setTextContent(pd.getPrice() + "");
	    
	    root.appendChild(product);
	}

	
	public void deleteProduct(String pid) {
		Element root = document.getDocumentElement();
		NodeList pList = root.getElementsByTagName("product");
		for(int i = 0; i < pList.getLength(); i++) {
			Element pNode = (Element) pList.item(i);
			String productID = pNode.getElementsByTagName("productID").item(0).getTextContent();
			if(productID.equalsIgnoreCase(pid)) {
				System.out.println("Success");
				pNode.getParentNode().removeChild(pNode);
				break;
			}
		}
	}
	
	public void updatePrice(String pid, double newPrice) {
		Element root = document.getDocumentElement();
		NodeList pList = root.getElementsByTagName("product");
		for(int i = 0; i < pList.getLength(); i++) {
			Element pNode = (Element) pList.item(i);
			String productID = pNode.getElementsByTagName("productID").item(0).getTextContent();
			if(productID.equalsIgnoreCase(pid)) {
				Node priceNode = pNode.getElementsByTagName("price").item(0);
				priceNode.setTextContent(newPrice + "");
				break;
			}
		}
		
	}
}
