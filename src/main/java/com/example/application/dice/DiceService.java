package com.example.application.dice;

import java.util.ArrayList;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class DiceService {

  Random rand = new Random();

  public DiceResults roll(int count, int sides, int modifier, int numOfAdv){
    ArrayList<DiceRoll> listOfValues = new ArrayList<>();
    for(int i = 0; i <= numOfAdv; i++){
      DiceRoll diceRoll = new DiceRoll();
      ArrayList<Integer> temp = new ArrayList<>();
      int value;
      int sum = 0;
      for(int j = 0; j < count; j++) {
        value = rand.nextInt(sides) + 1 + modifier;
        temp.add(value);
        sum += value;
      }
      diceRoll.setValues(temp);
      diceRoll.setSum(sum);

      if(numOfAdv > 0 && !listOfValues.isEmpty()){
        for(DiceRoll previousRoll : listOfValues){
          if(previousRoll.isLargestRoll() && previousRoll.getSum() < diceRoll.getSum()){
            previousRoll.setLargestRoll(false);
            diceRoll.setLargestRoll(true);
          }
        }
      }
      else diceRoll.setLargestRoll(true);

      listOfValues.add(diceRoll);
    }

    return new DiceResults(listOfValues, modifier, numOfAdv, sides, count);
  }
}
