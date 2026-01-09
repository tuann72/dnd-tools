package com.example.application.dice;

import com.vaadin.flow.component.html.Div;
import lombok.Getter;

@Getter
public class DiceCountBadge extends Div {

  private int count;

  public DiceCountBadge(){
    getStyle().set("position", "absolute");
    getStyle().set("background-color", "rgba(180,180,180,0.8)");
    getStyle().set("text-align", "center");
    getStyle().set("top", "-8px");
    getStyle().set("right", "-8px");
    getStyle().set("border-radius", "50%");
    getStyle().set("font-color", "black");
    getStyle().set("font-size", "16px");
  }

  public void increment(){
    count++;
    getStyle().set("padding", "4px");
    setMinHeight("16px");
    setMinWidth("16px");
    setText(String.valueOf(count));
  }

  public void clear(){
    count = 0;
    getStyle().set("padding", "0px");
    setMinHeight("0px");
    setMinWidth("0px");
    setText("");
  }
}
