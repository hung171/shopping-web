package WebProject.WebProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "category_Name", columnDefinition = "nvarchar(1111)")
	private String category_Name;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Product> product;
}