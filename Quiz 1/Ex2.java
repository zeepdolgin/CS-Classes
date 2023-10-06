public class Ex2 {
    public static void main(String[] args) {
        Animal an = new Animal(5, "Black");
        System.out.println(an.info());
        Animal cat = new Cat(3, "White", 10);
        System.out.println(cat.info());
        System.out.println("This animal makes the following sound: " + cat.make_noise());
        Animal cow = new Cow(2, "Weird", 8);
        System.out.println(cow.info());
        System.out.println("This animal makes the following sound: " + cow.make_noise());
    }
}
    
class Animal{
    public int age;
    public String color;

    public Animal(int age, String color){
        this.age = age;
        this.color = color;
    }

    public String make_noise() {
        return null;
    }

    public String info() {
        return("This animal is: " + age + " years old, and its color is: " + color);
    }
}

class Cat extends Animal{
    // adds another field to instrument
    public int level_of_cuteness;
    
    public Cat(int age, String color, int level_of_cuteness){
        super(age, color);
        this.level_of_cuteness = level_of_cuteness;
    }

    // adds another method

    @Override public String make_noise(){
        return("Meaw-Meaw");
    }

    // overrides the info method to include the number of strings:
    @Override public String info(){
        return(super.info() + ". The type of the animal is Cat, and its level of cuteness is: " + level_of_cuteness + ".");
    }
}
class Cow extends Animal{
    // adds another field to instrument
    public int level_of_cuteness;
    
    public Cow(int age, String color, int level_of_cuteness){
        super(age, color);
        this.level_of_cuteness = level_of_cuteness;
    }

    // adds another method

    @Override public String make_noise(){
        return("Mooo-Mooo");
    }

    // overrides the info method to include the number of strings:
    @Override public String info(){
        return(super.info() + ". The type of the animal is Cow, and its level of cuteness is: " + level_of_cuteness + ".");
    }
}