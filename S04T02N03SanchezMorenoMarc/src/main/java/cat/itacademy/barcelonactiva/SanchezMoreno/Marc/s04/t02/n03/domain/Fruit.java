package cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s04.t02.n03.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Data
@Document(collection = "fruits")
public class Fruit {
	  
	@Id
	private int id;

	private String name;
	
	private int quantityKg;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantityKg() {
		return quantityKg;
	}

	public void setQuantityKg(int quantityKg) {
		this.quantityKg = quantityKg;
	}
	
	@Override
	public String toString() {
		return "Fruit [id:" + id + ", name:" + name + ", quantityKg:" + quantityKg + "]";
	}

}
