package com.alex.pruebagit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alex.pruebagit.model.Player;
import com.alex.pruebagit.repository.PlayerRepository;

@Controller
@RequestMapping("/players")
public class PlayerController {
    private final PlayerRepository plRep;
    
    public PlayerController(PlayerRepository plRep) {
        this.plRep = plRep;
    }

    @GetMapping
    public String listPlayers(Model m) {
        m.addAttribute("players", plRep.findAll());
        return "players/list";
    }

    @GetMapping("/new")
    public String showForm(Model m) {
        m.addAttribute("player", new Player());
        return "players/new";
    }

    @PostMapping
    public String savePlayer(@ModelAttribute Player player) {
        plRep.save(player);
        return "redirect:/players";
    }
}
