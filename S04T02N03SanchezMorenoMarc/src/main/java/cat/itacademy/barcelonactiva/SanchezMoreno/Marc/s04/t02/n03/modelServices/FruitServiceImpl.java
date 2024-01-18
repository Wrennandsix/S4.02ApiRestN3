package cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s04.t02.n03.modelServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s04.t02.n03.modelDomain.Fruit;
import cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s04.t02.n03.modelRepository.FruitRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class FruitServiceImpl implements FruitServices {
	
    @Autowired
    private FruitRepository fruitRepo;

    @Override
    public void addFruit(Fruit fruit) {
        fruitRepo.save(fruit);
    }

    @Override
    public void updateFruit(Fruit fruit) {
    	fruitRepo.save(fruit); 
    }

    @Override
    public void deleteFruit(int id) {
    	
        Optional<Fruit> fruit = fruitRepo.findById(id);
        if(fruit.isPresent()){
            fruitRepo.deleteById(id);
        }
        else{
            throw new EntityNotFoundException();
        }
    }

    @Override
    public Optional<Fruit> getFruitById(int id) throws EntityNotFoundException{
        Optional<Fruit> fruit = fruitRepo.findById(id);
        if(fruit.isPresent()){
            return Optional.ofNullable(fruit.get());
        }
        else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public List<Fruit> getAllFruit() {
        try{
            return fruitRepo.findAll();
        }
        catch (Exception ex){
            return new ArrayList<>();
        }
    }
}

