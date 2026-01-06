package com.example.application.dice;

import java.util.ArrayList;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class DiceService {

  Random rand = new Random();

  public DiceResults roll(int count, int sides, int modifier, int numOfAdv){
    ArrayList<ArrayList<Integer>> listOfValues = new ArrayList<>();

    for(int i = 0; i <= numOfAdv; i++){
      ArrayList<Integer> setOfRolls = new ArrayList<>();
      for(int j = 0; j < count; j++) setOfRolls.add(rand.nextInt(sides) + 1 + modifier);
      listOfValues.add(setOfRolls);
    }

    return new DiceResults(listOfValues, modifier, numOfAdv);
  }
}
