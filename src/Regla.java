import java.util.Arrays;
import java.util.Random;

public class Regla {

    public static final Boolean[][] patron = 
    {
    	{true,true,true},
    	{true,true,false},
    	{true,false,true},
    	{true,false,false},
    	{false,true,true},
    	{false,true,false},
    	{false,false,true},
    	{false,false,false}
    };
    
    
    public static final Boolean[] regla30 = {false,false,false,true,true,true,true,false};
    public static final Boolean[] regla90 = {false,true,false,true,true,false,true,false};
    public static final Boolean[] regla110 = {false,true,true,false,true,true,true,false};
    public static final Boolean[] regla130 = {true,false,false,false,false,false,true,false};
    public static final Boolean[] regla150 = {true,false,false,true,false,true,true,false};
    public static final Boolean[] regla184 = {true,false,true,true,true,false,false,false};
	public static final Boolean[] regla210 = {true,true,false,true,false,false,true,false};


    public static Boolean[][] primerPatron(Boolean[][] linea, Boolean RANDOM){
    	Boolean flag;
    	if(!RANDOM){
    		int choosen = (linea.length-1)/2;
    		for(int x = 0; x < linea.length; x++){
    			linea[x][0] = (x == choosen)?true:false;
    		}
    	}else{
    		Random r = new Random();
    		for(int x = 0; x < linea.length; x++){
    			flag = r.nextBoolean();
    			linea[x][0] = (flag==true)?true:false;
    		}
    	}
    	return linea;
    }
    
    public static Boolean[][] evalua(Boolean[][] area, int y,int numeroRegla){
    	int size = Automata.SIZE_X;
    	Boolean[] regla;
    	switch(numeroRegla){
    	case 30: regla = regla30; break;
    	case 90: regla = regla90; break;
    	case 110: regla = regla110; break;
    	case 130: regla = regla130; break;
    	case 150: regla = regla150; break;
    	case 184: regla = regla184; break;
    	case 210: regla = regla210; break;
    	default: regla = regla30;
    	}
    	Boolean[] subArray = { area[size-1][y], area[0][y], area[1][y] };
    	for(int x = 0; x < size; x++){
    		if(x == 0){
    			area[x][y+1] = aplicaRegla(subArray,regla);
    		}else if(x == size-1){
    			subArray[0] = area[x-1][y];
    			subArray[1] = area[x][y];
    			subArray[2] = area[0][y];
    			area[x][y+1] = aplicaRegla(subArray,regla);
    		}else{
    			subArray[0] = area[x-1][y];
    			subArray[1] = area[x][y];
    			subArray[2] = area[x+1][y];
    			area[x][y+1] = aplicaRegla(subArray,regla);
    		}
    	}
    	return area;
    }

    public static Boolean aplicaRegla(Boolean[] subArray, Boolean[] regla){
    	Boolean flag = false;
    	for(int i = 0; i <= 7; i++){
    		flag = Arrays.equals(Regla.patron[i],subArray);
    		if(flag){
    			return regla[i];
    		}
    	}
    	return false;
    }
}


