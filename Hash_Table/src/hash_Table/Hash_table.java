package hash_Table;
import java.util.Arrays;

public class Hash_table {
	
	String[] theArray;
	int arraySize;
	int itemsInArray = 0;
	

public static void main(String[] args) {
	
	Hash_table theFunc = new Hash_table(30);
	
	//theFunc.hashFunction1(elementsToAdd, theFunc.theArray);
	
	String[] elementsToAdd2 = {"100", "510", "170", "214", "268", "398",
            "235", "802", "900", "723", "699", "1", "16", "999", "890",
            "725", "998", "978", "988", "990", "989", "984", "320", "321",
            "400", "415", "450", "50", "660", "624"};
	
	theFunc.hashFunction2(elementsToAdd2, theFunc.theArray);
	
	theFunc.findKey("320");
	
	theFunc.displayTheStack();
	
}

public void hashFunction1(String[] stringsForArray, String[] theArray) {
	
	for(int n = 0; n < stringsForArray.length; n++) {
		
		String newElementVal = stringsForArray[n];
		
		theArray[Integer.parseInt(newElementVal)] = newElementVal;
	}
}

public void hashFunction2(String[] stringsForArray, String[] theArray) {
	for (int n = 0; n < stringsForArray.length; n++) {
		
		String newElementVal = stringsForArray[n];
		
		int arrayIndex = Integer.parseInt(newElementVal) % 29;
		
		System.out.println("Modulus Index = " + arrayIndex + " for value " + newElementVal);
		
		while (theArray[arrayIndex] != "-1") {
			++arrayIndex;
			
			//System.out.println("Collision Try " + arrayIndex + " Instead");
			
			arrayIndex %= arraySize;
			
		}
		
		theArray[arrayIndex] = newElementVal;
	}
}

public String findKey(String key) {
	
	int arrayIndexHash = Integer.parseInt(key) % 30;
	
	while(theArray[arrayIndexHash] != "-1"){
		if(theArray[arrayIndexHash] == key) {
			
			System.out.println(key + " was found in index " + arrayIndexHash);
			
			return theArray[arrayIndexHash];
		}
		
		++arrayIndexHash;
		
		arrayIndexHash %= arraySize;
	}
	return null;
}

Hash_table(int size){
	arraySize = size;
	theArray = new String[size];
	Arrays.fill(theArray, "-1");
}

public void displayTheStack()	{
	int increment = 0;
	int i;
	int j;
	
	for (i = 0; i < 3; i++) {
		increment += 10;
		
		for (j = 0; j < 71; j++)
			System.out.print("-");
		System.out.println();
		
		for(j = increment - 10; j < increment; j++) {
		System.out.format("| %3s " + " ", j);
	}
	
	System.out.println("|");
	
	for(j = 0; j < 71; j++)
		System.out.print("-");
	System.out.println();
	
	for (j = increment - 10; j < increment; j++) {
		if (theArray[j].equals("-1"))
			System.out.print("|      ");
			
			else
				System.out.print(String.format("| %3s " + " ", theArray[j]));
			
	}
	
	System.out.println("|");
	
	for (j = 0; j < 71; j++)
		System.out.print("-");
	
	System.out.println();
}
}
}