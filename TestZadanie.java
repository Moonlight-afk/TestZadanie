import java.util.Scanner;

public class TestZadanie {
   
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String num = in.nextLine();
        in.close();
        String res = calc(num);
        System.out.println(res);
    }

    public static String calc(String num){
        Converter converter = new Converter(); 
        String[] subStr;
        int result;
        subStr = num.split(" ");
        if(subStr.length < 3){
            System.out.println("строка не является математической операцией"); 
            System. exit(0);
        }
        if(subStr.length > 3){
            System.out.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)"); 
            System. exit(0);
        }
        char operation = subStr[1].charAt(0); 
        if(converter.isRoman(subStr[0]) == converter.isRoman(subStr[2])){
            int num1, num2;
            boolean isRoman = converter.isRoman(subStr[0]);
            if(isRoman){
                num1 = converter.romanToInt(subStr[0]);
                num2 = converter.romanToInt(subStr[2]);
                if((num1 < 0 || num1 > 10)||(num2 < 0 || num2 > 10)){
                    System.out.println("Неверный ввод данных"); 
                    result = 0;
                    System. exit(0);
                }
                else {
                    if(num1 <= num2 && operation == '-'){
                        System.out.println("В римской системе нет отрицательных чисел"); 
                        result = 0;
                        System. exit(0);
                    }
                    else result = get_result(num1,num2,operation);
                }
            }
            else{
                num1 = Integer.parseInt(subStr[0]);
                num2 = Integer.parseInt(subStr[2]);
                if((num1 < 0 || num1 > 10)||(num2 < 0 || num2 > 10)){
                    System.out.println("Неверный ввод данных");
                    result = 0;
                    System. exit(0);
                }
                else {
                    // if(num1 < num2 && operation == '-'){
                    //     System.out.println("Неверный ввод данных"); 
                    //     result = 0;
                    //     System. exit(0);
                    // }
                    result = get_result(num1,num2,operation);
                }
            }
            if(isRoman){
                //если числа были римские, возвращаем результат в римском числе
                //System.out.println(converter.intToRoman(result));
                return converter.intToRoman(result); 
            }
            else{
                //если числа были арабские, возвращаем результат в арабском числе
                //System.out.println(result);
                return Integer.toString(result);
            }
        }
        else{
            System.out.println("Числа должны быть в одном формате");
        }
        return num;
        
    }
        

    // public static int num1(String[] subStr){
    //     int num1 = Integer.parseInt(subStr[0]);
    //     if(num1 <= 1 || num1 >= 10){
    //         System.out.println("Неверное число. Повторите ввод.");
    //         System. exit(0);
    //         return 0;
    //     }else return num1;
    // }

    // public static int num2(String[] subStr){
    //     int num2 = Integer.parseInt(subStr[2]);
    //     if(num2 <= 1 || num2 >= 10){
    //         System.out.println("Неверное число. Повторите ввод.");
    //         System. exit(0);
    //         return 0;
    //     } else return num2;
    // }

    static int get_result(int num1, int num2, char operation){
        int result;
        switch (operation){
            case '+':
                result = num1+num2;
                break;
            case '-':
                result = num1-num2;
                break;
            case '*':
                result = num1*num2;
                break;
            case '/':
                result = num1/num2;
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                System. exit(0);
                return 0;
        }
        return result;
    }
}