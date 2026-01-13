package com.example.application.dice;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiceRoll {
  ArrayList<Integer> values;
  private int sum;
  private boolean isLargestRoll;
}
