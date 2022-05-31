public enum Face {
    ZERO ("0"),
    ONE ("1"),
    TWO  ("2"),
    THREE("3"),
    FOUR ("4"),
    FIVE ("5"),
    SIX  ("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE ("9"),
    SKIP ("Skip"),
    REVERSE("Reverse"),
    WILD ("Wild");
  
    //The Values of the Enums
    private final String symbol;
    

    //Constructs Face
    Face(String symbol){
      this.symbol = symbol;
    }
  
    //Getters
    public String getFace(){
      return symbol;
    }

    public String toString(){
      return this.symbol;
    }
}
