public class Taille {
    public int num;
    public EnumSize size;
    
    public Taille(int nb) {
    	num =nb;
    	size=null;
    }

    public Taille(EnumSize enumTaille) {
        num = 0;
        size = enumTaille;
    }
}