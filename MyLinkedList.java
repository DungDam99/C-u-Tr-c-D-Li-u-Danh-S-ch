package cauTrucDuLieuDanhSach.trienKhaiCacPhuongThucCuaLinkedList;

public class MyLinkedList<E> extends Node {

    private Node head = null;
    private Node tail = null;
    private int numNodes = 0;

    public MyLinkedList(){

    }
    public MyLinkedList(Object data){
        head = new Node(data);
    }
    public void add(int index, E element){
        if (index < 0){
            System.out.println("The index " + index + " is not valid.");
            return;
        }
        if(index == 0){
           addFirst(element);
        }
        if(index >= numNodes){
            addLast(element);
        }else{
            Node current = head;
            for (int i = 1; i < index; i++){
                current = current.next;
            }
            Node temp = current.next;
            current.next = new Node(element);
            (current.next).next = temp;
            numNodes++;
        }

    }
    public void addFirst(E e){
        Node newNode = new Node(e);
        newNode.next = head;
        head = newNode;
        numNodes++;
        if (tail == null){
            tail = head;
        }
        return;
    }
    public void addLast(E e){
        Node newNode = new Node(e);
        if (tail == null){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        numNodes++;
    }
    public Object get(int i){
        if (i < 0 || i >= numNodes){
            System.out.println("The index" + i + " is not valid.");
            return null;
        }else{
            Node current = head;
            for (int j = 1; j <= i; j++) {
                current = current.next;
            }
            return current.data;
        }
    }



    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("[ ");
        Node current = head;
        for (int i = 0; i < numNodes; i++) {
            stringBuilder.append(current.data);
            current = current.next;
            if(i < numNodes - 1){
                stringBuilder.append(", ");
            }
        }
        return stringBuilder + " ]";
    }


    public boolean add(E e){
        if (e == null ){
            return false;
        }
        Node current = head;
        for (int i = 0; i < numNodes; i++) {
            if(current.data == e){
                System.out.println("The element is existed!");
                return false;
            }else{
                current = current.next;
            }
        }
        addLast(e);
        return true;
    }
    public E remove(int index){
        if (index < 0 || index >= numNodes){
            System.out.println("The index " + index + " is not valid.");
            return null;
        }
        if (numNodes == 0){
            System.out.println("Linked list is empty.");
            return null;
        }
        if (numNodes == 1){
            Node temp = head;
            head = tail = null;
            numNodes = 0;
            return (E) temp.data;
        }

        if (index == 0){
            Node temp = head;
            head = temp.next;
            numNodes--;
            if (head == null) tail = null;
            return (E) temp.data;
        }
        if (index == numNodes - 1){
            Node current = head;
            for (int i = 0; i < numNodes-2; i++) {
                current = current.next;
            }
            Node temp = tail;
            tail = current;
            tail.next = null;
            numNodes--;
            return (E) temp.data;
        }
        Node previous = head;
        for (int i = 0; i < index; i++) {
            previous = previous.next;
        }
        Node current = previous.next;
        previous.next = current.next;
        numNodes--;
        return (E) current.data;
    }

    public boolean remove(Object e){
        if (e == null){
            return false;
        }
        Node current = head;
        for (int i = 0; i < numNodes; i++) {
            if ( e == current.data){
                remove(i);
                return true;
            }else{
                current = current.next;
            }
        }
        return false;
    }
    public int size(){
        return numNodes;
    }
    public E clone(){
        MyLinkedList temp = new MyLinkedList();

        Node current = head;
        //current != null;
        do {
            temp.addLast(current.data);
            current = current.next;
        }while(current != null);
        return (E) temp;
    }
    /*for (Node<E> x = first; x != null; x = x.next)
            clone.add(x.item);*/
    public boolean contains(E o){
        if (o == null) {
            return false;
        }
        Node current = head;
        for (int i = 0; i < numNodes; i++) {
            if(current.data == o){
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public int indexOf(E o){
        if (contains(o)){
            Node current = head;
            for (int i = 0; i < numNodes; i++) {
                if(current.data == o){
                    return i;
                }
                current = current.next;
            }
        }
        return -1;
    }

    public E getFirst(){
        return (E) head.data;
    }
    public E getLast(){
        return (E) tail.data;
    }
    public void clear(){
        head = tail = null;
        numNodes = 0;
    }

}
