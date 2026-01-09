package com.example.application.dice;

import com.vaadin.flow.component.html.Div;
import lombok.Getter;

@Getter
public class DiceButtonWrapper extends Div {

  private final DiceCountBadge diceCountBadge = new DiceCountBadge();
  private boolean isVisible = false;
  private int sides;
  private Runnable onCountChangeListener;
  private Runnable onClearListener;

  public DiceButtonWrapper(int sides, Runnable onCountChangeListener, Runnable onClearListener) {
    this.sides = sides;
    this.onCountChangeListener = onCountChangeListener;
    this.onClearListener = onClearListener;
    getStyle().set("position", "relative");
    getStyle().set("display", "inline-block");
    setVisible(isVisible);

    DiceButton button = new DiceButton(sides);

    button.addClickListener(e -> {
      diceCountBadge.increment();
      onCountChangeListener.run();
    });

    add(button, diceCountBadge);
  }

  public void toggleVisibility(){
    isVisible = !isVisible;
    setVisible(isVisible);
  }

  public void clearCount(){
    diceCountBadge.clear();
    onClearListener.run();
  }

  public int getDiceCount(){
    return diceCountBadge.getCount();
  }
}
