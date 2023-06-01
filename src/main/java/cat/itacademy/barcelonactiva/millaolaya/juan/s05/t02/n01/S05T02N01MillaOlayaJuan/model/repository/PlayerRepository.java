package cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.repository;

import cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.entity.Player;
import org.springframework.data.mongodb.repository.MongoRepository;



import java.util.Optional;


public interface PlayerRepository extends MongoRepository <Player, Integer>{
    Optional<Player> findByName (String name);
}
