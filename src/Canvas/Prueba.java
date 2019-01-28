package Canvas;

public class Prueba {

	public static void main(String[] args) {

		int[][] uno = new int[3][3];
		int[][] dos = new int[3][3];

		for (int i = 0; i < dos.length; i++) {
			for (int j = 0; j < dos.length; j++) {
				uno[i][j] = 2;
				System.out.println(uno[i][j]);
			}
		}
		
		dos = uno;
		
		for (int i = 0; i < dos.length; i++) {
			for (int j = 0; j < dos.length; j++) {
				System.out.println(dos[i][j]+1);
			}
		}

	}

}
