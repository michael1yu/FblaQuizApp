package yu.michael.uhs.com.fblaquizapp;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class Topic extends AppCompatActivity {
    FragmentManager fragmentManager;
    private ArrayList<Question> topic1;
    private ArrayList<Question> topic2;
    private ArrayList<Question> topic3;
    private ArrayList<Question> topic4;
    private ArrayList<Question> topic5;
    private ArrayList<Question> questions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);
        int tp = this.getIntent().getIntExtra("topic", 0);
        transition();

        topic1 = new ArrayList<>();
        topic2 = new ArrayList<>();
        topic3 = new ArrayList<>();
        topic4 = new ArrayList<>();
        topic5 = new ArrayList<>();

        questions = new ArrayList<>();

        generateQuestions(tp);

    }

    public void transition() {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, new QuizFragment(), "QuizFragment");
        transaction.commit();
    }

    private void generateQuestions(int i) {
        switch (i) {
            case 0:
                generateTopic1();
                questions.clear();
                questions.addAll(topic1);
                break;
            case 1:
                generateTopic2();
                questions.clear();
                questions.addAll(topic2);
                break;
            case 2:
                generateTopic3();
                questions.clear();
                questions.addAll(topic3);
                break;
            case 3:
                generateTopic4();
                questions.clear();
                questions.addAll(topic4);
                break;
            case 4:
                generateTopic5();
                questions.clear();
                questions.addAll(topic5);
                break;
            default:
                break;
        }

    }

    private void generateTopic1() {
        ArrayList<String> other = new ArrayList<>();
        other.add("1");
        other.add("2");
        other.add("3");
        topic1.add(new Question("Name", "Topic 1", other));
        topic1.add(new Question("Last Name", "1", other));
        topic1.add(new Question("Club", "01", other));
        topic1.add(new Question("School", "10", other));
    }

    private void generateTopic2() {
        ArrayList<String> other = new ArrayList<>();
        other.add("1");
        other.add("2");
        other.add("3");
        topic1.add(new Question("Name", "Topic 1", other));
        topic1.add(new Question("Last Name", "1", other));
        topic1.add(new Question("Club", "01", other));
        topic1.add(new Question("School", "10", other));
    }

    private void generateTopic3() {
        ArrayList<String> other = new ArrayList<>();
        other.add("1");
        other.add("2");
        other.add("3");
        topic1.add(new Question("Name", "Topic 1", other));
        topic1.add(new Question("Last Name", "1", other));
        topic1.add(new Question("Club", "01", other));
        topic1.add(new Question("School", "10", other));
    }

    private void generateTopic4() {
        ArrayList<String> other = new ArrayList<>();
        other.add("1");
        other.add("2");
        other.add("3");
        topic1.add(new Question("Name", "Topic 1", other));
        topic1.add(new Question("Last Name", "1", other));
        topic1.add(new Question("Club", "01", other));
        topic1.add(new Question("School", "10", other));
    }

    private void generateTopic5() {
        ArrayList<String> other = new ArrayList<>();
        other.add("1");
        other.add("2");
        other.add("3");
        topic1.add(new Question("Name", "Topic 1", other));
        topic1.add(new Question("Last Name", "1", other));
        topic1.add(new Question("Club", "01", other));
        topic1.add(new Question("School", "10", other));
    }



    public ArrayList<Question> getQuestions() {
        return questions;
    }

}
