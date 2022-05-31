import java.util.ArrayList;

public class Player {

  private String playerName;
  private ArrayList<Card> playerHand;

  // No Args Constructor
  public Player() {
    this.playerHand = new ArrayList<>();
    // playerName = null;

  }

  // Constructor
  public Player(String playerName) {
    playerHand = new ArrayList<>();
    this.playerName = playerName;
  }

  
  /** 
   * @return String
   */
  // Getter
  public String getPlayerName() {
    return playerName;
  }

  
  /** 
   * @return ArrayList<Card>
   */
  public ArrayList<Card> getHand() {
    return playerHand;

  }
  
  /** 
   * @return int
   */
  public int getHandSize() {
    return playerHand.size();
  }

  
  /** 
   * @param name
   */
  public void setPlayerName(String name){
    this.playerName = name;
  }

  public void playCard(Card c) { //Removes a Card from the Card list of the player
    playerHand.remove(c);
  }

  
  /** 
   * @param c
   */
  public void addCard(Card c) { //Adds a Card to the Card list for Player
    playerHand.add(c);
  }

  
  /** 
   * 
   * @return String
   */
  public String toString() { //Iterates through the player's hand 
    StringBuilder str = new StringBuilder("[");
    str.append(this.playerName);
    str.append(" hand: ");

    for (int i = 0; i < this.playerHand.size(); i++) {
      str.append(this.playerHand.get(i));
      if (i + 1 != this.playerHand.size()) {
        str.append(", ");
      }
    }
    str.append("]");
    return str.toString();

  }

}
