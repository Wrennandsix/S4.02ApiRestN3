package cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s04.t02.n03.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s04.t02.n03.modelDomain.Fruit;
import cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s04.t02.n03.modelServices.FruitServices;


@RestController
public class FruitController {

	@Autowired
	private FruitServices fruitService;

	@PostMapping("/fruita/add")
	public ResponseEntity<String> addFruit(@RequestBody Fruit fruit) {
        fruitService.addFruit(fruit);		
		return new ResponseEntity<>(fruit.toString()+" succefully created in our database", HttpStatus.OK);
	}

	@PutMapping("/fruita/update/{id}")
	public ResponseEntity<String> updateFruit(@PathVariable int id, @RequestBody Fruit newFruit) {
		Optional<Fruit> presentFruit = fruitService.getFruitById(id);
		try {
			Fruit updatedFruit = presentFruit.get();
			updatedFruit.setName(newFruit.getName());
			updatedFruit.setQuantityKg(newFruit.getQuantityKg());

			fruitService.updateFruit(updatedFruit);

			return new ResponseEntity<>("fruit succefully updated, "+updatedFruit.toString(), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("fruit with id:"+id+", does not exist in our database",HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/fruita/delete/{id}")
	public ResponseEntity<String> deleteFruit(@PathVariable int id) {
		fruitService.deleteFruit(id);

		return new ResponseEntity<>("fruit with id:"+id+" succefully deleted",HttpStatus.OK);
	}

	@GetMapping("/fruita/getOne/{id}")
	public ResponseEntity<Fruit> getFruitById(@PathVariable int id) {

		Optional<Fruit> fruitFinded = fruitService.getFruitById(id);

		if (fruitFinded.isPresent()) {
			return new ResponseEntity<>(fruitFinded.get(), HttpStatus.OK);

		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/fruita/getAll")
	public ResponseEntity<List<Fruit>> getAllFruit() {
	    try {
	        List<Fruit> fruitList = new ArrayList<>();
	        fruitService.getAllFruit().forEach(fruitList::add);

	        if (fruitList.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        }

	        return new ResponseEntity<>(fruitList, HttpStatus.OK);
	    } catch (Exception ex) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}
