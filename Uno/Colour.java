public enum Colour {
    BLUE("Blue"),
    RED("Red"),
    GREEN("Green"),
    YELLOW("Yellow"),
    BLACK("Black");
  
    //The Values of the Enums
    private final String colour;
    
    //Constructor
    Colour(String c){
      this.colour = c;
    }
  
    //Getters
    public String getColour(){
      return colour;
    }

    public String toString(){
      return this.colour;  
    }

}
