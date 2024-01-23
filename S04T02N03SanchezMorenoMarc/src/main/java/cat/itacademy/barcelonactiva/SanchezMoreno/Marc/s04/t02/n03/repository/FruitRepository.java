package cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s04.t02.n03.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s04.t02.n03.domain.Fruit;

@Repository
public interface FruitRepository extends MongoRepository<Fruit, Integer> {

}
