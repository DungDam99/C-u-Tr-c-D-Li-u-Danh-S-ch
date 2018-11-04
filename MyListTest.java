package cauTrucDuLieuDanhSach.trienKhaiCacPhuongThucCuaArrayList;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();
        myList.add(0,4);
        myList.add(0,3);
        myList.add(0,2);
        myList.add(0,1);
        myList.add(7,0);
        myList.remove(10);
//        if (myList.add(3)){
//            System.out.println("This is valid.");
//        }else{
//            System.out.println("This is not valid.");
//        }
//
//
//        if (myList.contains(4)){
//            System.out.println("Exist");
//        }else{
//            System.out.println("Do not exist.");
//        }


//        System.out.println("Index: " + myList.indexOf(10));

        System.out.println(myList.get(3));

        System.out.println(myList);
        System.out.println(myList.size());
    }
}
