import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NumberTester {
    private String fileName;
    private NumberTest oddTester;
    private NumberTest primeTester;
    private NumberTest palindromeTester;

    public NumberTester(String fileName) {
        this.fileName = fileName;
    }

    public void setOddEvenTester(NumberTest oddTester) {
        this.oddTester = oddTester;
    }

    public void setPrimeTester(NumberTest primeTester) {
        this.primeTester = primeTester;
    }

    public void setPalindromeTester(NumberTest palindromeTester) {
        this.palindromeTester = palindromeTester;
    }

    public void testFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            int numberOfTests = Integer.parseInt(line);
            for (int i = 0; i < numberOfTests; i++)
            {
                line = reader.readLine();
                String[] arr = line.split(" ");
                int firstNumber = Integer.parseInt(arr[0]);
                int secondNumber = Integer.parseInt(arr[1]);

                if (firstNumber == 1)
                {
                    setOddEvenTester((number) -> (number % 2) == 0);
                    if (oddTester.testNumber(secondNumber))
                    {
                        System.out.println("EVEN");
                    }
                    else
                    {
                        System.out.println("ODD");
                    }
                }
                else if (firstNumber == 2)
                {
                    setPrimeTester((number) -> {
                        for (int j = 2; j < number; j++)
                        {
                            if ((number % j) == 0)
                            {
                                return false;
                            }
                        }

                        return true;
                    });
                    if (primeTester.testNumber(secondNumber))
                    {
                        System.out.println("PRIME");
                    }
                    else
                    {
                        System.out.println("NO PRIME");
                    }
                }
                else
                {
                    setPalindromeTester((number) -> {
                        StringBuilder s = new StringBuilder(Integer.toString(secondNumber));
                        s = s.reverse();
                        int palindrome = Integer.parseInt(s.toString());
                        return palindrome == number;
                    });
                    if (palindromeTester.testNumber(secondNumber))
                    {
                        System.out.println("PALINDROME");
                    }
                    else
                    {
                        System.out.println("NO PALINDROME");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
