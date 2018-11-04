package cauTrucDuLieuDanhSach.trienKhaiCacPhuongThucCuaArrayList;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object element[];
    public MyList(){
        element = (E[]) new Object[DEFAULT_CAPACITY];
    }
    public MyList(int capacity){
        element = (E[]) new Object[capacity];
    }
    public int size(){
        return size;
    }

    public void add(int index, E e){
        if (index < 0){
            System.out.println("The index " + index +" is out of range.");
            return;
        }
        if (index > 0  && element[index - 1] == null){
            {
                System.out.println("The index " + index +" is not valid.");
                return;
            }
        }
        if ( index >= size){
            ensureCapacity(2 * size);
        }
        for (int i = size - 1; i >= index  ; i--) {
            element[i + 1] = element[i];
        }
        element[index] = e;
        size++;
    }

    //Increase capacity to minCapacity
    public void ensureCapacity(int minCapacity){
        if(minCapacity > DEFAULT_CAPACITY){
            Object arr[] = (E[]) new Object[minCapacity];
            for (int i = 0; i < this.size; i++) {
                arr[i] = element[i];
            }
            element = arr;
        }
    }
    public Object clone(){
        Object[] temp = (E[]) new Object[this.size()];
        for (int i = 0; i < this.size(); i++){
            temp[i] = this.element[i];
        }
        return temp;
    }
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("[ ");
        for (int i = 0; i < this.size; i++) {
            stringBuilder.append(element[i]);
            if(i < size - 1){
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString() + "]";
    }
    public Object remove(int index){
        if (index < 0 || index >= size){
            System.out.println("The index " + index + " is out of range.");
            return null;
        }
        Object temp = element[index];
        for (int i = index; i < size; i++){
            element[i] = element[++i];
        }
        size--;
        return temp;
    }
    public boolean add(E e){
        if (e == null){
            return false;
        }
        for (int i = 0; i < this.size; i++) {
            if (element[i] == e){
                return false;
            }
        }
        add(size,e);
        return true;
    }
    public boolean contains(E o){
        for (int i = 0; i < size; i++){
            if (element[i] == o){
                return true;
            }
        }
        return false;
    }
    public int indexOf(E o){
        if(contains(o)){
            for (int i = 0; i < size(); i++){
                if (element[i] == o){
                    return i;
                }
            }
        }
        return -1;
    }


    public E get(int i){
        if (i < 0 || i >= size){
            System.out.println("The index " + i + " is out of range.");
            return null;
        }
        E temp = null;
        return (i >= 0 && i < size())? (E)element[i]: temp;
    }
    public void clear(){
        this.element = (E[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }
}
