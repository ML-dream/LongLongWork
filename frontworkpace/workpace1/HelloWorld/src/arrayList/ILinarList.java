package arrayList;

public interface ILinarList<E> {
	boolean add(E item);
	boolean add(int index,E item);
	E remove (int index);
	int indexOf(E item);
	E get(int index);
	E set(int index,E item);
	int size();
    void clear();
    boolean isEmpty();
    public void print();
	

}
