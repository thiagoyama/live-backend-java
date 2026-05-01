package br.com.fiap.gamestore.service;

import br.com.fiap.gamestore.model.Game;
import br.com.fiap.gamestore.repository.GameRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired //injeção de dependência (o spring cria e coloca o objeto no atributo)
    private GameRepository gameRepository;

    public Game cadastrar(Game game){
        return gameRepository.save(game);
    }

    public Game buscarPorId(Long id){
        Optional<Game> optional = gameRepository.findById(id);
        if (optional.isPresent()){ //se ele encontrou um jogo (se não está vazio)
            return optional.get();
        }
        throw new EntityNotFoundException("Game não encontrado");
    }

    public List<Game> listar(){
        return gameRepository.findAll();
    }

    public Game atualizar(Game game){
        Optional<Game> optional = gameRepository.findById(game.getCodigo());
        if (optional.isPresent())
            return gameRepository.save(game);
        throw new EntityNotFoundException("Game não encontrado para atualização");
    }

    public void remover(Long id){
        Optional<Game> optional = gameRepository.findById(id);
        if (optional.isPresent())
            gameRepository.deleteById(id);
        else
            throw new EntityNotFoundException("Game não encontrado para a remoção");
    }

}
