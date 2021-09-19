package graphs_4;

interface ICalculator {

	public void add(int a, int b);
	public void subtract(int a, int b);
	public void multiply(int a, int b);
}    
class Calculator implements ICalculator {
	int a = 20;
	int b = 23;

	public void add(int a, int b) {
		System.out.println("a + b = " + (a + b));
	}
	
	public void subtract(int a, int b) {
	    System.out.println("a - b = "+ (a - b));
	}
	
	public void multiply(int a, int b) {
		System.out.println("a + b = " + (a * b));
	}

}


public class Calculater {

   public static void main(String[] args) {
	   
     Calculator cal = new Calculator();

     cal.add(5, 4);
     cal.subtract(6, 0);

   }
}
