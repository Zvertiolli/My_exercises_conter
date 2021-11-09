package space.zverevalexandr.myexercisesconter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.MessageFormat;

public class ExerciseActivity extends AppCompatActivity {

    TextView actualCounter;
    TextView exerciseTitle;
    TextView plan;
    TextView readyExercise;
    int actualCount = 0;
    int readyCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        actualCounter = findViewById(R.id.textViewCount);
        exerciseTitle = findViewById(R.id.exerciseTitle);
        plan = findViewById(R.id.plan);
        readyExercise = findViewById(R.id.readyExercise);

        exerciseTitle.setText(getIntent().getExtras().getString("titleExercise"));
        plan.setText(MessageFormat.format("{0}", getIntent().getExtras().getInt("plan")));
        readyCount = getIntent().getExtras().getInt("ready");
        readyExercise.setText(MessageFormat.format("{0}", readyCount));
    }

    public void onClickButtonPlus(View view) {
        actualCount++;
        actualCounter.setText(MessageFormat.format("{0}", actualCount));
        readyCount++;
        readyExercise.setText(MessageFormat.format("{0}", readyCount));

    }

    public void onClickButtonMinus(View view) {
        actualCount--;
        actualCounter.setText(MessageFormat.format("{0}", actualCount));
        readyCount--;

        readyExercise.setText(MessageFormat.format("{0}", readyCount));


    }

    public void onClickDone(View view) {
        Intent intent = new Intent(ExerciseActivity.this, ChoosingAnExerciseActivity.class);
        int id = getIntent().getExtras().getInt("id");
        switch (id) {
            case (1):
                Store.setmCountPush(readyCount);
                break;
            case (2):
                Store.setmCountPull(readyCount);
                break;
            case (3):
                Store.setmCountSquats(readyCount);
                break;
            case (4):
                Store.setmCountJumping(readyCount);
                break;
        }
        startActivity(intent);
    }
}