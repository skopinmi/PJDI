package lesson1;

//Описать ошибки в коде и предложить варианты оптимизации:

public class Main2 {

    interface Moveable {
        void move();
    }

    interface Stopable {
        void stop();
    }

// дописал
    class Engine {
    }
// т.к метод move() имеется во всех наследниках (и в данной реализации идентичен) его можно перенести в класс родитель
    abstract class Car implements Moveable{
        public Engine engine;
        private String color;
        private String name;

        // из интерфейса Moveable
        @Override
        public void move(){
            System.out.println("Car is moving");
        }

        protected void start() {
            System.out.println("Car starting");
        }

        abstract void open();

        public Engine getEngine() {
            return engine;
        }

        public void setEngine(Engine engine) {
            this.engine = engine;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    class LightWeightCar extends Car {

        @Override
        void open() {
            System.out.println("Car is open");
        }

//      Методы из интерфейса Moveable в классах Lorry и LightWeightCar выполняют одно и тоже действие
//    можно имплементировать интерфейс в родительский класс и реализовать метод там
//        @Override
//        public void move() {
//            System.out.println("Car is moving");
//        }
    }
//    интерфейсы имплементируются ключевым словом  implements
//    было:
//    class Lorry extends Car, Moveable, Stopable{
//    стало:
    class Lorry extends Car implements Stopable{

//      Методы из интерфейса Moveable в классах Lorry и LightWeightCar выполняют одно и тоже действие
//    можно имплементировать интерфейс в родительский класс и реализовать метод там

//        public void move(){
//            System.out.println("Car is moving");
//        }

//      необходима аннотация
        @Override
        public void stop(){
            System.out.println("Car is stop");
        }
//      необходимо реализовать абстрактный метод open() из родительского класса
        @Override
        void open() {
            System.out.println("Lorry is open");
        }
    }

}
