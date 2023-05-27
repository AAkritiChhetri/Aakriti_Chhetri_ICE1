/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;
import java.util.Random;
import java.util.Scanner;
//Aakriti Chhetri
//991702857

public class CardTrick {

    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        Card[] magic = generateMagicHand();

        System.out.println("Magic Hand of Cards:");
        for (Card card : magic) {
            System.out.println(card.getValue() + " of " + card.getSuit());
        }

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the value : ");
        int userValue = input.nextInt();
        input.nextLine(); 
        System.out.print("Enter the suit: ");
        String userSuit = input.nextLine();

        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(userSuit);

        boolean found = false;
        for (Card card : magic) {
            if (card.getValue() == userCard.getValue() && card.getSuit().equalsIgnoreCase(userCard.getSuit())) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("The given card is in magic hand!");
        } else {
            System.out.println("The given card is not in the magic hand.");
        }
    }

    private static Card[] generateMagicHand() {
        Card[] magicHand = new Card[7];
        Random random = new Random();

        for (int i = 0; i < magicHand.length; i++) {
            Card card = new Card();
            card.setValue(random.nextInt(13) + 1);
            card.setSuit(Card.SUITS[random.nextInt(4)]);
            magicHand[i] = card;
        }

        return magicHand;
    }
}
