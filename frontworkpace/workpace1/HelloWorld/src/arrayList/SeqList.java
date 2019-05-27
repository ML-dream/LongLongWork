package arrayList;

import java.lang.reflect.Array;

public class SeqList <E> implements ILinarList<E> {
	private int maxsize;
	private E[] data;
	private int size;
	
	public SeqList(Class<E> type,int maxsize){
		this.maxsize=maxsize;
		data=(E[]) Array.newInstance(type,maxsize );
		size=0;
	}

	public boolean add(E item) {
		if(!isFull()){
			data[size++]=item;
			return true;
		}
		else{
			return false;
		}
	}

	public boolean isFull() {
		if(size==maxsize){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean add(int index, E item) {
//		try{
			if(index<0||index>size){//也就是说在这里，使其不能根据角标插入中间空位的值
			throw new IndexOutOfBoundsException("index:"+index+",size:"+size);
		}
			
//		}
//		catch(IndexOutOfBoundsException e){
//			System.out.println("shuzuyuejie");
//		}
		if(!isFull()){
			for(int i=size-1;i>=index;i--){
				data[i+1]=data[i];
			}
			data[index]=item;
			size++;
			return true;
		}
		return false;
	}

	public E remove(int index) {
		if(!isEmpty()){
			E oldValue=data[index];
			for(int i=index;i<size-1;i++){
				data[i]=data[i+1];
			}
			data[--size]=null;
			return oldValue;
		}else{
			return null;
		}
	}
//定位元素首次出现的位置！
	public int indexOf(E item) {
		if(item==null){
			for(int i=0;i<size;i++){
				if(data[i]==null){
					return i;
				}
			}
		}
		else{
			for(int i =0;i<size;i++){
				if(item.equals(data[i])){
					return i ;
				}
			}
		}
		return -1;
	}

	public E get(int index) {
		rangeCheck(index);
		return data[index];
	}

	public void rangeCheck(int x) {
		if(x<0||x>=size){
			throw new IndexOutOfBoundsException("你的数组越界了");
			
		}
	}

	public E set(int index, E item) {
		rangeCheck(index);
		E oldValue=data[index];
		data[index]=item;
		return oldValue;
	}

	public int size() {
		return size;
	}

	public void clear() {
		for(int i=0;i<size;i++){
			data[i]=null;
		}
		size=0;
	}

	public boolean isEmpty() {
		
		return size==0;
	}
	public void print(){
		for(int i=0;i<size;i++){
			System.out.print(data[i]+" ");
			
		}
	}

}
