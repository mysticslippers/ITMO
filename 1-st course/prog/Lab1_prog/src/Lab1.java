/*
Лабораторная работа №1
Вариант №311808
Михайлов Дмитрий Андреевич
Группа P3118
 */

import java.math.BigDecimal;
import java.math.RoundingMode;
public class Lab1{
    private final static float fraction1 = (float) 1.0 / 3;
    private final static float fraction2 = (float) 2.0 / 3;
    private final static short minimumRange = 11;
    private final static short maximumRange = 17;

    private static void fillingFirstArray(short[] arr, short minimumValue){
        short tmp = 21;
        while(tmp != 0){
            if(tmp % 2 != 0){
                arr[minimumValue - ((tmp + 1) / 2)] = tmp;
            }
            tmp--;
        }
    }


    private static void fillingSecondArray(float[] arr, short maximumValue){
        for(int i = 0; i < maximumValue; i++){
            arr[i] = (float) (Math.random() * (11.0 - (-15.0))) - 15;
        }
    }


    private static void fillingThirdArray(float[][] answer, short[] arr1, float[] arr2, short minimumValue, short maximumValue){
        for(int i = 0; i < minimumValue; i++){
            for(int j = 0; j < maximumValue; j++){
                switch (arr1[i]){
                    case 5:
                            answer[i][j] = (float) Math.pow(((Math.pow((0.5 * (arr2[j] + fraction1)), arr2[j]) / (Math.cbrt(arr2[j]) - Math.PI))) / 3, 3);
                            break;
                    case 1, 9, 11, 15, 21:
                            answer[i][j] = (float) Math.asin(Math.pow(Math.E, Math.cbrt(Math.pow(-Math.sin(arr2[j]), 2))));
                            break;
                    default:
                            answer[i][j] = (float) Math.asin(Math.pow(Math.E, Math.cbrt(-Math.abs(Math.pow(fraction2 * (3 + Math.cbrt(arr2[j])), Math.exp(Math.abs(arr2[j])))))));
                            break;
                }
            }
        }
    }


    public static void main(String[] args){
        short[] a = new short[minimumRange];
        fillingFirstArray(a, minimumRange);

        float[] x = new float[maximumRange];
        fillingSecondArray(x, maximumRange);

        float[][] b = new float[minimumRange][maximumRange];
        fillingThirdArray(b, a, x, minimumRange, maximumRange);

        //Вывод 1-ого массива.
        System.out.println("Выввод первого массива!");
        for (int i = 0; i < minimumRange; i++) {
            System.out.print(" " + a[i] + " ");
        }
        System.out.println();

        //Вывод 2-ого массива.
        System.out.println("Вывод второго массива!");
        for (int i = 0; i < maximumRange; i++) {
            System.out.print(" " + x[i] + " ");
        }
        System.out.println();

        //Вывод 3-его массива.
        System.out.println("Вывод третьего массива!");
        for (int i = 0; i < minimumRange; i++) {
            for (int j = 0; j < maximumRange; j++) {
                String answer = String.valueOf(b[i][j]);
                if(answer.equals("NaN")){          //Если надо заменить NaN-ы на что-нибудь.
                    answer = "NaN" + " ";
                }
                else{
                    answer = String.valueOf(BigDecimal.valueOf(b[i][j]).setScale(2, RoundingMode.DOWN));
                    if(answer.length() > 5){
                        answer = "0.00";
                    }
                }
                System.out.print(answer + "\t");
            }
            System.out.println();
        }
    }
}
