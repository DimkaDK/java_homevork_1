//Вывести все простые числа от 1 до 1000

package java_homevork_1;

public class Task_2 {
    public static void main(String[] args){

        int counter = 0;

        for (int i = 2; i <= 1000; i++){

            for (int j = 2; j < i; j++){
                if (i % j == 0){
                    counter++;
                }
            }

            if (counter == 0){
                System.out.printf("%d, ", i);
            }

            counter = 0;

        }
    }
}
