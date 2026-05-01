package br.com.fiap.gamestore.repository;

import br.com.fiap.gamestore.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game,Long> {

}
