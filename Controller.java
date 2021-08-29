import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }
    // this method boots application
    public void applicationBoot() {
        view.printMessage(View.WELCOMMING_MESSAGE);
        Scanner scannerInput = new Scanner(System.in);
        
        for (int i = 0; i < 2; i++) {
            view.printMessage(View.LIMIT_MESSAGE[i] + View.ARROWS);
            limitSetter(scannerInput);
        }
        model.targetNumber();
        proofer(scannerInput);
        view.printMessage(View.CONGRATULATION_MESSAGE + (model.containerNumber - 2) + View.STATS);
        for (int i = 2; i < model.containerNumber; i++) {
            if (i != model.containerNumber - 1) {
                System.out.print(+model.inputRecorder[i] + ", ");
            } 
            else {
                System.out.print(+model.inputRecorder[i] + "]");
            }
        }
    }
    
    private void limitSetter(Scanner scannerInput) {
    	
        while (!model.rangeSetter(scannerInput.nextLine())) {
        	
            if (model.ineedvariable > 3) {
            	view.printMessage(showByIndeedvariable(model.ineedvariable));           	
            } else {
                view.printMessage(View.LIMIT_ERROR + View.ARROWS);
            }
        }
    }
    
    public int inputValidator(Scanner userInput) {
    	
        while(!userInput.hasNextInt()) {
            view.printMessage(View.PROOFER_ERROR + View.ARROWS);
            userInput.next();
        }
        return userInput.nextInt();
    }
    
    private void proofer(Scanner userInput) {
        view.printMessage(View.GAME_STARTS + "[" + (model.inputRecorder[0] + 1) + ", " + (model.inputRecorder[1] - 1) + "]" + View.GOOD_LUCK + View.ARROWS);
        
        while (!model.correctnessProofer(inputValidator(userInput))) {
        	view.printMessage(showByIndeedvariable(model.ineedvariable));
        } 
    }
    
    private String showByIndeedvariable(int indeedvariable) {
    	String result = "";
    	
    	if (indeedvariable <= 3) {
    		result = view.mergeStrings(View.INDEED_OUTPUT_1[indeedvariable],"[" + (model.inputRecorder[0] + 1), 
    				", " + (model.inputRecorder[1] - 1), "]",
    				View.PREVIOUS + model.inputRecorder[model.containerNumber - 1],View.ARROWS);
    	}
    	else { 
    		result = view.mergeStrings(View.INDEED_OUTPUT_2[indeedvariable - 3],View.ARROWS );
    	}
    	return result;
    }
}
