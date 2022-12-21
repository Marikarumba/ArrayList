package StringList;

import java.util.Arrays;

public class StringListImpl implements StringList {

    private String[] data;
    private int size = 0;

    public StringListImpl() {
        this.data = new String[]{};
    }

    @Override
    public String add(String item) {
        return add(size, item);
    }

    @Override
    public String add(int index, String item) {

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
    public String set(int index, String item) {
        checkItem(item);
        checkIndex(index);
        data[index] = item;
        return item;
    }
    @Override
    public String remove(String item) {
        int i = indexOf(item);
        if (i == -1){
            throw new IllegalArgumentException("Item not exist");
        }
        remove(i);
        return item;
    }

    @Override
    public String remove(int index) {
        checkIndex(index);
        String e = data[index];
        data[index] = null;
        if (index < size - 1) {
            System.arraycopy(data, index + 1, data, index, size - 1);
        }
        size--;
        return e;
    }

    @Override
    public boolean contains(String item){
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        checkItem(item);
        for (int i = 0; i < size; i++) {
            if (data[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        checkItem(item);
        for (int i = size-1; i >= 0; i--) {
            if (data[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        checkIndex(index);
        return data[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null){
            return false;
        }
        StringListImpl otherListImpl = (StringListImpl) otherList;
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
    public String[] toArray() {
        String [] s = new String[size];
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
    private void checkItem(String item){
        if (item == null) {
            throw new IllegalArgumentException("Item can not be null");
        }
    }
}

//исключения
//контейнс
//удаление по айтем
//эррэй
//1ю15
