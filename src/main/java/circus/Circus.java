package circus;

import circus.animal.*;
import circus.equipment.Equipment;
import circus.equipment.Cannon;
import circus.equipment.Ladder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Circus {
    private static Animal[] animals = {
            new Duck("Drake"),
            new Parrot("Polly"),
            new Tiger("Tai Lung")
    };
    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
    }

    private static int calculateAssetValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }
            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println("Number of animals in the circus: " + animals.length);

        ArrayList<Animal> animalArrayList = new ArrayList<>(Arrays.asList(animals));
        animalArrayList.add(new Elephant("StrongOne"));
        System.out.println("Number of animals in the circus: " + animalArrayList.size());
        printAllAnimals(animalArrayList);

        Parrot andy  = new Parrot("Andy");
        animalArrayList.add(andy);
        printAllAnimals(animalArrayList);
        System.out.println("Number of animals in the circus: " + animalArrayList.size());

        Animal candidate = findAnimalReference(animalArrayList, "Andy");
        System.out.println("Index of Andy: " + animalArrayList.indexOf(candidate));

        System.out.println("\n\n BEFORE SORTING");
        printAllAnimals(animalArrayList);
        animalArrayList.sort(Animal.animalNameComparator);
        System.out.println("\n\n AFTER SORTING");
        printAllAnimals(animalArrayList);
    }

    /*
    Prints all animals in the array list (of type Animal)
     */
    private static void printAllAnimals(ArrayList<Animal> animalArrayList) {
        for (Animal a: animalArrayList){
            System.out.println(a);
        }
    }

    private static Animal findAnimalReference(ArrayList<Animal> animals, String nameOfAnimal){
        for (Animal a: animals){
            if (a.name == nameOfAnimal){
                return a;
            }
        }
        return null;
    }
}