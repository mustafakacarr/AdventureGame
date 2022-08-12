import java.util.Scanner;
public class Game {
    private Scanner keyboard=new Scanner(System.in);


    public void start(){

        System.out.println("Macera oyunu başladı.");
        System.out.println("Lütfen bir isim giriniz");
        String playerName=keyboard.next();
        Player player=new Player(playerName);
        System.out.println("Sayın "+player.getName()+ " karanlık ve sisli adaya hoşgeldiniz.");
        player.selectChar();


    }
}
