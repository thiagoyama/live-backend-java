package br.com.fiap.gamestore.controller;

import br.com.fiap.gamestore.model.Game;
import br.com.fiap.gamestore.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")//Define a URI do endpoint
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Game cadastrar(@RequestBody Game game){
        return gameService.cadastrar(game);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Game> listar(){
        return gameService.listar();
    }

    @GetMapping("{id}") //api/games/1
    @ResponseStatus(HttpStatus.OK)
    public Game buscarPorId(@PathVariable Long id){
        return gameService.buscarPorId(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Game atualizar(@PathVariable Long id, @RequestBody Game game){
        game.setCodigo(id); //seta o código que enviado pela URL
        return gameService.atualizar(game);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){
        gameService.remover(id);
    }

}
