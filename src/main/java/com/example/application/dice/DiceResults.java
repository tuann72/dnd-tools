package com.example.application.dice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiceResults {
  private ArrayList<DiceRoll> diceRolls;
  private int modifier;
  private int numOfAdv;
  private int sides;
  private int count;
}
