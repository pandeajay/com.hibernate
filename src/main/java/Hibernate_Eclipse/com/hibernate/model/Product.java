package Hibernate_Eclipse.com.hibernate.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * @author Admin
 *
 */

@Entity
@Table(name="producttable")
public class Product {

	@Id
	@Column(name="ProductId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="ProductName")
	private String name;
	
	public int getProductId() {
		return id;
	}

	public void setProductId(int productId) {
		this.id = productId;
	}

	public String getProductName() {
		return name;
	}

	public void setProductName(String productName) {
		this.name = productName;
	}

}