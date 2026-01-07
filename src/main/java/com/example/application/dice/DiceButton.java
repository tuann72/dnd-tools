package com.example.application.dice;

import com.vaadin.flow.component.button.Button;

public class DiceButton extends Button {

  public DiceButton(int sides){

    setText("d" + String.valueOf(sides));
    setHeight("48px");
    setWidth("48px");
  }
}
