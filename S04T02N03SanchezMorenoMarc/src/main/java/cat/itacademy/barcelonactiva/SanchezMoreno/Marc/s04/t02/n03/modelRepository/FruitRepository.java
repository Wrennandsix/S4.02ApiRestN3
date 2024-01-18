package cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s04.t02.n03.modelRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s04.t02.n03.modelDomain.Fruit;

public interface FruitRepository extends MongoRepository<Fruit, Integer> {

}
