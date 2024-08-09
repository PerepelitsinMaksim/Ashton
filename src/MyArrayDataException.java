public class MyArrayDataException extends ArrayStoreException {
    public int i;
    public int j;

    MyArrayDataException(int i, int j) {
        this.i = i;
        this.j = j;
    }
}