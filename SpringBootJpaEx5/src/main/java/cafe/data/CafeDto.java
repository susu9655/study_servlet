package cafe.data;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;


import lombok.Data;


@Entity
@Table(name = "cafe")
@Data
public class CafeDto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long num;
	
	@Column(name = "drink")
	private String drink;
	@Column(name = "price")
	private int price;

	@Column(name = "image")
	private String image;
	@Column(name = "description")
	private String description;
	
	@CreationTimestamp
	@Column(updatable = false)
	private Timestamp ipgoday;
}
