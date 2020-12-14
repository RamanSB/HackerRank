/**
 * Problem: https://www.hackerrank.com/challenges/java-comparator/problem
 *
 * ---INPUT---
 * Input:
 * The first line contains an integer, n, denoting the number of players.
 * Each of the n subsequent lines contains a player's name  and score respectively.
 *
 *
 * ---OUTPUT---
 * Output:
 * sorted list of player objects (printing name\tscore)
 *
 *
 * ---CONSTRAINTS---
 * 1) score [0, 100]
 * 2) players can have the same name
 * 3) player names consist of lowercase English letters
 *
 * Sample input
 * amy 100
 * david 100
 * heraldo 50
 * aakansha 75
 * aleksa 150
 *
 * Sample output
 * aleksa 150
 * amy 100
 * david 100
 * aakansha 75
 * heraldo 50
 */
import java.util.*;

class Checker implements Comparator<Player>{ //if no generics are used then Comparator<Object> is assumed.

    public int compare(Player p1, Player p2){
        if(p1.score == p2.score){
            return p1.name.compareTo(p2.name); //sorts the name alphabetically
        }
        return -(p1.score - p2.score); //if player1's score > player2's score return positive value (moves p1 ahead of p2) [The negative negates this]
        //In essence the - implies to sort in descending order. (if a negative int is returned) (p2 goes before p1).
    }
}

class Player {
    String name;
    int score;

    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}