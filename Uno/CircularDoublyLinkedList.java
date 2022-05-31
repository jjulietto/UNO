/**
 * ACS-2947-002 W2022 CircularlyDoublyLinkedList
 *
 * @author ACS-2947 Juliet Olive Yvette Garcia 3129145
 */



public class CircularDoublyLinkedList<E> {
    /*
     * The purpose of this class is to make a Doubly Linked List impelement a circular format
     * 
     */

    private static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setPrev(Node<E> p) {
            prev = p;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }// The End of Nested Node Class

    // Start of Doubly LinkedList

    private Node<E> dummy = null;
    private int size = 0;
    private boolean rev = false;

    // Constructs an empty list

    public CircularDoublyLinkedList() {
        dummy = new Node<>(null, dummy, null);

        // trailer = new Node<>(null, header, null);
        // header.setNext(trailer);
        dummy.setNext(dummy.getNext());
    }

    
    /** 
     * @return int
     */
    public int size() {
        return size;
    }

    
    /** 
     * @return boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

    
    /** 
     * @return E
     */
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return dummy.getNext().getElement();
    }

    
    /** 
     * @return E
     */
    public E last() {
        if (isEmpty()) {
            return null;
        }
        // return trailer.getPrev().getElement();
        return dummy.getElement();
    }

    
    /** 
     * @param e
     * @param predecessor
     * @param successor
     */
    // Adds Element E to the Linked List in Between Two Given Nodes

    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        // Creates and Links a New Node

        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    
    /** 
     * @param node
     * @return E
     */
    // Removes The Given Node from the list and returns its element

    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();

        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    
    /** 
     * @param e
     */
    // Add Element E to the front of the list

    public void addFirst(E e) {
        if (size == 0) {
            dummy = new Node<>(e, dummy, dummy);
            dummy.setNext(dummy);
            size++;
        } else {
            addBetween(e, dummy, dummy.getNext());
            // addBetween(e, header, header.getNext());
        }
    }

    
    /** 
     * @param e
     */
    public void addLast(E e) {
        // addBetween(e, trailer.getPrev(), trailer);

        addFirst(e);
        dummy = dummy.getNext();
        // addBetween(e, dummy.getPrev(),dummy);

    }

    
    /** 
     * @return E
     */
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        return remove(dummy.getNext());
    }

    
    /** 
     * @return E
     */
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        // return remove(trailer.getPrev());
        return remove(dummy);
    }

    // Update Methods Rotate & Reverse

    /** 
     * 
     * Rotate Method is used to rotate the list and the element at the "Head"
     * 
    */
    
    public void rotate() {  
     if (dummy != null) {
            if (!rev) {
                dummy = dummy.getNext();
            }
            if (rev) {
                dummy = dummy.getPrev();
            }
        }

    }

    
    /** 
     * Returns a value of type Boolean weather to change the rotation
     * 
     * @return boolean
     */
    public boolean reverse() {
        if (rev) {
            rev = false;
        } else {
            rev = true;
        }
        return rev;
    }

    
    /** 
     * Implemeneted a To String Method to Iterate through the List
     * @return String
     */
   

    public String toString() {
        StringBuilder str = new StringBuilder("[");

        Node<E> temp = dummy.getNext();
        int i = 0;
        while (size < i) {
            str.append(temp.getElement());
            if (temp != dummy) {
                str.append(" ");
            }
            temp = temp.getNext();
        }
        str.append("]");
        return str.toString();

    }

}// endClass
