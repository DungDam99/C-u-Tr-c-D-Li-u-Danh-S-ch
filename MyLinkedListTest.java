package cauTrucDuLieuDanhSach.trienKhaiCacPhuongThucCuaLinkedList;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.addFirst(7);
        myLinkedList.addFirst(6);
        myLinkedList.addLast(8);
        myLinkedList.add(2,3);
        myLinkedList.add(-1, 3);
        if (myLinkedList.add(3)){
            System.out.println("valid");
        }else{
            System.out.println("not valid");
        }

       System.out.println(myLinkedList.get(3));

        System.out.println(myLinkedList.remove(0));

        System.out.println(myLinkedList);
    }
}
