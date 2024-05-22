import java.util.ArrayList;


public class Decoder {
    public static void main(String[] args){
        String[] codeWord = "0:a 1:b 1:a 0:c 2:c 5:b".split(" ");
        ArrayList<String> dictionary = new ArrayList<String>();
        String first, last;
        for(String d : codeWord){
            //System.out.println(d);
            first = d.substring(0, 1);
            last = d.substring(2, d.length());

            if(Integer.parseInt(first) == 0){
                dictionary.add(last);
            }else{
                int index = Integer.parseInt(first);
                System.out.println(dictionary);
                dictionary.add(dictionary.get(index-1)+last);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String d : dictionary){
            sb.append(d);
        }

        System.out.println(sb.toString());
    }

}