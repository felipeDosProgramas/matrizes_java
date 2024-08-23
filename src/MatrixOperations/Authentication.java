package MatrixOperations;

import Interfaces.Operation;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class Authentication implements Operation {
    static Hashtable<String, List<String>> loginData = new Hashtable<>(2);
    Authentication(){
        loginData.put("user", List.of(new String[]{
                "mariaGeneralAdm", "littleSergioKingOfThem", "AlessandroLyme",
                "genebraNeedUs", "SenacBetterThanFortec", "GilmarLikesCSharp"
        }));
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
                .get(indexOfUserOnArrayOfUsers).equals(password);
    }
    public static boolean execute(){
        var scan = new Scanner(System.in);
        return new Authentication()
                .auth(scan.nextLine(), scan.nextLine());
    }
}
