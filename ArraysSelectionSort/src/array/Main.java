package array;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Hello, dear user.");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("This small program will create an array.");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("After that, you will be able to check in what position your array was originally stored.");
		TimeUnit.SECONDS.sleep(2);
		System.out.println("Well then. Let's begin.");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("Type the number (int) of the array you wish to create: ");
		try (Scanner leitor = new Scanner(System.in)) {
			int size = leitor.nextInt();
			System.out.println("The array size is : " + size);
			createArray(size);
		} catch (InputMismatchException e) {
	        System.out.println("You need to type an integer value.");
	        System.out.println("And you didn't!");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("So now this program is done.");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("Bye!");
			System.exit(0);
	    }
	}

	private static void createArray(int numbers) throws InterruptedException { 
		int [] array = new int [numbers];
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < array.length; i++) {
			System.out.println("Type one number for each position: ");
			int number = scan.nextInt();
			array[i] = number;
		}
		System.out.println("Array list in the given order:");
		printArray(array);
		int result = -1;
		int start = 0;
		int end = array.length -1;
		int mid = 0;
	
		System.out.println("Now, type the number you wish to search: ");
		int target = scan.nextInt();
		binarySearch(array, start, end, target);
		

		}
	
	public static int binarySearch(int[] array, int start, int end, int target) throws InterruptedException {
		int result = -1;
		int middle = 0;
		while (start <= end) {
			middle = (start + end) / 2;
			if(array[middle] < target) {
				return binarySearch(array, middle+1, end, target);
			} else if (array[middle] > target) {
				end = middle - 1;
			} else if (array[middle] == target){
				result = middle;
				break;
			}
		}
		if (result < 0) {
			System.out.println("The element could not be found!");
		} else {
			System.out.println(String.format("The number %d is in the position %d.", target, result));
			TimeUnit.SECONDS.sleep(1);
			System.out.println("Thank you for using this program!");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("Bye!");
			System.exit(0);
		}
		return -1;
			}

	public static void printArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
}

