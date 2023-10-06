// Iheritance example:

public class Ex1 {
    public static void main(String args[]){
        Guitar gt = new Guitar("guitar", 5, 7);
        gt.make_noise();
        System.out.println(gt.info());
    }
}
    
class Instrument{
    public String name;
    public int level_of_noise;

    public Instrument(String name, int level_of_noise){
        this.name = name;
        this.level_of_noise = level_of_noise;
    }

    public String info(){
        return("This is a: " + name + " and its level of noise is: " + level_of_noise);
    }
}

class Guitar extends Instrument{
    // adds another field to instrument
    public int num_of_strings;
    
    public Guitar(String name, int level_of_noise, int num_of_strings){
        super(name, level_of_noise);
        this.num_of_strings = num_of_strings;
    }

    // adds another method

    public void make_noise(){
        System.out.println("widdley-widdley");
    }

    // overrides the info method to include the number of strings:
    @Override public String info(){
        return(super.info() + ". It also has " + num_of_strings + " strings.");
    }
}

