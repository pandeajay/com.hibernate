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
public class ProductTable {

	@Id
	@Column(name="ProductId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productId;
	
	@Column(name="ProductName")
	private String productName;
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}