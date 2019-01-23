package com.ITAcademy.AnaMartinez.lletresRepetides;


import java.util.*;

public class RepeatedLetters {

    public static void main (String[] args){

        List<Character> nameList = new ArrayList<>();
        Collections.addAll(nameList,'A','n','a');
        List<Character> surnameList = new ArrayList<>();
        Collections.addAll(surnameList,'M','a','r','t','i','n','e','z');

        int option;
        boolean exit = false;

        while(!exit){
            option = printMenu();
            switch (option){
                case 0: exit = true; break;
                case 1: showMyName(); break;
                case 2: nameListCategorization(nameList);  break;
                case 3: nameToMap(nameList);break;
                case 4: listFullName(nameList, surnameList); break;
                case 5: newNameSurname(nameList, surnameList); break;
            }
        }
    }

    /*
    * PHASE 5: Enter a name and surname to evaluate
    * */
    private static void newNameSurname(List<Character> nameList, List<Character> surnameList){

        System.out.println("You have selected to enter a new name and surname to evaluate. ");
        System.out.println("You will be requested to enter the name first, then the surname: ");
        System.out.println("Enter the new name: ");
        getCharListFromScanner(nameList);
        System.out.println("Enter the new surname: ");
        getCharListFromScanner(surnameList);
    }

    private static void getCharListFromScanner(List<Character> nameList) {
        String input;
        Scanner sc = new Scanner(System.in);

        input = sc.nextLine();
        char[] inputInChar = input.toCharArray();
        nameList.clear();
        for (char letter : inputInChar) {
            nameList.add(letter);
        }
    }

    /*
    * PHASE 4: create a list with both name and surname, separated with ' ' and print it out.
    * */
    private static void listFullName(List<Character> nameList, List<Character> surnameList){

        List<Character> fullName = new ArrayList<>(nameList);
        fullName.add(' ');
        fullName.addAll(surnameList);
        System.out.println(fullName);
    }

    /*
    * PHASE 3: Create a map with the pairing letter in the name/ number of times that it appears.
    * */
    private static void nameToMap(List<Character> nameList){

        Map<Character, Integer> letterMap = new HashMap<>();
        fromListToMap(nameList, letterMap);
        System.out.println("You have selected to printout a map with the letters/ number of times they appear: ");
        for(Map.Entry<Character,Integer> entry : letterMap.entrySet()){
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    private static void fromListToMap(List<Character> nameList, Map<Character, Integer> letterMap) {
        for(char letter : nameList){
            int i = 1;
            if (letterMap.containsKey(letter)){
                i = letterMap.get(letter);
                i++;
            }
            letterMap.put(letter, i);
        }
    }

    /*
    * PHASE 2: for each letter in the list, check if it is a number, a symbol, a vowel or a consonant and  do a printout.
    * */
    private static void nameListCategorization(List<Character> nameList) {

        System.out.println("You have selected to print out the name categorizing the letters: ");
        for(char letter: nameList){
            System.out.print(letter + ": ");
            if(Character.isDigit(letter)) System.out.println("NUMBER! A name should contain no numbers");
            else {
                if(Character.isLetter(letter)) {
                    if (isVowel(letter)) System.out.println("VOWEL");
                    else System.out.println("CONSONANT");
                }
                else{
                    if(Character.isSpaceChar(letter)) System.out.println("SPACE");
                    else System.out.println("SYMBOL! A name should contain no symbols");
                }
            }
        }
    }

    private static boolean isVowel(char letter) {
        return (letter == 'a')
                || (letter == 'e')
                || (letter == 'i')
                || (letter == 'o')
                || (letter == 'u')
                || (letter == 'A')
                || (letter == 'E')
                || (letter == 'I')
                || (letter == 'O')
                || (letter == 'U');
    }

    /*
    * PHASE 1: print out of the name from an array
    * */
    private static void showMyName(){

        char[] nameArray = {'A','n','a'};
        System.out.println("You have selected to print out the name: ");
        for(char c : nameArray) System.out.println(c);

    }

    private static int printMenu () {

        int option = 0;
        boolean validInput = true;
        Scanner sc = new Scanner(System.in);

        do {
            printMenuLines();
            try {
                if(validInput) System.out.print("Option number selected: ");
                else System.out.print("Incorrect choice. Please enter a correct number option: ");
                option = sc.nextInt();
                validInput = option <= 5;

            }
            catch (InputMismatchException e) {
                sc.nextLine();
                validInput = false;
            }
        }while (!validInput);

        return option;
    }

    private static void printMenuLines() {
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
    }

}
