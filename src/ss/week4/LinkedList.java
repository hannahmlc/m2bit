package ss.week4;

public class LinkedList<Element> {

    private int size;
    private Node first;

    /**
     * @ensures the list is empty
     */
    public LinkedList () {
        size = 0;
        first = null;
    }

    public void add(int index, Element element) {
        Node newNode = new Node(element);
        if (index == 0) {
            newNode.next = first;
            first = newNode;
        } else {
            Node p = getNode(index-1);
            newNode.next = p.next;
            p.next = newNode;
        }
        size = size + 1;
    }

    /**
     * @ensures the size of the list has decreased by one
     * @param element the Element to remove
     */
    public void remove(Element element) {
        if(first.getElement().equals(element)){
            first = first.next;
        }else {
            Node before = findBefore(element);
            before.next = before.next.next;
        }
        size--;
    }

    public Node findBefore(Element element) {
        Node result = first;

        if (size > 0){
            while (result.next != null && !result.next.getElement().equals(element)){ //end of list or next element is what we look for
            result = result.next;
            }
            if(result.next == null) { //element not found in list
                return null;
            } return result;
        }else return null;
    }

    /**
     * @requires the index to be within the bounds of the list
     * @param index the index to get the element at 
     * @return the element at index index
     */
    public Element get(int index) {
        Node p = getNode(index);
        return p.element;
    }

    /**
     * @requires i to be within the bounds of the list
     * @param i the index to get the Node at
     * @return the Node at index i
     */
    private Node getNode(int i) {
        Node p = first;
        int pos = 0;
        while (pos != i) {
            p = p.next;
            pos = pos + 1;
        }
        return p;
    }

    /**
     * @ensures the result to be 0 or greater
     * @return the size of the list
     */
    public int size() {
        return size;
    }

    public class Node {
        private Element element;
        public Node next;

        public Node(Element element) {
            this.element = element;
            this.next = null;
        }

        public Element getElement() {
            return element;
        }
    }
}
