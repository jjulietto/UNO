import java.util.ArrayList;
import java.util.Collections;

public class Deck {

  //Variables
  private ArrayList<Card> cards;
  private int maxNum = 100;

  public Deck() {
    this.cards = new ArrayList<>();
    createCards(maxNum);
  }// endConstructor

 
  /** 
   * @param values
   */
  private void createCards(int values) {
    // Creates 100 cards
    cards = new ArrayList<Card>();

    for (int j = 0; j < 2; j++) {
      for (Colour colour : Colour.values()) {
        if (colour != Colour.BLACK) {
          for (Face face : Face.values()) {
            if (face != Face.WILD) {
              cards.add(new Card(colour, face));
            }
          }
        }
      }
    
  }// EndFor
  for(int k = 0; k < 4; k++){
    Card card = new Card(Colour.BLACK, Face.WILD);
    cards.add(card);
  }
  }// endCreateCards

  
  /** 
   * @param c
   */
  public void shuffle(ArrayList<Card> c) {
    // Shuffles cards
    Collections.shuffle(cards);
  }

  
  /** 
   * @return int
   */
  public int getDeckSize(){
    return cards.size();
  }

  
  /** 
   * @return Card
   */
  public Card deal() {
    
    if (cards.size() == 0) {
     return null;
    }
  return cards.remove(cards.size() - 1);

  }

  
  /** 
   * @return Card
   */
  public Card startCard(){

    shuffle(cards);
    Card startCard = cards.get(0);

    if(cards.get(0).toString().contains("Wild")){
      System.out.println("Drawn Card for Deck was a wild card...Redrawing");
      shuffle(cards);
      startCard = cards.get(0);
    }

    return startCard;
 
  }

  
  /** 
   * @return String
   */
  @Override
  public String toString(){
    StringBuilder str = new StringBuilder("(");
    
    str.append(" Deck: ");

    for(int i = 0; i < this.cards.size(); i++){
      str.append(this.cards.get(i));
      if(i + 1 != this.cards.size()){
        str.append(", ");
      }
    }
    str.append("]");
    return str.toString();
  }
}// endMainClass
