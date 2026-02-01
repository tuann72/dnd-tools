package com.example.application;

import com.example.application.dice.DiceMenu;
import com.example.application.dice.DiceService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class MainView extends VerticalLayout {

  @Autowired
  public MainView(DiceService diceService) {
    addClassName("centered-content");

    DiceMenu diceMenu = new DiceMenu(diceService);

    diceMenu.getStyle().set("position", "absolute");
    diceMenu.getStyle().set("bottom", "0");
    diceMenu.getStyle().set("left", "0");
    add(diceMenu);
  }
}
