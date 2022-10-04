import java.util.Scanner;

public class CalculatorMain {
    static RationalCalculator rationalCalculator;
    static VectorCalculator vectorCalculator;
    static ComplexCalculator complexCalculator;

    public static void main(String[] args) {
        createCalculators();
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        int input;

        do
        {
            AbstractCalculator calculator = null;
            System.out.println("Choose calculator:");
            System.out.println("1 - Rational calculator");
            System.out.println("2 - Vector calculator");
            System.out.println("3 - Complex calculator");
            System.out.println("4 - Exit program");
            input = scanner.nextInt();

            switch (input)
            {
                case 1:
                    calculator = rationalCalculator; break;
                case 2:
                    calculator = vectorCalculator; break;
                case 3:
                    calculator = complexCalculator; break;
                case 4:
                    System.out.println("Programm beendet"); break;
                default:
                    System.out.println("Ungültige Eingabe");
            }

            if (input != 4)
            {
                int operation = 5;
                Number x = new Number();
                Number y = new Number();
                Number result = new Number();

                while (operation == 5)
                {
                    System.out.println("Enter number x a");
                    double xa = scanner.nextDouble();
                    x.setA(xa);
                    System.out.println("Enter number x b");
                    double xb = scanner.nextDouble();
                    x.setB(xb);
                    System.out.println("Enter number y a");
                    double ya = scanner.nextDouble();
                    y.setA(ya);
                    System.out.println("Enter number y b");
                    double yb = scanner.nextDouble();
                    y.setB(yb);
                    System.out.println("Choose operation:");
                    System.out.println("1 - add");
                    System.out.println("2 - subtract");
                    System.out.println("3 - multiply");
                    System.out.println("4 - divide");
                    System.out.println("5 - enter numbers again");
                    operation = scanner.nextInt();
                }

                switch (operation)
                {
                    case 1:
                        result = calculator.add(x, y); break;
                    case 2:
                        result = calculator.subtract(x, y); break;
                    case 3:
                        result = calculator.multiply(x, y); break;
                    case 4:
                        result = calculator.divide(x, y); break;
                    default:
                        System.out.println("Ungültige Eingabe");
                }

                System.out.println("Solution:");
                System.out.println("a = " + result.getA());
                if (input != 3)
                {
                    System.out.println("b = " + result.getB());
                }
                else
                {
                    System.out.println("b = " + result.getB() + "i");
                }
            }
        } while (input != 4);
    }

    public static void createCalculators()
    {
        CalculationOperation ratAdd = ((x, y) -> {
            Number result = new Number();
            result.setA((x.getA() * y.getB()) + (x.getB() * y.getA()));
            result.setB(x.getB() * y.getB());
            return result;
        });
        CalculationOperation ratSub = ((x, y) -> {
            Number result = new Number();
            result.setA((x.getA() * y.getB()) - (x.getB() * y.getA()));
            result.setB(x.getB() * y.getB());
            return result;
        });
        CalculationOperation ratMul = ((x, y) -> {
            Number result = new Number();
            result.setA(x.getA() * y.getA());
            result.setB(x.getB() * y.getB());
            return result;
        });
        CalculationOperation ratDiv = ((x, y) -> {
            Number result = new Number();
            result.setA(x.getA() * y.getB());
            result.setB(x.getB() * y.getA());
            return result;
        });
        rationalCalculator = new RationalCalculator(ratAdd, ratSub, ratMul, ratDiv);

        CalculationOperation vecAdd = ((x, y) -> {
            Number result = new Number();
            result.setA(x.getA() + y.getA());
            result.setB(x.getB() + y.getB());
            return result;
        });
        CalculationOperation vecSub = ((x, y) -> {
            Number result = new Number();
            result.setA(x.getA() - y.getA());
            result.setB(x.getB() - y.getB());
            return result;
        });
        CalculationOperation vecMul = ((x, y) -> {
            Number result = new Number();
            result.setA(x.getA() * y.getB() - x.getB() * y.getA());
            result.setB(1.0);
            return result;
        });
        CalculationOperation vecDiv = ((x, y) -> {
            Number result = new Number();
            result.setA(x.getA() * y.getA() + x.getB() * y.getB());
            result.setB(1.0);
            return result;
        });
        vectorCalculator = new VectorCalculator(vecAdd, vecSub, vecMul, vecDiv);

        CalculationOperation comAdd = ((x, y) -> {
            Number result = new Number();
            result.setA(x.getA() + y.getA());
            result.setB(x.getB() + y.getB());
            return result;
        });
        CalculationOperation comSub = ((x, y) -> {
            Number result = new Number();
            result.setA(x.getA() - y.getA());
            result.setB(x.getB() - y.getB());
            return result;
        });
        CalculationOperation comMul = ((x, y) -> {
            Number result = new Number();
            result.setA((x.getA() * y.getA()) - (x.getB() * y.getB()));
            result.setB((x.getB() * y.getA()) + (x.getA() * y.getB()));
            return result;
        });
        CalculationOperation comDiv = ((x, y) -> {
            Number result = new Number();
            double square = Math.pow(y.getA(), 2) + Math.pow(y.getB(),2);
            result.setA(((x.getA() * y.getA()) + (x.getB() * y.getB())) / square);
            result.setB(((x.getB() * y.getA()) - (x.getA() * y.getB())) / square);
            return result;
        });
        complexCalculator = new ComplexCalculator(comAdd, comSub, comMul, comDiv);
    }
}
