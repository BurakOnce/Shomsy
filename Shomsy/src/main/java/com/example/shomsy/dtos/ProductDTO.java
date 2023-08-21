package com.example.shomsy.dtos;
import com.example.shomsy.entities.Category;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDTO {
    private Long pid;
    private String pname;
    private int price;

    @ManyToOne
    private Category category;

}
