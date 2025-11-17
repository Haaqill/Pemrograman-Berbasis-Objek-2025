public class Main
{
    public static void main(String[] args)
    {
        Human programmer = new Programmer("Alice");
        Human doctor = new Doctor("Bob");
        
        programmer.breath();
        programmer.grow();
        programmer.speak();

        doctor.breath();
        doctor.grow();
        doctor.speak();

        Animal dog = new Dog("Buddy");
        Animal bird = new Bird("Tweety");

        dog.breath();
        dog.grow();
        dog.move();

        bird.breath();
        bird.grow();
        bird.move();

        Plant rose = new FloweringPlant("Rose");
        Plant fern = new NonFloweringPlant("Fern");

        rose.breath();
        rose.grow();
        rose.photosynthesize();

        fern.breath();
        fern.grow();
        fern.photosynthesize();
    }
}