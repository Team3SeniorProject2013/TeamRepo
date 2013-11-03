//la
import java.util.*;
import java.io.*;
import java.math.*;
public class Space {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		while(true)
		{
			int k = 0;
			System.out.println("1 for prime, 2 for fibonnachi");
			switch(keyboard.nextInt()){
				case 1:
					System.out.println("k = ?");
					k = keyboard.nextInt();
					primeChecker(k);
					break;
				case 2:
					System.out.println("k = ?");
					k = keyboard.nextInt();
					fibonacci(k);
					break;
			
			}
			
			
			//fdasfdsafsd by Quang
			/*fsjadjkadfj;fadskljfds*/
		}

	}
	
	public static int fibonacci(int k)
	{
		
		return 0;
	}
	
	public static void primeChecker(int k)
	{
		System.out.println("primeChecker(" + k + ")\n\n");
		
		System.out.print("Prime number -> ");
		
		if(isPrime(k) == true)
		{
			System.out.println("Yes");
		}
		else
		{
			System.out.println("No");
		}
		
		System.out.print("Can this number be rearranged to make prime --> ");
		int numDigits = 3;
		int[] digits = new int[numDigits];
		
		for(int i = 1; i <  numDigits; i++)
		{
			digits[i] = k / ((int)Math.pow(10,(numDigits-i)));
		}
		digits[numDigits-1] = k%10;
		
		int a = k/100;
		int b = (k%100)/10;
		int c = k%10;

		swap(a,b,c);
		
		
	}	
	
	public static boolean swap(int a, int b, int c)
	{
		int l = 0;
		
		if(isPrime(a*100+c*10+b))
		{
			l = (a*100)+(c*10)+b;
			System.out.println("Yes: " + l);
			return true;
		}
		
		else if(isPrime(b*100+c*10+a))
		{
			l = (b*100)+(c*10)+a;
			System.out.println("Yes: " + l);
			return true;
		}
		
		else if(isPrime(b*100+a*10+c))
		{
			l = (b*100)+(a*10)+c;
			System.out.println("Yes: " + l);
			return true;
		}
		
		else if(isPrime(c*100+a*10+b))
		{
			l = (c*100)+(a*10)+b;
			System.out.println("Yes: " + l);
			return true;
		}
		
		else if(isPrime(c*100+b*10+a))
		{
			l = (c*100)+(b*10)+a;
			System.out.println("Yes: " + l);
			return true;
		}
		
		System.out.println("No");
		return false;
	}
	
	public static boolean isPrime(int k)
	{
		if(k%2 ==0 || k%3 == 0 || k%7 == 0 || k%11==0 || k%5 == 0 || k%13 == 0)
		{
			return false;
		}
		
		return true;
	}
}
