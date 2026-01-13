package com.example.application.dice;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class DiceNotification{

  private final String header = "Roll";

  public DiceNotification(){
  }

  public void DiceMenuNotification(ArrayList<DiceResults> aggregateDiceResults){
    Div main = new Div();
    main.getStyle()
        .set("display", "flex")
        .set("flex-direction", "column")
        .set("gap", "1em")
        .set("padding", "1em");

    for(DiceResults diceResults : aggregateDiceResults){
      for(DiceRoll diceRolls : diceResults.getDiceRolls()){
        Div resultsDiv = new Div();
        StringBuilder resultString = new StringBuilder();
        String concatenatedValues = diceRolls.getValues().stream()
          .map(String::valueOf)
          .collect(Collectors.joining(" + "));

        resultString.append(String.format("%dd%d: %s = %d", diceResults.getCount(), diceResults.getSides(), concatenatedValues, diceRolls.getSum()));

        resultsDiv.setText(resultString.toString());

        if(diceRolls.isLargestRoll()) resultsDiv.getStyle().set("font-weight", "600");

        main.add(resultsDiv);
      }
    }

    Notification notification = new Notification();
    notification.setPosition(Notification.Position.MIDDLE);
    notification.setDuration(2500 * aggregateDiceResults.size());

    notification.add(main);
    notification.open();
  }
}
