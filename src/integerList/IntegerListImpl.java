package integerList;
import java.util.Arrays;

public class IntegerListImpl implements IntegerList {

    private Integer [] data;
    private int size = 0;

    public IntegerListImpl() {
        this.data = new Integer[]{};
    }

    @Override
    public Integer add(Integer item) {
        return add(size, item);
    }

    @Override
    public Integer add(int index, Integer item) {

        if (item == null) {
            throw new IllegalArgumentException("Item can not be null");
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index can not be out of size");
        }
        if (size + 1 > data.length) {
            grow();
        }
        System.arraycopy(data, index, data, index + 1, data.length - index-1);
        data[index] = item;
        size++;
        return item;
    }
    @Override
    public Integer set(int index, Integer item) {
        checkItem(item);
        checkIndex(index);
        data[index] = item;
        return item;
    }
    @Override
    public Integer remove(Integer item) {
        int i = indexOf(item);
        if (i == -1){
            throw new IllegalArgumentException("Item not exist");
        }
        remove(i);
        return item;
    }

    @Override
    public Integer remove(int index) {
        checkIndex(index);
        Integer e = data[index];
        data[index] = null;
        if (index < size - 1) {
            System.arraycopy(data, index + 1, data, index, size - 1);
        }
        size--;
        return e;
    }

    @Override
    public boolean contains(Integer item){
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(Integer item) {
        checkItem(item);
        for (int i = 0; i < size; i++) {
            if (data[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        checkItem(item);
        for (int i = size-1; i >= 0; i--) {
            if (data[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        checkIndex(index);
        return data[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (otherList == null){
            return false;
        }
        IntegerListImpl otherListImpl = (IntegerListImpl) otherList;
        if (otherListImpl.size != this.size){
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!this.data[i].equals(otherListImpl.data[i])){
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        Integer [] s = new Integer[size];
        System.arraycopy(data,0,s,0,size);
        return s;
    }
    private void grow() {
        data = Arrays.copyOf(data, data.length + 1);
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index can not be out of size");
        }
    }
    private void checkItem(Integer item){
        if (item == null) {
            throw new IllegalArgumentException("Item can not be null");
        }
    }

    public int containsBinary(Integer item){
        Integer [] array = toArray();
        sortArray(array);
        return binarySearch(array, item);
    }

    private  void sortArray(Integer[] array){
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i;
            while (j>0 && array[j-1]>=tmp){
                array[j]=array[j-1];
                j--;
            }
            array[j]=tmp;
        }
    }

    private int binarySearch(Integer[] array, int element){
      int min = 0;
      int max = array.length -1;
      while (min<=max){
          int mid = (min+max)/2;
          if (element == array[mid]){
              return mid;
          }
          if (element<array[mid]){
              max = mid - 1;
          } else {
              min = mid + 1;
          }
      }
      return -1;
    }

}
