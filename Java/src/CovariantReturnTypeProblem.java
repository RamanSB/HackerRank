/**
 * Problem: https://www.hackerrank.com/challenges/java-covariance/problem
 */
public class CovariantReturnTypeProblem {

    //Complete the classes below
    class Flower {
        String whatsYourName(){
            return "I have many names and types.";
        }
    }

    class Jasmine extends Flower {
        @Override
        String whatsYourName(){
            return "Jasmine";
        }
    }

    class Lotus extends Flower {
        @Override
        String whatsYourName(){
            return "Lotus";
        }
    }

    class Lily extends Flower {
        @Override
        String whatsYourName(){
            return "Lily";
        }
    }

    class Region {

        Flower yourNationalFlower(){
            return new Flower();
        }
    }

    class WestBengal extends Region {
        @Override
        Flower yourNationalFlower(){
            return new Jasmine();
        }
    }

    class AndhraPradesh extends Region {
        @Override
        Flower yourNationalFlower(){
            return new Lily();
        }
    }
}
