import javax.swing.*;

public class Automata extends JFrame{

    public static final int SIZE_X = 1350;
    public static final int SIZE_Y = 700;
    public Boolean PATRON_RANDOM;
    public int NUMERO_DE_REGLA;
    
    public Automata(){
    	setTitle("Automata");
    	setSize(SIZE_X+1,SIZE_Y);
    	setResizable(false);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setLocationRelativeTo(null);
    }
    public void mostrar(){
    	add( new Lienzo(SIZE_X+1,SIZE_Y,PATRON_RANDOM,NUMERO_DE_REGLA));
    	setVisible(true);
    }
}