package LabaCourse;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class OdevAlti {

    public static void main(String[] args) {

        Random rand = new Random();
        String createdWord;
        HashSet<String> chosenWords = new HashSet<String>();



        String[] words = new String[4];
        words[0] = "kalem";
        words[1] = "elalem";
        words[2] = "kelam";
        words[3] = "kelime";



        for( int i = 0; i < words.length; i++ ) {

            for(int j = 0; j < words[i].length(); j++ ) {

                for(int k = j+1; k < words[i].length(); k++ ) {

                    if(words[i].charAt(j) == words[i].charAt(k)) {

                        chosenWords.add(words[i]);
                    }
                }
            }
        }
        System.out.println(chosenWords);


        Iterator<String> it = chosenWords.iterator();
        if (it.hasNext()) {
            String first = it.next();
            String second = it.next();

            int randomNumber = rand.nextInt(first.length()) +1;
            first = first.substring(0,randomNumber);


            randomNumber = rand.nextInt(first.length()) +1 ;
            second = second.substring( 0, randomNumber);

            createdWord = first + second;

            System.out.println(createdWord);

        }



    }
}
