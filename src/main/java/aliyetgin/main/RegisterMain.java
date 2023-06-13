package aliyetgin.main;

import aliyetgin.controller.RegisterControllerImplementation;
import aliyetgin.dto.RegisterDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegisterMain {

    // Global Variables
    private static String name;
    private static String surname;
    private static String email;
    private static String password;


    // Constructor

    public RegisterMain() {}

    // User input
    private static int takeUserInput(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("\n Please make a choice: ");
        System.out.println("1-) CREATE \n2-) LIST\n3-) FIND\n4-) UPDATE\n5-) DELETE\n6-) EXIT");
        return keyboard.nextInt();
    }

    // CREATE
    private static RegisterDto create(){
        System.out.println("CREATE");
        RegisterControllerImplementation registerController = new RegisterControllerImplementation();
        Scanner keyboard = new Scanner(System.in);
        // SCANNER
        System.out.println("Adınızı Giriniz");
        name = keyboard.nextLine();
        System.out.println("Soyadınız Giriniz");
        surname = keyboard.nextLine();
        System.out.println("Email Giriniz");
        email = keyboard.nextLine();
        System.out.println("Password Giriniz");
        password = keyboard.nextLine();
        RegisterDto registerDto = new RegisterDto();
        registerDto.setName(name);
        registerDto.setSurname(surname);
        registerDto.setEmail(email);
        registerDto.setPassword(password);
        registerController.create(registerDto);
        return registerDto;
    }

    // FIND
    private static RegisterDto find(){
        System.out.println("FIND");
        RegisterControllerImplementation registerController = new RegisterControllerImplementation();
        Scanner keyboard = new Scanner(System.in);
        RegisterDto registerDeleteDto = new RegisterDto();
        System.out.println("Please enter id of the user you want to find out:");
        registerDeleteDto.setId(keyboard.nextLong());
        RegisterDto registerDto = registerController.find(registerDeleteDto.getId());
        System.out.println(registerDto);
        return registerDto;
    }

    // LIST
    private static List<RegisterDto> list(){
        System.out.println("LIST");
        RegisterControllerImplementation registerController = new RegisterControllerImplementation();
        ArrayList<RegisterDto> list = registerController.list();
        list.forEach((temp) -> {
            System.out.printf("%d, %20s, %20s, %20s, %20s, %20s%n",temp.getId(),temp.getName(), temp.getSurname(), temp.getEmail(),temp.getPassword(), temp.getCreatedDate());
        });
        return list;
    }

    // UPDATE
    private static RegisterDto update(){
        System.out.println("UPDATE");
        RegisterControllerImplementation registerController = new RegisterControllerImplementation();
        Scanner keyboard = new Scanner(System.in);
        long id;
        // SCANNER
        System.out.println("Please enter your id:");
        id = keyboard.nextLong();
        keyboard.nextLine();
        System.out.println("Please enter your name:");
        String name = keyboard.nextLine();
        System.out.println("Please enter your surname:");
        surname = keyboard.nextLine();
        System.out.println("Please enter your email:");
        email = keyboard.nextLine();
        System.out.println("Please enter your password:");
        password = keyboard.nextLine();
        RegisterDto registerUpdateDto = RegisterDto.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .password(password)
                .build();
        registerUpdateDto.setId(id);
        registerController.update(registerUpdateDto);
        return registerUpdateDto;
    }

    // DELETE
    private static void delete(){
        System.out.println("DELETE");
        RegisterControllerImplementation registerController = new RegisterControllerImplementation();
        Scanner keyboard = new Scanner(System.in);
        RegisterDto registerDeleteDto = new RegisterDto();
        System.out.println("Please enter the id of user you want to delete:");
        registerDeleteDto.setId(keyboard.nextLong());
        registerController.delete(registerDeleteDto);
    }

    // EXIT
    private static void exit() {
        System.out.println("EXIT");
        System.exit(0);
    }


    // Method choice
    private static void chooseMethod(){

        RegisterControllerImplementation registerController = new RegisterControllerImplementation();
        // Infinite loop
        while (true) {
            int userInput = takeUserInput();
            switch (userInput) {
                case 1 -> create();
                case 2 -> list();
                case 3 -> find();
                case 4 -> update();
                case 5 -> delete();
                case 6 -> exit();
                default -> System.out.println("Please choose your number in given range!");
            }// Switch end
        }// Infinite loop end
        }// Method End

    // psvm
    public static void main(String[] args) {
        chooseMethod();
    }// end of psvm
}
