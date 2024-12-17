package javacalc;

import java.util.Scanner;

public class Main {
    public static String calc(String input) throws Exception {
        String[] line = input.split(" ");
        if (line.length != 3) {
            throw new Exception("Неверный ввод!");
        }
        int num1, num2;
        try {
            num1 = Integer.parseInt(line[0]);
            num2 = Integer.parseInt(line[2]);
        } catch (NumberFormatException e) {
            throw new Exception("Вы должны вводить целые числа!");
        }
        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
            throw new Exception("Должны вводиться числа от 1 до 10");
        }
        char operator = line[1].charAt(0);
        switch(operator) {
            case '+': return (num1 + num2) + "";
            case '-': return (num1 - num2) + "";
            case '*': return (num1 * num2) + "";
            case '/':
                return (num1 / num2) + "";
            default:
                throw new Exception("Неверная операция!");
        }
    }
}

class Runner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("""
                --------------------------Калькулятор--------------------------
                --------------------Для выхода введите exit--------------------
                """);
        while (true) {
            String input = scan.nextLine();
            if (input.equals("exit")) {
                break;
            }
            try {
                String res = Main.calc(input);
                System.out.println(res);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
