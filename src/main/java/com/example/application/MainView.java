package com.example.application;

import com.example.application.dice.DiceMenu;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class MainView extends VerticalLayout {

  private final DiceMenu diceMenu;

  @Autowired
  public MainView(DiceMenu diceMenu) {
    this.diceMenu = diceMenu;

    addClassName("centered-content");
    add(diceMenu);
  }
}
