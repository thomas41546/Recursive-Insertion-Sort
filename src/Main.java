import java.util.Random;


public class Main {

	/**
	 * @param args
	 */
	
	static void InsertionSort(int [] a){

		for(int unsortedIndex = 1; unsortedIndex < a.length; unsortedIndex++){
			int key = a[unsortedIndex];

			for(int sortedIndex = unsortedIndex-1; sortedIndex >= -1;sortedIndex--){
			
				if(sortedIndex == -1 || a[sortedIndex] < key){
					a[sortedIndex+1] = key;
					//printList(a);
					break;
				}
				
				//slide
				a[sortedIndex+1] = a[sortedIndex];
				//printList(a);
			}
		}
	}
	static void InsertionSortRecursion(int [] a,  int unsortedIndex, int key,  int sortedIndex){
		
		if(unsortedIndex <= a.length){
			
			if(sortedIndex == -1 && key == 0 ){
				if(unsortedIndex != a.length)
					InsertionSortRecursion(a, unsortedIndex +1,a[unsortedIndex],unsortedIndex-1);
			}
			else{
				if(sortedIndex == -1 || a[sortedIndex] < key){
					a[sortedIndex+1] = key;
					sortedIndex = 0;
					key = 0;
				}
				else{
					//slide
					a[sortedIndex+1] = a[sortedIndex];
				}
				InsertionSortRecursion(a,unsortedIndex,key,sortedIndex - 1);
				
			}
			
		}
	}
	
	// wrapper
	static void InsertionSortRecursive(int [] a){
		InsertionSortRecursion(a,1,0,-1);
	}
	
	static void printList(int [] a){
		for(int i=0; i < a.length; i++){
			System.out.print(", " + a[i]);
		}
		System.out.println("");
	}
	
	
	public static void main(String[] args) {
		int lista[]= new int[]{50,25,10,95,75,30,70,55,60,80};
		int listb[]= new int[]{50,25,10,95,75,30,70,55,60,80};
		
	    Random generator = new Random();
		
		for(int i =0; i < 10000; i++){
			
			for(int j=0; j < lista.length; j++)
				lista[j] =  listb[j] = generator.nextInt();
			
			InsertionSortRecursive(lista);
			InsertionSort(listb);
			
			for(int j=1; j < lista.length; j++){
				if(lista[j] < lista[j-1] || lista[j] != listb[j]){
					System.out.print("A: ");
					printList(lista);
					System.out.print("B: ");
					printList(listb);
					System.out.print("\n\n");
				}
			}
			

		}

		
		

	}

}
