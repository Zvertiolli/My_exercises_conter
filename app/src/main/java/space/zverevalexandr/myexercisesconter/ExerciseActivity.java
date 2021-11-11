package space.zverevalexandr.myexercisesconter;

import static space.zverevalexandr.myexercisesconter.MainActivity.APP_PREFERENCES_COUNTERS_PUSH;
import static space.zverevalexandr.myexercisesconter.MainActivity.APP_PREFERENCES_COUNTER_JUMPING;
import static space.zverevalexandr.myexercisesconter.MainActivity.APP_PREFERENCES_COUNTER_PULL;
import static space.zverevalexandr.myexercisesconter.MainActivity.APP_PREFERENCES_COUNTER_SQUATS;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

    // имя файла настройки
    private SharedPreferences mSettings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        mSettings = getSharedPreferences(MainActivity.APP_PREFERENCES, Context.MODE_PRIVATE);


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
        saveCounts();
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveCounts();
    }

    private void saveCounts() {
        int id = getIntent().getExtras().getInt("id");
        SharedPreferences.Editor editor = mSettings.edit();
        switch (id) {
            case (1):
                editor.putInt(APP_PREFERENCES_COUNTER_PULL, readyCount);
                break;
            case (2):
                editor.putInt(APP_PREFERENCES_COUNTERS_PUSH, readyCount);
                break;
            case (3):
                editor.putInt(APP_PREFERENCES_COUNTER_SQUATS, readyCount);
                break;
            case (4):
                editor.putInt(APP_PREFERENCES_COUNTER_JUMPING, readyCount);
                break;
        }
        editor.apply();
    }
}



