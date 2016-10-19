package com.crud.controller;

import com.crud.model.Videogame;
import com.crud.repository.VideogameRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Daniel on 18/10/2016.
 */

@RestController
@RequestMapping("api/")
public class VideogameController {

    @Autowired
    private VideogameRepository videogameRepository;

    @RequestMapping(value = "games", method = RequestMethod.GET)
    public List<Videogame> list() {
      return videogameRepository.findAll();
    }

    @RequestMapping(value = "games/{id}", method = RequestMethod.GET)
    public Videogame get(@PathVariable Long id) {
        return videogameRepository.findOne(id);
    }

    @RequestMapping(value = "games", method = RequestMethod.POST)
    public Videogame create(@RequestBody Videogame videogame) {
        return videogameRepository.saveAndFlush(videogame);
    }

    @RequestMapping(value = "games/{id}", method = RequestMethod.PUT)
    public Videogame update(@PathVariable Long id, @RequestBody Videogame videogame) {
        Videogame existingGame = videogameRepository.findOne(id);
        //copying videogame properties into existingGame object
        BeanUtils.copyProperties(videogame, existingGame);
        return videogameRepository.saveAndFlush(existingGame);
    }

    @RequestMapping(value = "games/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
         videogameRepository.delete(id);
    }

    @RequestMapping(value = "games/add/{title}", method = RequestMethod.GET)
    public Videogame add(@PathVariable String title) {
        Videogame newGame = new Videogame(null, title, "placeholder.png");
        return videogameRepository.saveAndFlush(newGame);

    }

}
