package MatrixOperations;

import Interfaces.Operation;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class Authentication implements Operation {
    static Hashtable<String, List<String>> loginData = new Hashtable<>(2);

    Authentication(){
        if (!loginData.contains("user"))
            loginData.put("user", List.of(new String[]{
                    "mariaGeneralAdm", "littleSergioKingOfThem", "AlessandroLyme",
                    "genebraNeedUs", "SenacBetterThanFortec", "GilmarLikesCSharp"
            }));
        if(!loginData.contains("password"))
            loginData.put("password", List.of(new String[]{
                    "Mary123", "TinySergio", "2Girls1Boy(Married and with a daughter)",
                    "WheresGenebra", "OnJavaItsDifferently", "GimmeUrCSharp"
            }));
    }

    public boolean auth(String user, String password){
        int indexOfUserOnArrayOfUsers = loginData
                .get("user").indexOf(user);
        if(indexOfUserOnArrayOfUsers == -1)
            return false;
        return loginData.get("password")
                .get(indexOfUserOnArrayOfUsers)
                .equals(password);
    }
    private static String authUser(Authentication authentication, Scanner scanner){
        String user;
        System.out.println("Type your username and password");
        return authentication.auth(user = scanner.nextLine(), scanner.nextLine())
                ? "welcome " + user
                : authUser(authentication, scanner);
    }
    public static void execute(Scanner scanner){
        scanner.nextLine();
        Authentication authentication = new Authentication();
        System.out.println(
                authUser(authentication, scanner)
        );
    }
}
