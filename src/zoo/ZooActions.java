package zoo;
import food.*;
import mobility.*;
import animals.*;
import plants.Cabbage;
import plants.Plant;
import utilities.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import java.util.Scanner;


/**
 * ZooActions - Class that represents what are the actions
 * the animals/pants in the zoo can take.
 */
public class ZooActions {
    /**
     * main - 1. which animal created, check poin
     *
     * @param args
     */
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("How many animals would you like to create ? ");
//        int num_of_Animals = sc.nextInt(); // taking size of animal array.
//        while (num_of_Animals < 3) { // Array size bigger than 3.
//            System.out.println("Invalid choice. Must be higher than3. \nHow many animals would you like to create ? ");
//            num_of_Animals = sc.nextInt(); // taking size of animal array.
//        }
//        Animal[] animals = animalBuilder(num_of_Animals); // creating array with the specified size.
//        //"Simba is in (X,Y), enter X and Y coordinates to move to"
//        for(Animal animal : animals){ // moving
//            ZooActions.move(animal,new Point());
//        }
//
//        for(int i =0; i<animals.length/2;i++){
//            Random random = new Random();
//            int randomAnimalIndex = random.nextInt(0,animals.length) ;
//            int randomAnimalIndex2 = random.nextInt(0,animals.length);
//
//            while(randomAnimalIndex == randomAnimalIndex2)
//                randomAnimalIndex2 = random.nextInt(0,animals.length);
//            ZooActions.eat(animals[randomAnimalIndex],animals[randomAnimalIndex2]);
//
//        }


//        Plant p = new Cabbage();
//        sc.close(); // closing scanner.
//        System.out.println("\nFeeding 1\n");
//        ZooActions.eat(animals[0],animals[1]);
//        System.out.println("\nFeeding 2\n");
//        ZooActions.eat(animals[1],animals[0]);
//        System.out.println("\nFeeding 3\n");
//        ZooActions.eat(animals[2],p);
//        System.out.println("\nFeeding 4\n");
//        ZooActions.eat(animals[1],p);
//        System.out.println("\nFeeding 5\n");
//        ZooActions.eat(animals[1],p);

//        /*Create Animal using reflection*/
//        Scanner sc = new Scanner(System.in);
//        Object zoo[] = new Animal[3];
//        Class c;
//        ClassLoader cl = ClassLoader.getSystemClassLoader(); //loading project classes
//        for (int i = 0; i < zoo.length; i++) {
//            System.out.println("What animal do you want?");
//            String type = sc.next();
//            System.out.println("how would you like to call it?");
//            String name = sc.next();
//            c = cl.loadClass("animals."+type); // loading class with full path including package
//            Constructor con = c.getConstructor(String.class);// getting ctor with string parameter
//
//            zoo[i] = (Animal) con.newInstance(name);// converting object instance to Animal instance and pointing with object reference
//
//            System.out.println(zoo[i]);
//
//
//        }
    }



    /**
     * eat - function receives any type of animal, checks which
     * animal it is, checks if it can eat the food received.
     *
     * @param animal animal checked
     * @param food   food checked
     * @return returns true if food was received else false.
     */
    public static boolean eat(Object animal, IEdible food) {
        if (animal instanceof Animal) {
            return ((Animal) animal).eat(food);

        }
        return false;// not an animal
    }

    /**
     * move - recieves any type of animal, checks which animal it is
     * uses checkBoundries to check if the point is in boundries,
     * if so calcs the distance between given animal and point and updates
     * current location of animal
     *
     * @param animal animal checked
     * @param point  point to move to
     * @return returns true if movement was possible, false otherwise.
     */
    public static boolean move(Object animal, Point point) {
        if (animal instanceof Animal temp_animal) {
            Scanner sc = new Scanner(System.in);
            System.out.println(temp_animal.getName() + " is in " + temp_animal.getLocation() + ", Enter X and Y coordinats to move to");
            int x = sc.nextInt();
            int y = sc.nextInt();
            point.setX(x);
            point.setY(y);
            boolean isSuccess = false;
            if(((Animal) animal).move(point) != 0)
                isSuccess = true;
            MessageUtility.logBooleanFunction(((Animal) animal).getName(), "move", point,isSuccess );
            return isSuccess; // Can not move to received point.
        }

        return false; // not an animal
    }


    private static Animal[] animalBuilder(int length) {
        Animal[] animal = new Animal[length];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < length; i++) {
            System.out.println("Which animal do you want at place " + (i + 1) + "?\n 1. Lion\n 2. Bear\n 3. Giraffe\n 4. Turtle\n 5. Elephant");
            int choice = sc.nextInt();
            System.out.println("Please choose name");
            String name = sc.next();
            System.out.println("Do you want to choose a starting point ?\n [0 for NO 1 for YES]\n ");
            Point p = new Point(-1, -1); // creating a point with (-1,-1) coordinate to check inputs.
            if (sc.nextInt() != 0) {
                System.out.println("Enter point by [X,Y]\n");
                p.setX(sc.nextInt()); // X coordinate
                p.setY(sc.nextInt());// Y coordinate
            }

            switch (choice) {
                case 1: // Lion case
                    if (Point.checkBoundaries(p))
                        animal[i] = new Lion(name, p);
                    else
                        animal[i] = new Lion(name);
                    break;
                case 2: // Bear
                    if (Point.checkBoundaries(p)) {
                        String color = "GRAY"; // getting color
                        System.out.println("Do you want to choose fur color ? [0 for NO 1 for YES]\n");
                        if (sc.nextInt() != 0) {
                            System.out.println(" options : 1. Black, 2. White, 3. Gray\n");
                            color = sc.next(); // getting color
                        }
                        animal[i] = new Bear(name, p, color);
                    } else
                        animal[i] = new Bear(name);
                    break;
                case 3:
                    if (Point.checkBoundaries(p)) {
                        double neck_length = 1.5;
                        System.out.println("Do you want to choose neck length? [0 for NO 1 for YES]\n");
                        if (sc.nextInt() != 0) {
                            System.out.println("Length is from 1 meter to 2.5 meters. Enter length in meters :\n");
                            neck_length = sc.nextDouble();
                        }
                        animal[i] = new Giraffe(name, p, neck_length);
                    } else
                        animal[i] = new Giraffe(name);
                    break;
                case 4:
                    if (Point.checkBoundaries(p)) {
                        int age = 1;
                        System.out.println("Do you want to choose age for the Turtle? [0 for NO 1 for YES]\n");
                        if (sc.nextInt() != 0) {
                            System.out.println("What age ? [1 to 500]\n");
                            age = sc.nextInt();
                        }
                        animal[i] = new Turtle(name, p, age);

                    } else
                        animal[i] = new Turtle(name);
                    break;
                case 5:
                    if (Point.checkBoundaries(p)) {
                        double trunk_length = 1;
                        System.out.println("Do you want to choose trunk length of the elephant ?[ 0 for NO 1 for YES]\n");
                        if (sc.nextInt() != 0) {
                            System.out.println("What length? [0.5 to 3 meters]\n");
                            trunk_length = sc.nextDouble();
                        }
                        animal[i] = new Elephant(name, p, trunk_length);
                    } else
                        animal[i] = new Elephant(name);
                    break;
                default:
                    System.out.println("You have entered an invalid choice, please try again.\n");
                    i--;
                    break;
            }

        }
        return animal;
    }
}
