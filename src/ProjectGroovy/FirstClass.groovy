package ProjectGroovy

class FirstClass {
    Integer intA;
    Double doubB;
    Short shC;

    FirstClass(Integer a, Double b, Short c) {
        intA = a;
        doubB = b;
        shC = c;
    }

    void printSmth() {
        println(intA + " " + doubB + " " + shC)
    }

    Integer retInteger(arg) {
        Integer a = arg
    }

    int retInt(arg) {
        Integer a = arg
    }
}

