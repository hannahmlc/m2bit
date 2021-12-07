package ss.week4;

public class ArrayExercises {
    public static int countNegativeNumbers(int[] arr) {
        int count = 0; //number of ngative vslues in arrary
        for( int i =0; i<arr.length; i++){
            if (arr[i] <0) count++;
        }
        return count;
    }

    public static void reverseArray(int[] ints) {
        int[] copy = ints.clone();
        int j = 0;
        for (int i = ints.length-1; i>=0;i--){
            ints[j] = copy[i];
                j++;
        }
    }

    class SimpleList {
        public class Element {}

        public class Node {
            public Node next;
            public Element element;
        }

        private Node first;

        private Node find(Element element) {
            Node p = first;
            if (p == null) {
                return null;
            }
            while (p.next != null && !p.next.element.equals(element)) {
                p = p.next;
            }
            if (p.next == null) {
                return null;
            } else {
                return p;
            }
        }

        public void remove(Element element) {
            Node p = find(element);
            if (p != null) {
                p.next = p.next.next;
            }
        }
    }
}
