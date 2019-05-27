package arrayList;

public class SeqList_test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ILinarList<Integer> test=new SeqList<Integer>(Integer.class,10);
		int [] data={23,45,3,7,6,945};
//		test.add(666);
		test.print();
		for(int i =0;i<data.length;i++){
			test.add(data[i]);
			
		}
		test.print();
		test.add(0, 888);
		System.out.println();
		test.print();
		System.out.println();
//		test.add(9, 888);
		test.add(7, 890);
		System.out.println();
		test.print();
		test.remove(4);
		System.out.println();
		test.print();
		test.get(4);
		System.out.println();
		System.out.println(test.get(4));
		test.clear();
		System.out.println(test.size());


	}

}
