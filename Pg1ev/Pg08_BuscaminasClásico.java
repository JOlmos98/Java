package Pg1ev;

import javax.swing.JOptionPane;

public class Pg08_BuscaminasClásico {

	public static void main(String[] args) {
		buscaminasclasico.gettablero();
		buscaminasclasico.bienvenida();
		buscaminasclasico.dowhilebuscaminas();
	}
}
//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////

//Clase y métodos:

class buscaminasclasico{
	
	//Variables:
	
	private static String [][] tablero={
			{"O","O","O","O","O","O","O","O",},
			{"O","O","O","O","O","O","O","O",},
			{"O","O","O","O","O","O","O","O",},
			{"O","O","O","O","O","O","O","O",},
			{"O","O","O","O","O","O","O","O",},
			{"O","O","O","O","O","O","O","O",},
			{"O","O","O","O","O","O","O","O",},
			{"O","O","O","O","O","O","O","O",}
	};
	private static int vidas=3;
	private static int interacciones=0;
	private static boolean victoria=false;
	private static int fila;
	private static int columna;
	private static int f;
	private static int c;
	
	//Métodos:
	
	public static void reiniciotablero() {
		for (int h=0;h<tablero.length;h++) {
			for (int z=0;z<tablero.length;z++) {
				tablero[h][z]="O";
			}
		}
	}
	public static void dowhilebuscaminas() {
		do {
			buscaminasclasico.entradafyc();
			buscaminasclasico.comprobacioncasilla();
			buscaminasclasico.interaccion();
			buscaminasclasico.tableroactual();
			buscaminasclasico.comprobacionvictoria();
			buscaminasclasico.victoria();
		} while (vidas>0);
		if (vidas==0) buscaminasclasico.hasperdido();
	}
	public static String [][] gettablero(){
		for (int i=0;i<tablero.length;i++) {
			for (int j=0;j<tablero.length;j++) {
				System.out.print("|"+tablero[i][j]);
			}
			System.out.println("|");
		}
		return tablero;
	}
	public static String [][] gettablerox(){
		
		for (int i=0;i<tablero.length;i++) {
			for (int j=0;j<tablero.length;j++) {
				System.err.print("|"+tablero[i][j]);
			}
			System.err.println("|");
		}
		return tablero;
	}
	public static int entradafila() {
		String entrada=JOptionPane.showInputDialog("Introduce la fila de la casilla:\n(Del 0 al 7)");
		fila=Integer.parseInt(entrada);
		return fila;
	}
	public static int entradacolumna() {
		String entrada=JOptionPane.showInputDialog("Introduce la columna de la casilla:\n(Del 0 al 7)");
		columna=Integer.parseInt(entrada);
		return columna;
	}
	public static int peticionf() {
		f=buscaminasclasico.entradafila();
		return f;
	}
	public static int peticionc() {
		c=buscaminasclasico.entradacolumna();
		return c;
	}
	public static void entradafyc() {
		do {
		buscaminasclasico.peticionf();
		buscaminasclasico.peticionc();
		if (f!=0&&f!=1&&f!=2&&f!=3&&f!=4&&f!=5&&f!=6&&f!=7||
			c!=0&&c!=1&&c!=2&&c!=3&&c!=4&&c!=5&&c!=6&&c!=7) JOptionPane.showMessageDialog(null, "Las coordenadas introducidas no son válidas.");
		} while (f!=0&&f!=1&&f!=2&&f!=3&&f!=4&&f!=5&&f!=6&&f!=7||c!=0&&c!=1&&c!=2&&c!=3&&c!=4&&c!=5&&c!=6&&c!=7);
	}
	public static void bomba(int fila, int columna) {
		tablero[fila][columna]="X";
		buscaminasclasico.reiniciotablero();
	}
	public static void espacio1() {
		tablero[0][5]=" ";
		tablero[0][6]=" ";
		tablero[0][7]=" ";
	}
	public static void espacio2() {
		tablero[3][0]=" ";
		tablero[4][0]=" ";
		tablero[5][0]=" ";
		tablero[6][0]=" ";
		tablero[6][1]=" ";
		tablero[7][0]=" ";
		tablero[7][1]=" ";
	}
	public static void espacio3() {
		tablero[4][6]=" ";
		tablero[4][7]=" ";
		tablero[5][4]=" ";
		tablero[5][5]=" ";
		tablero[5][6]=" ";
		tablero[5][7]=" ";
		tablero[6][5]=" ";
		tablero[6][6]=" ";
		tablero[6][7]=" ";
		tablero[7][5]=" ";
		tablero[7][6]=" ";
		tablero[7][7]=" ";
	}
	public static void setnumero1() {
		tablero[f][c]="1";
	}
	public static void setnumero2() {
		tablero[f][c]="2";
	}
	public static void comprobacioncasilla() {
		if (f==1&&c==1||f==1&&c==3||f==2&&c==6||f==3&&c==4||f==4&&c==2||f==7&&c==3) {
			buscaminasclasico.bomba(f, c);
			vidas--;
			JOptionPane.showMessageDialog(null, "¡Has tocado una bomba!\n Pierdes una vida.");
		}
		//Espacios:
		if (f==0&&c==5||f==0&&c==6||f==0&&c==7) buscaminasclasico.espacio1();
		if (f==3&&c==0||f==4&&c==0||f==5&&c==0||f==6&&c==0||f==6&&c==1||f==7&&c==0||f==7&&c==1) buscaminasclasico.espacio2();
		if (f==4&&c==6||f==4&&c==7||f==5&&c==4||f==5&&c==5||f==5&&c==6||f==5&&c==7||f==6&&c==5||f==6&&c==6||f==6&&c==7||f==7&&c==5||f==7&&c==6||f==7&&c==7) buscaminasclasico.espacio3();
		//Numeros 1:
		if (f==0&&c==0||f==0&&c==1||f==0&&c==3||f==0&&c==4||f==1&&c==0||f==1&&c==4||f==1&&c==5||f==1&&c==6||f==1&&c==7||f==2&&c==0||f==2&&c==1||f==2&&c==7||f==3&&c==1||f==3&&c==2||f==3&&c==6||f==3&&c==7||f==4&&c==1||f==4&&c==4||f==4&&c==5||f==5&&c==1||f==5&&c==2||f==5&&c==3||f==6&&c==2||f==6&&c==3||f==6&&c==4||f==7&&c==2||f==7&&c==4) buscaminasclasico.setnumero1();
		//Numeros 2:
		if (f==0&&c==2||f==1&&c==2||f==2&&c==2||f==2&&c==3||f==2&&c==4||f==2&&c==5||f==3&&c==3||f==3&&c==5||f==4&&c==3) buscaminasclasico.setnumero2();
	}
	public static void tableroactual() {
		if (vidas>0) buscaminasclasico.gettablero(); else buscaminasclasico.gettablerox();
	}
	public static void bienvenida() {
		JOptionPane.showMessageDialog(null, "Bienvenido al Buscaminas.\nGanarás cuando descubras todas las casillas sin minas. \nEl tablero se muestra en consola. \nTienes 3 vidas y hay 6 bombas, elige bien las casillas.\nAl perder una vida se reinicia el mapa.\n¡Buena suerte!");
	}
	public static void hasperdido() {
		JOptionPane.showMessageDialog(null, "¡Te has quedado sin vidas!\nHas perdido.");
	}
	public static void interaccion() {
		interacciones++;
		System.out.println("\n\n\nInteracciones: "+interacciones+"\nVidas: "+vidas);
	}
	public static void comprobacionvictoria() {
		if (tablero[0][5].equals(" ")&&tablero[0][6].equals(" ")&&tablero[0][7].equals(" ")&&tablero[3][0].equals(" ")&&tablero[4][0].equals(" ")&&tablero[5][0].equals(" ")&&tablero[6][0].equals(" ")&&tablero[6][1].equals(" ")&&tablero[7][0].equals(" ")&&tablero[7][1].equals(" ")&&tablero[4][6].equals(" ")&&tablero[4][7].equals(" ")&&tablero[5][4].equals(" ")&&tablero[5][5].equals(" ")&&tablero[5][6].equals(" ")&&tablero[5][7].equals(" ")&&tablero[6][5].equals(" ")&&tablero[6][6].equals(" ")&&tablero[6][7].equals(" ")&&tablero[7][5].equals(" ")&&tablero[7][6].equals(" ")&&tablero[7][7].equals(" ")&&
			tablero[0][0].equals("1")&&tablero[0][1].equals("1")&&tablero[0][3].equals("1")&&tablero[0][4].equals("1")&&tablero[1][0].equals("1")&&tablero[1][4].equals("1")&&tablero[1][5].equals("1")&&tablero[1][6].equals("1")&&tablero[1][7].equals("1")&&tablero[2][0].equals("1")&&tablero[2][1].equals("1")&&tablero[2][7].equals("1")&&tablero[3][1].equals("1")&&tablero[3][2].equals("1")&&tablero[3][6].equals("1")&&tablero[3][7].equals("1")&&tablero[4][1].equals("1")&&tablero[4][4].equals("1")&&tablero[4][5].equals("1")&&tablero[5][1].equals("1")&&tablero[5][2].equals("1")&&tablero[5][3].equals("1")&&tablero[6][2].equals("1")&&tablero[6][3].equals("1")&&tablero[6][4].equals("1")&&tablero[7][2].equals("1")&&tablero[7][4].equals("1")&&
			tablero[0][2].equals("2")&&tablero[1][2].equals("2")&&tablero[2][2].equals("2")&&tablero[2][3].equals("2")&&tablero[2][4].equals("2")&&tablero[2][5].equals("2")&&tablero[3][3].equals("2")&&tablero[3][5].equals("2")&&tablero[4][3].equals("2")) victoria=true;
	}
	public static void victoria() {
		if (victoria==true) {
			JOptionPane.showMessageDialog(null, "¡HAS GANADO!");
			System.exit(0);
		}
	}
}