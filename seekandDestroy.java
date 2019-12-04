import java.util.*;

public class seekandDestroy {

	public static Scanner con = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] data = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '9', '8'}};
		System.out.println("Data:");
		for(int n=0; n<3; n++) {
			for(int m=0; m<3; m++) {
				System.out.print(data[n][m]+" ");
			}
			System.out.println();
		}
		System.out.print("Digit? = ");
		while(!con.hasNextInt()) {
			validity.nonInteger(con);
		}
		int input=con.nextInt();	
		boolean valid=false;
		do {

			if (input<1||input>9) {

				input=validity.invalidDigit(con);
				System.out.println(input);
			}
			else {
				valid = true;
			}
		}while(valid==false);
		int digit = input;
		char ch = (char) (digit+48);
		boolean found = false;
		do {
			for (int i=0;i<3;i++) {
				for(int j=0;j<3;j++)
					if (ch==data[i][j]) {
						found=true;
						data[i][j]='X';
					}
			}

		}  while(found==false);
		System.out.println("Found at X:");
		for(int n=0; n<3; n++) {
			for(int m=0; m<3; m++) {
				System.out.print(data[n][m]+" ");
			}
			System.out.println();
		}
	}

}







