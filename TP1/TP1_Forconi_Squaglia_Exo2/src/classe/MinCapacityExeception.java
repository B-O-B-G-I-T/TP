package classe;

/**
 * MinCapacityExeception
 */
public class MinCapacityExeception extends Exception {

    public MinCapacityExeception(){
        super("Capacité minimal est de 0");
    }
    
}