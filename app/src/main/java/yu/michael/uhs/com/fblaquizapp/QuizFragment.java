package yu.michael.uhs.com.fblaquizapp;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class QuizFragment extends Fragment {

    private Topic topic;
    private ArrayList<Button> options;
    private TextView question;
    private HashMap<Integer, Integer> used;
    private int correct;

    public QuizFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        topic = (Topic) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.quiz_fragment, container, false);
        buildUI(view);

        ArrayList<Question> questionsArrayList = topic.getQuestions();


        used = new HashMap<>();

        int chosenQ = new Random().nextInt(questionsArrayList.size());
        Question q = questionsArrayList.get(chosenQ);
        ArrayList<String> otherChoicesArrayList = q.getOtherChoices();
        question.setText(q.getQuestion());
        correct = new Random().nextInt(options.size());
        options.get(correct).setText(q.getAnswer());
        for (Button b : options) {
            int r = new Random().nextInt(otherChoicesArrayList.size());
            if (b.getText().toString().isEmpty()) {
                while (used.get(r) != null) {
                    r = new Random().nextInt(otherChoicesArrayList.size());
                }
                used.put(r, 1);
                b.setText(otherChoicesArrayList.get(r));
            } else {
                continue;
            }
        }

        for (Button option : options) {
            option.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button selected = (Button) view;
                    int index = options.indexOf(selected);
                    if (index == correct) {
                        Log.i("ANSWER: ", "CORRECT");
                        selected.setBackgroundColor(getContext().getColor(R.color.brightGreen));
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                topic.transition();
                            }
                        }, 250);

                    } else if (index != correct && index != -1) {
                        Log.i("ANSWER: ", "INCORRECT");
                        selected.setBackgroundColor(getContext().getColor(R.color.brightRed));
                    } else {
                        Log.i("ANSWER: ", "ERROR");
                    }
                }
            });
        }

        return view;
    }

    public void buildUI(View view) {

        question = (TextView) view.findViewById(R.id.question);

        options = new ArrayList<>();

        options.add((Button) view.findViewById(R.id.option_1));
        options.add((Button) view.findViewById(R.id.option_2));
        options.add((Button) view.findViewById(R.id.option_3));
        options.add((Button) view.findViewById(R.id.option_4));


    }
}
