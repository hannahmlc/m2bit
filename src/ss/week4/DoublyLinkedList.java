package ss.week4;

public class DoublyLinkedList<Element> {

    private int size;
    private Node head; //first node

    /**
     * @ensures the list is empty (size is 0)
     */
    public DoublyLinkedList() {
        size = 0;
        head = new Node(null);
        head.next = head;
        head.previous = head;
    }

    /**
     * Inserts a new Element at a given index in the list.
     * @requires element is not null
     * @requires the index to be within the bounds of the list
     * @ensures the size of the list to increase by one
     * @ensures the Element in the list at index index to be element
     * @param index The index at which to insert the Element
     * @param element The element to add
     */
    public void add(int index, Element element) {
        Node newNode = new Node(element);
        Node currentNode = getNode(index);

        newNode.next = currentNode;
        newNode.previous = currentNode.previous;
        newNode.next.previous = newNode; // not current.previous, be sure to access it through new node
        newNode.previous.next = newNode;

        size++;
    }

    /**
     * Removes an element at a given index
     * @requires the index to be within the bounds of the list
     * @ensures the size of the list to decrease by one
     * @param index the index to remove the element at 
     */
    public void remove(int index) {
        Node currentNode = getNode(index);

        currentNode.previous.next = currentNode.next;
        currentNode.next.previous = currentNode.previous;

        size --;
    }

    /**
     * @requires the index to be within the bounds of the list
     */
    public Element get(int index) {
        Node p = getNode(index);
        return p.element;
    }

    /**
     * The node containing the element with the specified index.
     * The head node if the specified index is -1.
     * @requires i to be between -1 and the size of the list
     */
    public Node getNode(int i) {
        Node p = head;
        int pos = -1;
        while (pos < i) {
            p = p.next;
            pos = pos + 1;
        }
        return p;
    }

    public int size() {
        return this.size;
    }

    public class Node {
        public Node(Element element) {
            this.element = element;
            this.next = null;
            this.previous = null;
        }

        private Element element;
        public Node next;
        public Node previous;

        public Element getElement() {
            return element;
        }
    }
}
