public class Assign1Part1Driver {
    public static void main(String[] args) {

       CircularDoublyLinkedList<Player> playersList = new CircularDoublyLinkedList<>();//Making a LinkedList of Players
        
       Player player1 = new Player("Simba");
       Player player2 = new Player("Nala");
       Player player3 = new Player("Kion");
       Player player4 = new Player("David");

       playersList.addLast(player1);
       playersList.addLast(player2);
       playersList.addLast(player3);
       playersList.addLast(player4);


       GameSim game = new GameSim(playersList);
    }
}
