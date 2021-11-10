package space.zverevalexandr.myexercisesconter;

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
        int id = getIntent().getExtras().getInt("id");
        SharedPreferences.Editor editor = mSettings.edit();
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
                editor.putInt(MainActivity.APP_PREFERENCES_COUNTER_PUSH, readyCount);
                break;
        }
        editor.apply();
        startActivity(intent);
    }
}