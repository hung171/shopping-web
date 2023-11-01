package WebProject.WebProject.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "outfit_product")
public class Outfit_Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private int quantity;

    @ManyToOne
    @JoinColumn(name = "outfit_id")
    private Outfit outfit;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


}
