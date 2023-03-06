//Реализовать простой калькулятор

package java_homevork_1;

import java.util.Scanner;

public class Task_3 {

    static int enterNumber(int numberFlag){

        Scanner scanner = new Scanner(System.in);

        int number = 0;

        if (numberFlag == 1){
            System.out.print("Введите первое число: ");
            number = scanner.nextInt();
        }
        else{
            System.out.print("Введите второе число: ");
            number = scanner.nextInt();
        }
        
        return number;
       
    }

    public static void main(String[] args){        

        System.out.println("Добро пожаловать в простой калькулятор");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите требуемое действие: '+' - сложение,  '-' - вычитание, '*' - умножение, '/' - деление: ");
        String flag = scanner.nextLine();

        int number1 = 0;
        int number2 = 0;

        switch (flag){
            case "+":
                number1 = enterNumber(1);
                number2 = enterNumber(2);

                int sum = number1 + number2;
                System.out.printf(" %d + %d = %d\n", number1, number2, sum);

                break;

            case "-":
                number1 = enterNumber(1);
                number2 = enterNumber(2);

                int difference = number1 - number2;
                System.out.printf(" %d - %d = %d\n", number1, number2, difference);

                break;

            case "*":
                number1 = enterNumber(1);
                number2 = enterNumber(2);

                int product = number1 * number2;
                System.out.printf(" %d * %d = %d\n", number1, number2, product);

                break;   

            case "/":
                number1 = enterNumber(1);
                number2 = enterNumber(2);

                int division = number1 / number2;
                System.out.printf(" %d / %d = %d\n", number1, number2, division);

                break;

            default:
                System.out.println("Действие введено неверно");

                break;
        }
        scanner.close();
    }
    
}
