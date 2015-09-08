class MyLinkedList<E> {
    
    @SuppressWarnings("rawtypes")
    private Node head;
    private int listCount;
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public MyLinkedList() {
        head = new Node(null);
        listCount = 0;
    }

    public Node getHead() {
        return head;
    }

    public void add(E data) {
        @SuppressWarnings("rawtypes")
        Node temp = new Node(data);
        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(temp);
        listCount++;
    }

    public void addElementAfter(E element , E elementAfter) {
        @SuppressWarnings("rawtypes")
        Node temp = new Node(element);
        Node current = head;
        Node reff = null;
        int flag = 0;  
        Node afterTemp = null;
        while (current.getNext() != null) {
            if(current.getData() == elementAfter) {
                reff = current;
                flag = 1;
                break;
            }
            current = current.getNext();
        }
        if(flag == 1) {
            temp.setNext(reff.getNext());
            reff.setNext(temp);
        }

        if(current.getNext() == null && current.getData() == elementAfter) {
            afterTemp = current;
            temp.setNext(afterTemp.getNext());
            afterTemp.setNext(temp);
        }

        listCount++;
    }

     public void addElementBefore(E element , E elementBefore) {

        Node temp = new Node(element);
        Node current = head;
        Node reff = null;
        Node beforeTemp = null;
        int  flag = 0;  
        while (current.getNext() != null) {
                beforeTemp = current;
            if(current.getNext().getData() == elementBefore) {
                reff = current;
                flag = 1;
                break;
            }
            current = current.getNext();
        }
        if(flag == 1) {
            temp.setNext(beforeTemp.getNext());
            beforeTemp.setNext(temp);
        }
        listCount++;
    }
 
    public void addAtIndex(E data, int index) {
        Node temp = new Node(data);
        Node current = head;
        for (int i = 1; i < index && current.getNext() != null; i++) {
            current = current.getNext();
        }
        temp.setNext(current.getNext());
        current.setNext(temp);
        listCount++;
    }
 
    public boolean
    removeAtIndex(int index)
    // removes the element at the specified position in this list.
    {
        if (index < 1 || index > size())
            return false;
 
        Node current = head;
        for (int i = 1; i < index; i++) {
            if (current.getNext() == null)
                return false;
 
            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());
        listCount--; 
        return true;
    }

    public  void removeElement(E element) {
        Node temp1 = null;
        Node current = head;
        Node reff = null;
        while (current.getNext() != null) {
            temp1 = current.getNext();
            /*if(current.getNext().getData() == element) {
                current.setNext(current.getNext().getNext());
                break;
            }*/
            if(temp1.getData() == element) {
                current.setNext(temp1.getNext());
                temp1 = null;
                break;
            }
            current = current.getNext();
        }
        
        listCount--;
    }
 
    public int size()
    // returns the number of elements in this list.
    {
        return listCount;
    }
 
    public String toString() {
        String output = "";
        if(head == null) {
            output = "List is Empty";
        } else {
            Node current = head.getNext();
            while (current != null) {
                output += current.getData() + "   " ;
                current = current.getNext();
            }
        }
        return output;
    }
    public void popFront() {
        head = head.getNext();
        removeAtIndex(0);
    }
    public void popBack() {
        removeAtIndex(listCount);
    }
    public void pushFront(E element) {
        addAtIndex(element,0);
    }
    public void pushBack(E element) {
        addAtIndex(element,listCount+1);
    }

    public void makeEmpty() {
        Node auxilaryNode = null;
        while (head != null) {
            auxilaryNode = head.getNext();
            head = null;
            head = auxilaryNode;
        }
    }

    public void addListAt(int index , MyLinkedList elements) {
        Node<E> temp = null ;
        Node current = head;
        int count = 0;
        while(current != null) {
            count++;
            if(count - 1 == index) {
                temp = current.getNext();
                current.setNext(elements.getHead().getNext());
                break;
            }
            current = current.getNext();
        }
        current = elements.getHead();
        while (current != null) {
            if(current.getNext() == null) {
                current.setNext(temp);
                break;
            }
        current = current.getNext();
        }
    }
    public void addList (E data , MyLinkedList elements) {
        Node<E> temp = null ;
        Node current = head;
        int count = 0;
        while(current != null) {
            count++;
            if(current.getData() == data) {
                temp = current.getNext();
                current.setNext(elements.getHead().getNext());
                break;
            }
            current = current.getNext();
        }
        current = elements.getHead();
        while (current != null) {
            if(current.getNext() == null) {
                current.setNext(temp);
                break;
            }
        current = current.getNext();    
        }
    }
}
class Node<E> {
    
    Node next;
    E data;
    @SuppressWarnings("unchecked")
    public Node() {
        next = null;
        data = null;
    }
    public Node(E dataValue) {
        next = null;
        data = dataValue;
    }

 
    public Node(E dataValue, Node nextValue) {
        next = nextValue;
        data = dataValue;
    }

    public E getData() {
        return data;
    }

    public void setData(E dataValue) {
        data = dataValue;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node nextValue) {
        next = nextValue;
    }

}


public class RamLinkedLisst {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<String>();
        MyLinkedList<String> list1 = new MyLinkedList<String>();

        list.add("10");
        list.add("20");
        list.add("30");
        list.addAtIndex("15",2);
        list.removeAtIndex(2);
        list.addElementAfter("15","10");
        list.addElementAfter("25","20");
        list.addElementBefore("1","10");
        list.addElementBefore("5","10");
        list.addElementAfter("100","30");
        list.removeElement("30");
        list.removeElement("100");
        /*list.popBack();
        list.popFront();
        list.pushFront("500");
        list.pushBack("1000");*/
        list1.add("purna");
        list1.add("ramesh");
        list1.add("bharath");
       // list1.popFront();
        list.addList("20",list1);

        //System.out.println(list1);
        //list.addListAt(1,list1);
        //System.out.println();
        //list.makeEmpty();
        System.out.println(list1);
        System.out.print(list);
       // System.out.print(list.get(3));
    }
}