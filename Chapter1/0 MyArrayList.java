import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class MyArrayList {

	int[] array;
	int size;

	public MyArrayList() {
		array = new int[5];
		size = 0;

	}

	public MyArrayList(int size) {
		array = new int[size];
		this.size = 0;

	}

	public void add(int element) {
		if (size == array.length) {
			int[] bigArray = new int[2 * size];
			System.arraycopy(array, 0, bigArray, 0, size);
			array = bigArray;
		}

		array[size] = element;
		size++;
	}

	public void add(int index, int element) throws Exception {
		if (size == array.length) {
			int[] bigArray = new int[2 * size];
			System.arraycopy(array, 0, bigArray, 0, size);
			array = bigArray;
		}

		if (index < size) {
			System.arraycopy(array, index, array, index + 1, size - index );
		}
         
		if (index > size) {
			throw new Exception("Can not insert element at this index...!!!");
		}
		
		array[index] = element;
		size++;

	}

	public int getSize()
	{
		return size;
	
	}
	public void remove(int index) throws Exception {
		if (index >= size ||  index<0) {
			throw new Exception("No element at this index..!!!");
		}

		System.arraycopy(array, index + 1, array, index, size-index-1);
		array[size-1] = 0;
		size--;
	}

	public void removeElement(int element) throws Exception {
		remove(indexOf(element));
	}

	public int get(int index) throws Exception {
		if (index >= size ||  index<0) {
			throw new Exception("No element at this index..!!!");
		}

		return array[index];
	}

	public boolean contains(int element) {
		return (indexOf(element) != -1);
	}

	public int indexOf(int element) {
		for (int i = 0; i < size; i++) {
			if (array[i] == element) {
				return i;

			}

		}
		return -1;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public boolean isFull() {
		return (size == array.length);
	}

	public int size() {
		return size;
	}
	
	public String toString()
	{
	 return Arrays.toString(array);
	}
	

	public static void main(String[] args) {
		
		
		MyArrayList array1 = new MyArrayList();
		MyArrayList array2 = new MyArrayList(10);
		
		array1.add(5);
		array1.add(6);
		array1.add(7);
	    array1.add(11);
		try {
			array1.add(1,10);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		array1.add(40);
		System.out.println(array1);
		System.out.println("Size: "+array1.getSize());
		try {
			array1.remove(2);
			array1.remove(0);
			array1.remove(8);
			array1.removeElement(10);
			array1.removeElement(100);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(array1.indexOf(0));
		try {
			System.out.println(array1.get(1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try {
			array2.add(7,9);
			array2.add(3,5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(array1);
		System.out.println(array2);
		
		
		/*List<Integer> aJava = new ArrayList<Integer>();
		aJava.add(1);
		aJava.add(2);
		aJava.add(3);
		aJava.add(4);
		aJava.add(5);
		aJava.add(3,10);
	    System.out.println(aJava);*/	

	}

}
