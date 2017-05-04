/*
 * Friday, April 28, 2017.
 * Arielle
 * Grade 11 bio project on speciation in evolution. (Squirrels on St. Kitts and Nevis)
 */
package School;

import java.io.File;
import java.util.Scanner;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;

/**
 *
 * @author A & J
 */
public class WarsSugarsPlates {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws nu.xom.ParsingException
     */
    public static void main(String[] args) {
        //Vaiables
        int choice = 0;
        Scanner input = new Scanner (System.in);
        play(choice, input);
        
        sopl("Thanks for participating! Enter 1 to play again or 2 to close the program.");
        do{
            choice = input.nextInt();
            if (choice == 2){
                System.exit(0);
            }
            else if (choice == 1) {
                play(choice, input);
            }
            else{
                sopl("That is not an option please try again.");
            }
        } while (choice != 1 || choice != 2);

    }
    public static void play(int choice, Scanner input){
        // Gettting xml and converting to useable doc

        File file = new File("src/School/WarsSugarDoc.xml");
        
        Builder builder = new Builder();
        Document doc;
        Element squirrels = null;
        
        try {
            doc = builder.build(file);
            squirrels = doc.getRootElement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        Elements data = squirrels.getChildElements();
        
        
        //Title Page
        Element title = data.get(0);
        sopl(title.getValue());
        input.nextLine();
        
        //Pause
        
        
        //Title Page
        Element intro = data.get(1);
        sopl(intro.getValue());
        input.nextLine();
        
        //Plates
        Element plates = data.get(2);
        sopl(plates.getValue());
        sopl("Enter 1 to find out about the St. Kitts population and 2 to find out about the Nevis population");
        Element stkitts = data.get(3);
        Element nevis = data.get(4);
        do{
            choice = input.nextInt();
            switch(choice){
                case 1:
                    sopl(stkitts.getFirstChildElement("war").getValue());
                    sopl("Enter 1 for the Nevis population during the war"
                            + "\n or 2 for the effect it had on the St. Kitts population");
                    do {
                        choice = input.nextInt();
                        switch (choice){
                            case 1: 
                                sopl(nevis.getValue());
                                break;
                            case 2:
                                sopl(stkitts.getFirstChildElement("bottleneck").getValue());
                                sopl("Press enter to find out about the next step in the speciation and evolution that occurred on St. Kitts.");
                                input.nextLine();
                                sopl(stkitts.getFirstChildElement("sugar1").getValue());
                                input.nextLine();
                                sopl(stkitts.getFirstChildElement("sugar2").getValue());
                                input.nextLine();
                                sopl(stkitts.getFirstChildElement("mating").getValue());
                                break;
                            default:
                                sopl("Sorry that is not an option, please try again");
                        }
                    } while (choice != 1 && choice != 2);
                    input.nextLine();
                    break;
                    
                case 2:
                    sopl(nevis.getValue());
                    input.nextLine();
                    break;
                default:
                    sopl("Sorry that is not an option, please try again.");
            }
        } while (choice != 1 && choice != 2);
        sopl(data.get(5).getValue());
        input.nextLine();
    }
    
    public static void sopl(String n){
        System.out.println(n);
    }
    public void sopl(Integer n){
        System.out.println(n);
    }
    

}
