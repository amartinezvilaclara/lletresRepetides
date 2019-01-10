package com.ITAcademy.AnaMartinez.lletresRepetides;


import java.util.*;

public class RepeatedLetters {

    public static void main (String[] args){

        //Create the data structures and init them
        char[] nameArray = {'A','n','a'};

        ArrayList<Character> nameList = new ArrayList<>();
        for(char letter: nameArray){
            nameList.add(letter);
        }

        ArrayList<Character> surnameList = new ArrayList<>();
        Collections.addAll(surnameList,'M','a','r','t','i','n','e','z');

        int option = 0;
        boolean exit = false;

        while(!exit){
            option = printMenu();
            switch (option){
                case 0: exit = true; break;
                case 1: showName(nameArray); break;
                case 2: nameListCategorization(nameList);  break;
                case 3: nameToMap(nameList);break;
                case 4: fullName(nameList, surnameList); break;
                case 5: newNameSurname(nameList, surnameList); break;
            }
        }
    }

    /*
    * PHASE 5: Enter a name and surname to evaluate
    * */
    static void newNameSurname(ArrayList<Character> nameList, ArrayList<Character> surnameList){

        String input;
        Scanner sc = new Scanner(System.in);

        System.out.println("You have selected to enter a new name and surname to evaluate. ");
        System.out.println("You will be requested to enter the name first, then the surname: ");
        System.out.println("Enter the new name: ");
        input = sc.nextLine();
        char[] inputInChar = input.toCharArray();
        nameList.clear();
        for(char letter : inputInChar){
            nameList.add(letter);
        }
        System.out.println("Enter the new surname: ");
        input = sc.nextLine();
        inputInChar = input.toCharArray();
        surnameList.clear();
        for(char letter : inputInChar){
            surnameList.add(letter);
        }
    }

    /*
    * PHASE 4: create a list with both name and surname, separated with ' ' and print it out.
    * */
    static void fullName(ArrayList<Character> nameList, ArrayList<Character> surnameList){

        ArrayList<Character> fullName = new ArrayList<>();
        //init of fullName copying the other two lists
        fullName.addAll(nameList);
        fullName.add(' ');
        fullName.addAll(surnameList);

        // default printout of the full name
        System.out.println(fullName);
        // propietary printout of the full name
/*        System.out.println("You have selected to printout the full name: ");
        for(char letter : fullName){
            System.out.print(letter);
        }
        System.out.println();*/
    }

    /*
    * PHASE 3: Create a map with the pairing letter in the name/ number of times that it appears.
    * */
    static void nameToMap(ArrayList<Character> nameList){

        HashMap<Character, Integer> letterMap = new HashMap<>();
        //init the hashMap with the contents of the list
        for(char letter : nameList){
            if (letterMap.containsKey(letter)){
                int i = letterMap.get(letter);
                letterMap.replace(letter,++i);
            }
            else letterMap.put(letter, 1);
        }
        //printout of the hashmap
        System.out.println("You have selected to printout a map with the letters/ number of times they appear: ");
        for(Map.Entry<Character,Integer> entry : letterMap.entrySet()){
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    /*
    * PHASE 2: for each letter in the list, check if it is a number, a symbol, a vowel or a consonant and  do a printout.
    * */

    static void nameListCategorization(ArrayList<Character> nameList) {

        System.out.println("You have selected to print out the name categorizing the letters: ");
        for(char letter: nameList){
            System.out.print(letter + ": ");
            if(Character.isDigit(letter)){
                System.out.println("NUMBER! A name should contain no numbers");
            }
            else {
                if(Character.isLetter(letter)) {
                    if ((letter == 'a')
                            || (letter == 'e')
                            || (letter == 'i')
                            || (letter == 'o')
                            || (letter == 'u')
                            || (letter == 'A')
                            || (letter == 'E')
                            || (letter == 'I')
                            || (letter == 'O')
                            || (letter == 'U')) {
                        System.out.println("VOWEL");
                    } else {
                        System.out.println("CONSONANT");
                    }
                }
                else{
                    if(Character.isSpaceChar(letter)) System.out.println("SPACE");
                    else System.out.println("SYMBOL! A name should contain no symbols");
                }
            }
        }
    }

    /*
    * PHASE 1: print out of the name from an array
    * */
    static void showName(char [] nameArray){

        System.out.println("You have selected to print out the name: ");
        for(int i=0; i<nameArray.length; i++) System.out.println(nameArray[i]);

    }
    static int printMenu () {

        int option = 0;
        boolean validInput = true;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.flush();
            System.out.println();
            System.out.println();
            System.out.println("********************************************************************");
            System.out.println("***Exercici de les Lletres Repetides");
            System.out.println("********************************************************************");
            System.out.println();
            System.out.println("Choose an option: ");
            System.out.println("-----------------");
            System.out.println("Phase 1: Display the Creator's Name");
            System.out.println("Phase 2: Print the vowel/ consonant categorization from a List");
            System.out.println("Phase 3: Print a Map with the correlation letter/Num. appearances");
            System.out.println("Phase 4: Print Name and Surname from List");
            System.out.println("Phase 5: I wanna play too! I'll choose my own name");
            System.out.println("-----------------");
            System.out.println("Press 0 to EXIT ");
            System.out.println();
            System.out.println("********************************************************************");

            try {
                if(validInput) System.out.print("Option number selected: ");
                else System.out.print("Incorrect choice. Please enter a correct number option: ");
                option = sc.nextInt();
                if (option > 5) validInput = false;
                else validInput = true;

            } catch (InputMismatchException e) {
                sc.nextLine();
                validInput = false;
            }
        }while (!validInput);

        return option;
    }

}
