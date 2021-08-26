import java.util.Arrays;
import java.util.regex.Pattern;

public class Model {
    // numeric constant for occasions when user didnot enter "int min" and "int max"
    private static final int[] RANGE = {0, 100};
    // container for user input
    public int[] inputRecorder = new int[RANGE[1]];
    private int targetNumber; // randomized number
    public int containerNumber = 0;
    private int parsedNumber = 0;
    public int ineedvariable = 0;
    //this method sets range depending on user input
    public boolean rangeSetter(String userInput) {
        if ((Pattern.matches("[0-9]+", userInput) == true)) { // If contains only numbers
            this.parsedNumber = Integer.parseInt(userInput);
            this.inputRecorder[containerNumber] = this.parsedNumber;
            this.containerNumber++;
            return true;
        }
        else if ((userInput.equals(""))) {
            this.inputRecorder[containerNumber] = Model.RANGE[containerNumber];
            this.containerNumber++;
            return true;
        }
        else {
            return false;
        }
    }
    // this method creates random number
    public void targetNumber() {
        this.targetNumber = (int) Math.floor(Math.random() * (this.inputRecorder[1] - this.inputRecorder[0]) + this.inputRecorder[0]);
        System.out.println(targetNumber);
    }
    // this method checks whether entered number is equal to target number
    public boolean correctnessProofer(int userInput) {
        if (userInput == this.targetNumber) {
            this.inputRecorder[containerNumber] = userInput;
            this.containerNumber++;
            int[] outputArray = Arrays.copyOfRange(inputRecorder, 2, this.containerNumber);
            System.out.println(Arrays.toString(outputArray));
            return true;
        }
        else {
            this.inputRecorder[containerNumber] = userInput;
            this.containerNumber++;
            if (inputRecorder[0] > userInput || inputRecorder[1] < userInput) {
                ineedvariable = 3;//out of range
            }
            else {
                if (this.targetNumber > userInput) {
                    inputRecorder[0] = userInput;
                    ineedvariable = 2;// higher
                }
                else if (this.targetNumber < userInput) {
                    inputRecorder[1] = userInput;
                    ineedvariable = 1;//lower
                }
            }
            return false;
        }
    }
}
