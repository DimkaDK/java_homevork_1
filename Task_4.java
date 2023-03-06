//Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69. 
//Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.

package java_homevork_1;

import java.util.Scanner;

public class Task_4 {

    // Метод сборки подстроки

    static String substringAssembly(String str, int number){

        String strNew = "";

        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) != '?'){
                strNew += str.charAt(i);
            }
            else{
                strNew += Integer.toString(number);
            }
        }
        return  strNew;
    }


    // Метод подсчета вхождений символов из первой строки во вторую

    static int checkCounter(String str1, String str2){

        int counterCheck = 0;

        for (int i = 0; i < str1.length(); i++){
            for (int j = 0; j < str2.length(); j++){
                if (str1.charAt(i) == str2.charAt(j)){
                    counterCheck++;
                }
            }
        }            
        return counterCheck;
    }

    public static void main(String[] args){

        // Введение исходных данных

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69: ");
        String str = scanner.nextLine();

        // Определение переменных

        String strIn = "";
        String strInFirst = "";
        String strInSecond = "";
        String strInResult = "";
        String strFoTestNumbers = "0123456789";
        String strFoTestSign = "+-*/";
        String strFoTestEqual = "=";
        String strFoTestQuestion = "?";
        int counterNumbers = 0;
        int counterSign = 0;
        int counterEqual = 0;
        int counterQuestion = 0;
        int counter = 0;
        int firstSign = 0;
        int endSign = 0;
        String strInFirsNew = "";
        String strInSecondNew = "";
        int number1 = 0;
        int number2 = 0;
        int nymberResult = 0;
        int flag1 = 0;
        int flag2 = 0;
        
        // Удаляем пробелы
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) != ' '){
                strIn += str.charAt(i);
            }
        }

        // Проверяем на корректность введенные данные

        counterNumbers = checkCounter(strIn, strFoTestNumbers);
        counterSign = checkCounter(strIn, strFoTestSign);
        counterEqual = checkCounter(strIn, strFoTestEqual);
        counterQuestion = checkCounter(strIn, strFoTestQuestion);

        if (counterSign == 1 & counterEqual == 1 & counterQuestion <= 2){
            counter = counterNumbers + counterSign + counterEqual + counterQuestion;
        }
        
       // Если счетчик после проверки равен длине строки, данные введены корректно

        if (counter == strIn.length()){

            // Получаем разделители
            for (int i = 0; i < strIn.length(); i++){
                if (strIn.charAt(i) == '+' || strIn.charAt(i) == '-' || strIn.charAt(i) == '/' || strIn.charAt(i) == '*'){
                    firstSign = i;
                }
                if (strIn.charAt(i) == '='){
                    endSign = i;
                }
            }

            // Получаем первую подстроку
            for (int i = 0; i < firstSign; i++){
                strInFirst += strIn.charAt(i);
            }

            // Получаем вторую подстроку
            for (int i = firstSign + 1; i < endSign; i++){
                strInSecond += strIn.charAt(i);
            }

            // Получаем подстроку с результатом
            for (int i = endSign + 1; i < strIn.length(); i++){
                strInResult += strIn.charAt(i);
            }

            // Проверяем первую подстроку на наличие знак ?
            for (int i = 0; i < strInFirst.length(); i++){
                if (strInFirst.charAt(i) == '?'){
                    flag1++;
                }
            }

            // Проверяем вторую подстроку на наличие знак ?
            for (int i = 0; i < strInSecond.length(); i++){
                if (strInSecond.charAt(i) == '?'){
                    flag2++;
                }
            }

            counter = 0;
                    for (int j = 0; j < 10; j++){
                        if (flag1 == 0){
                            j = 9;
                        }
                        strInFirsNew = substringAssembly(strInFirst, j);
                                                
                        for (int k = 0; k < 10; k++){
                            if (flag2 == 0){
                                k = 9;
                            }
                            strInSecondNew = substringAssembly(strInSecond, k);
                            
                            number1 = Integer.parseInt(strInFirsNew);
                            number2 = Integer.parseInt(strInSecondNew);
                            nymberResult = Integer.parseInt(strInResult);

                            switch (strIn.charAt(firstSign)){
                                case '+':
                                    if (number1 + number2 == nymberResult){
                                        System.out.printf(" %d + %d = %d\n", number1, number2, nymberResult);
                                        counter++;
                                    }

                                case '-':
                                    if (number1 - number2 == nymberResult){
                                        System.out.printf(" %d + %d = %d\n", number1, number2, nymberResult);
                                        counter++;
                                    }

                                case '*':
                                    if (number1 * number2 == nymberResult){
                                        System.out.printf(" %d * %d = %d\n", number1, number2, nymberResult);
                                        counter++;
                                    }

                                case '/':

                                    double number1New = Double.parseDouble(strInFirsNew);
                                    double number2New = Double.parseDouble(strInSecondNew);
                                    double nymberResultNew = Double.parseDouble(strInResult);
                                                                                
                                    if (number1New / number2New == nymberResultNew){

                                        if (number1 / number2 == nymberResult){
                                            System.out.printf(" %d / %d = %d\n", number1, number2, nymberResult);
                                            counter++;
                                        }
                                    }
                            }
                        }
                    }
            if (counter == 0){
                System.out.println("Решения нет");
            }
        }
        else{
            System.out.println("Данные введены неверно");
        }       
        
    }
}
