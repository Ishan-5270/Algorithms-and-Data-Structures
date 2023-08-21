package Leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
public class ExchangeRate {

/**
 * The Main class implements an application that reads lines from the standard input
 * and prints them to the standard output.
 */
public class Main {
  
  // creating a hashmap to store the exchange rate between currencies 
  static HashMap<String, Double> rate = new HashMap<>();
  
  // we need to now parse the input and store the result in the hashmap
  public static void parseInput(String line){
    String[] currencies = line.split(";");
    // traversing through the currencies array 
    for(String currency: currencies){
      String[] pair = currency.split(",");
      // now we split the pair into 3 parts, the from,to and currency rate
      String from = pair[0];
      String to = pair[1];
      double erate = Double.parseDouble(pair[2]);
      // Storing the data into the hashmap
      rate.put(from + to, erate);
    }
  }
  
  public static double getMaxVal(String from, String to){
    // Hashset can be useful to track all the visited currencies without repetition 
    HashSet<String> visited = new HashSet<>();
    // 1 is default value of the exchange rate
    return getHelper(from, to, 1.0, visited);
  }
  
  public static double getHelper(String from, String to, double val, HashSet<String> visited){
    // Edge Case - if from is the same as to 
    if (from.equals(to)){
      return val; // 1 indicates the same value
    }
    
    // if visited hashset contains from we return -1 to avoid an infinite loop 
    if (visited.contains(from)) {
      return -1;
    }
    
    // Add the from currency to the visited set
    visited.add(from);
    // Initialize a variable to store the maximum value
    double max = -1;
    // Traverse through all the currencies that can be exchanged from the from currency 
    for (String key : rate.keySet()) {
      if (key.startsWith(from)) {
        // Retrive the newCurrency and the exchange rate
        String newCurrency = key.substring(3);
        double erate = rate.get(key);
        double newValue = val * erate;
        // Now we call the helper method recursively with the new currency, target currency, updated value, and visited set
        double result = getHelper(newCurrency, to, newValue, visited);
        // Perform this operation to get the max 
        if (result > max) {
          max = result;
        }
      }
    }
    // Remove the original currency from the visited set
    visited.remove(from);
    // Return the maximum value
    return max;
    
  }
  
  
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    
    line = in.readLine();
    // Storing the required data in the hashmap
    parseInput(line); 
    
    line = in.readLine();
    String[] input = line.split("\n");
    if (input.length >= 3){
      String source = input[1];
      String target = input[2];

      double result = getMaxVal(source, target);
      System.out.println(result);
    }
  }
}

}
