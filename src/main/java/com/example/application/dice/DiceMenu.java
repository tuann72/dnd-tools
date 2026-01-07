package com.example.application.dice;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

public class DiceMenu extends HorizontalLayout {

  private DiceResults diceResults;

  private final DiceButtonWrapper d4 = new DiceButtonWrapper(4, this::onCountChanged, this::onClear);
  private final DiceButtonWrapper d6 = new DiceButtonWrapper(6, this::onCountChanged, this::onClear);
  private final DiceButtonWrapper d8 = new DiceButtonWrapper(8, this::onCountChanged, this::onClear);
  private final DiceButtonWrapper d10 = new DiceButtonWrapper(10, this::onCountChanged, this::onClear);
  private final DiceButtonWrapper d12 = new DiceButtonWrapper(12, this::onCountChanged, this::onClear);
  private final DiceButtonWrapper d20 = new DiceButtonWrapper(20, this::onCountChanged, this::onClear);
  private final Button RollDiceButton = new Button("Roll");

  @Autowired
  public DiceMenu(DiceService diceService){

    VerticalLayout verticalLayout = new VerticalLayout();

    Button diceMenuToggle = new Button(new Icon(VaadinIcon.MENU), e -> {
      toggleVisibility();
    });
    diceMenuToggle.setWidth("48px");
    diceMenuToggle.setHeight("48px");

    RollDiceButton.setVisible(false);
    RollDiceButton.setWidth("52px");
    RollDiceButton.setHeight("48px");
    RollDiceButton.addClickListener(e -> {});

//    Button check = new Button("check", e -> {
//      printValues();
//      printMod();
//      printAdv();
//    });

    verticalLayout.add(d4, d6, d8, d10, d12, d20, diceMenuToggle);
    add(verticalLayout, RollDiceButton);
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

  public void toggleVisibility(){
    d4.toggleVisibility();
    d6.toggleVisibility();
    d8.toggleVisibility();
    d10.toggleVisibility();
    d12.toggleVisibility();
    d20.toggleVisibility();

    d4.clearCount();
    d6.clearCount();
    d8.clearCount();
    d10.clearCount();
    d12.clearCount();
    d20.clearCount();
  }

  private void onCountChanged(){
    RollDiceButton.setVisible(true);
  }

  private void onClear(){
    RollDiceButton.setVisible(false);
  }
}
