
public class Card {

    private Colour colour;
    private Face face;

    // Constructors

    public Card(Colour colour, Face face) {
        this.colour = colour;
        this.face = face;
    }

    // Getters

    /** 
     * Gets the value of Colour
     * @return Colour
     */
  
    public Colour getColour() {
        return colour;
    }

    
    /** 
     * Gets the value of Face
     * @return Face
     */
    public Face getFace() {
        return face;
    }

    
    /** 
     * Sets the card to a certain colour value
     * @param colour
     */
    public void setColour(Colour colour) {
        this.colour = colour;
    }

    
    /** 
     * Sets the card to a certain face
     * @param face
     */
    public void setFace(Face face) {
        this.face = face;
    }

    
    /** 
     * If the Card matches
     * @param c
     * @return boolean
     */
    // Playable

    public boolean playable(Card c) {
        if (c.getColour() == this.getColour()) {
            return true;
        } else if (c.getFace() == this.getFace()) {
            return true;
        }
        return false;
    }

    
    /** 
     * To String
     * @return String
     */
    
    @Override
    public String toString() {
        return colour.getColour() + " " + face.getFace();
    }

}
