// Вычислить [n-ое треугольного число](сумма чисел от 1 до n), n! (произведение чисел от 1 до n)

package java_homevork_1;

import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число (число больше или равно 1): ");
        int number = scanner.nextInt();

        int nFactorial = 1;
        int nTriangl = 0;

        if (number >= 1){
          for (int i = 1; i <= number; i++){
            nFactorial *= i;
            nTriangl += i;
        } 
        System.out.printf("Факториал числа %d равен %d\n", number, nFactorial);
        System.out.printf("%d треугольное число равно %d\n", number, nTriangl);
        }
        else{
            System.out.println("Число введено неверно");
        }     
        scanner.close();  
    }
}
