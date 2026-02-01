package com.example.application.dice;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class DiceMenu extends HorizontalLayout {

  private final ArrayList<DiceResults> aggregatedDiceResults = new ArrayList<>();

  private final DiceButtonWrapper d4 = new DiceButtonWrapper(4, this::onCountChanged, this::onClear);
  private final DiceButtonWrapper d6 = new DiceButtonWrapper(6, this::onCountChanged, this::onClear);
  private final DiceButtonWrapper d8 = new DiceButtonWrapper(8, this::onCountChanged, this::onClear);
  private final DiceButtonWrapper d10 = new DiceButtonWrapper(10, this::onCountChanged, this::onClear);
  private final DiceButtonWrapper d12 = new DiceButtonWrapper(12, this::onCountChanged, this::onClear);
  private final DiceButtonWrapper d20 = new DiceButtonWrapper(20, this::onCountChanged, this::onClear);
  private final Button RollDiceButton = new Button("Roll");

  @Autowired
  public DiceMenu(DiceService diceService){
    setSpacing("0px");

    VerticalLayout mainDiceLayout = new VerticalLayout();
    mainDiceLayout.getStyle().set("padding", "1rem 1rem");

    VerticalLayout sideDiceLayout = new VerticalLayout();
    sideDiceLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.END);
    sideDiceLayout.getStyle().set("padding", "1rem 0");

    Button diceMenuToggle = new Button(new Icon(VaadinIcon.MENU), e -> {
      toggleVisibility();
    });
    diceMenuToggle.setWidth("48px");
    diceMenuToggle.setHeight("48px");

    RollDiceButton.setVisible(false);
    RollDiceButton.setWidth("52px");
    RollDiceButton.setHeight("48px");
    RollDiceButton.addClickListener(e -> {
      aggregateDice(diceService);
      displayDiceResults();
    });

    mainDiceLayout.add(d20, d12, d10, d8, d6, d4, diceMenuToggle);
    sideDiceLayout.add(RollDiceButton);
    add(mainDiceLayout, sideDiceLayout);
  }
  private void aggregateDice(DiceService diceService){
    aggregatedDiceResults.clear();
    if(d4.getDiceCount() > 0){aggregatedDiceResults.add(diceService.roll(d4.getDiceCount(), d4.getSides(), 0, 0));}
    if(d6.getDiceCount() > 0){aggregatedDiceResults.add(diceService.roll(d6.getDiceCount(), d6.getSides(), 0, 0));}
    if(d8.getDiceCount() > 0){aggregatedDiceResults.add(diceService.roll(d8.getDiceCount(), d8.getSides(), 0, 0));}
    if(d10.getDiceCount() > 0){aggregatedDiceResults.add(diceService.roll(d10.getDiceCount(), d10.getSides(), 0, 0));}
    if(d12.getDiceCount() > 0){aggregatedDiceResults.add(diceService.roll(d12.getDiceCount(), d12.getSides(), 0, 0));}
    if(d20.getDiceCount() > 0){aggregatedDiceResults.add(diceService.roll(d20.getDiceCount(), d20.getSides(), 0, 0));}
  }

  private void displayDiceResults(){
    DiceNotification diceNotification = new DiceNotification();
    diceNotification.DiceMenuNotification(aggregatedDiceResults);
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
