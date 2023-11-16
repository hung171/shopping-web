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
@Table(name = "user")
public class User {
	@Id()
	private String id;
	
	@Column(name = "login_Type", columnDefinition = "nvarchar(1111)")
	private String login_Type;
	
	@Column(name = "role", columnDefinition = "nvarchar(1111)")
	private String role;
	
	@Column(name = "password",columnDefinition = "nvarchar(1111)")
	private String password;
	
	@Column(name = "user_Name", columnDefinition = "nvarchar(1111)")
	private String user_Name;

	@Column(name = "avatar", columnDefinition = "nvarchar(1111)")
	private String avatar;
	
	@Column(name = "email", columnDefinition = "nvarchar(1111)")
	private String email;
	
	@Column(name = "phone_Number", columnDefinition = "nvarchar(1111)")
	private String phone_Number;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Order> order;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Cart> cart;
}
