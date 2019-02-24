package yu.michael.uhs.com.fblaquizapp;

import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class Question {
    private String question;
    private String answer;
    private ArrayList<String> otherChoices;

    public Question(String question, String answer, ArrayList<String> otherChoices) {
        this.question = question;
        this.answer = answer;
        this.otherChoices = otherChoices;
    }

    public String getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<String> getOtherChoices(){
        return otherChoices;
    }
}
