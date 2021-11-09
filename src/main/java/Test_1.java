import java.util.Random;

class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }
}

class Variables {
    public static void main(String[] args) {
        int first;
        int second = 10;
        first = second * 3 * 5;
        System.out.println(first);
        System.out.println(second);
    }
}

class ComparisonShort {
    public static void main(String[] args) {
        int i = 10 + 2;
        if (i == 10) {
            System.out.println("i = 10");
        } else {
            System.out.println("i != 10");
        }
    }
}

class CycleFor {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
    }
}

class CycleForeach {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        for (int a : arr) {
            System.out.println(a);
        }
    }
}

class RandomInt {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            //nextInt(10) - ограничивает диапазон генерир. чисел(от 0 до 9)
            System.out.println(random.nextInt(10) + " ");
        }
    }
}

class Arrays {
    public static void main(String[] args) {
        int[] arr = new int[5];
        int[] arrInit = {1, 2, 3, 4, 5};
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 2 + arrInit[i];
        }
        for (int a : arr) {
            System.out.println(a);
        }
    }
}

class MethodStatic {
    public static void main(String[] args) {
        int c = add(5, 6);
        System.out.println("5 + 6 = " + c);
    }

    static int add(int a, int b) {
        return a + b;
    }
}

class MethodNotStatic {
    public static void main(String[] args) {
        MethodNotStatic method = new MethodNotStatic();
        int c = method.add(5, 6);
        System.out.println("5 = 6 = " + c);
    }

    int add(int a, int b) {
        return a + b;
    }
}

class FieldExample {
    int a;

    public static void main(String[] args) {
        FieldExample field = new FieldExample();
        field.a = 12;
        System.out.println("a = " + field.a);
        System.out.println(field.getA());
        field.printA();
    }

    int getA() {
        return a;
    }

    void printA() {
        System.out.println(a);
    }
}
















