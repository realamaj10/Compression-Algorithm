import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Encoder {
    public static void main(String[] args){

        System.out.printf("Please enter pattern");
        Scanner reader = new Scanner(System.in);
        String myString = reader.next();
        String output = String.format(".%s.",myString);


        ArrayList<String> dictionary = new ArrayList<String>();




        String[] input = output.split("");


        HashMap<Integer, String> codeWord = new HashMap<Integer, String>();


        int index = 1;
        String current ="";

        int key = 0;
        dictionary.add(null);


        while(index < input.length-1){
            current = input[index];


            if(dictionary.contains(current)){
                String previous="";


                current = add(current, dictionary, input, index);

                int j = index;
                for(int i=0; i<current.length()-1;i++){
                    previous += input[j];
                    j+=1;
                }


                codeWord.put(key++, (dictionary.indexOf(previous)+":"+append(current)));


                index = index+current.length();


                dictionary.add(current);


            }


            else {
                codeWord.put(key++, "0:"+current);
                dictionary.add(current);
                index++;
            }

            System.out.println(codeWord.entrySet()+" "+dictionary);

        }
        System.out.println(codeWord);

    }


    public static String add(String current, ArrayList<String> dictionary, String[] in, int index){
        for(int i=index; i<in.length;i++){
            if(dictionary.contains(current)){
                current = current+in[i+1];
            }
        }
        return current;
    }


    public static String append(String current){
        String [] name = current.split("");
        return name[name.length - 1];
    }
}