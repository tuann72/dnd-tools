package com.example.application.dice;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DiceMenu extends VerticalLayout {

  private final DiceService diceService;
  private DiceResults diceResults;

  @Autowired
  public DiceMenu(DiceService diceService){
    this.diceService = diceService;

    Button four_sided_dice = new Button("d4", e->{
      diceResults = diceService.roll(1,4,0,0);
    });

    Button check = new Button("check", e -> {
      printValues();
      printMod();
      printAdv();
    });

    add(four_sided_dice, check);
  }

  public void printValues(){
    System.out.println(diceResults.getValues());
  }

  public void printMod(){
    System.out.println(diceResults.getModifier());
  }

  public void printAdv(){
    System.out.println(diceResults.getNumOfAdv());
  }
}
