import java.util.ArrayList;
import java.util.Random;

public class GameSim {

    private CircularDoublyLinkedList<Player> playerHand;
    private Deck deck;
    private Card cardInPlay;
    private boolean win = false;
    private boolean wildCard = false;

    public GameSim(CircularDoublyLinkedList<Player> players) {
        playerHand = players;
        this.deck = new Deck();
        playGame();
    }

    private void playGame() {

        cardInPlay = deck.startCard();
        System.out.println("Let's play UNO!!!");
        System.out.println("First Card: " + cardInPlay);
        System.out.println("Deck Size: " + deck.getDeckSize());

        // SHOULD DEAL CARDS TO PLAYERS
        for (int i = 0; i < playerHand.size(); i++) {
            for (int j = 0; j < 7; j++) {
                Card take = deck.deal();
                playerHand.first().addCard(take);
            }
            playerHand.rotate();
        }

        do {
            // Current Player of List
            Player current = playerHand.first();
            ArrayList<Card> hand = current.getHand();
            System.out.println("\n " + current);

            for (int i = 0; i < current.getHandSize(); i++) {

                Card cardInHand = hand.get(i);

                if (cardInHand.playable(cardInPlay) || cardInHand.getFace() == Face.WILD) {// If Card matches the Card
                                                                                           // on top
                    current.playCard(cardInHand);
                    System.out.println("\n" + current.getPlayerName() + " plays " + cardInHand);
                    cardInPlay = cardInHand;
                    specialCards(cardInHand);
                    hasWild(hand);

                    if (current.getHandSize() == 1) { // If player hand is equal to 1
                        System.out.println(current.getPlayerName() + " yells UNO!");
                    }

                    break;
                }

                // Drawing a card and possibly playing it
                if (!cardInHand.playable(cardInPlay) && i + 1 == current.getHandSize()) {

                    Card deckCard = deck.deal();
                    current.addCard(deckCard);
                    System.out.println(current.getPlayerName() + " cannot play, draws " + deckCard);

                    if (deckCard.playable(cardInPlay)) {// IF The Card You Pulled is Playable
                        System.out.println(current.getPlayerName() + " plays " + deckCard);
                        current.playCard(deckCard);
                        specialCards(deckCard);

                        cardInPlay = deckCard;

                        if (current.getHandSize() == 1) {// If Playing the Card Makes You have one card
                            System.out.println(current.getPlayerName() + " yells UNO!");
                        }
                    } else {
                        System.out.println(current.getPlayerName() + " still cannot play " + deckCard);
                    }

                    break;

                }

            } // endFor

            playerHand.rotate();

        } while (!hasWon());
        System.out.println("Deck Size: " + deck.getDeckSize());

    }// PlayGameMethod

    /**
     * @return boolean
     */
    private boolean hasWon() {
        for (int i = 0; i < playerHand.size(); i++) {
            int size = playerHand.first().getHandSize();

            if (size == 0) {
                System.out.println("\n" + playerHand.first().getPlayerName() + " HAS WON!");
                return true;
            }
            playerHand.rotate();
            if (deck.getDeckSize() == 0) {
                System.out.println("\n" + "No One Won!");
                System.out.println("\n" + "Ran out of Cards!");
                return true;
            }
        }

        return false;
    }// EndMethod

    /**
     * @param hand
     */
    private void hasWild(ArrayList<Card> hand) {
        for (int j = 0; j < hand.size(); j++) {
            Card check = hand.get(j);
            if (check.getFace() == Face.WILD) {
                wildCard = true;
                wildColour(check);

            }
        }
        // specialCards(check);
        // return false;
    }

    /**
     * @param c
     */
    private void specialCards(Card c) {
        if (c.getFace() == Face.REVERSE) {
            System.out.println("Game Reverse Direction");
            playerHand.reverse();
        } else if (c.getFace() == Face.SKIP) {
            playerHand.rotate();
            System.out.println("\n" + playerHand.first().getPlayerName() + " misses their turn ");
        }
        //
        // wildCard
        if (c.getFace() == Face.WILD) {
            System.out.println("\n" + playerHand.first().getPlayerName() + " changes the colour ");
            wildColour(c);

        }
    }

    /**
     * @param c
     */
    private void wildColour(Card c) {
        Random num = new Random();
        int colour = num.nextInt(3);
        Colour[] colourWheel = Colour.values();
        cardInPlay.setColour(colourWheel[colour]);
        System.out.println("Colour is now " + colourWheel[colour]);
    }
}// endClass
