package space.zverevalexandr.myexercisesconter;

import static space.zverevalexandr.myexercisesconter.MainActivity.APP_PREFERENCES_COUNTERS_PUSH;
import static space.zverevalexandr.myexercisesconter.MainActivity.APP_PREFERENCES_COUNTER_JUMPING;
import static space.zverevalexandr.myexercisesconter.MainActivity.APP_PREFERENCES_COUNTER_PULL;
import static space.zverevalexandr.myexercisesconter.MainActivity.APP_PREFERENCES_COUNTER_SQUATS;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

import space.zverevalexandr.myexercisesconter.adapter.ExerciseAdapter;
import space.zverevalexandr.myexercisesconter.model.Exercise;

public class ChoosingAnExerciseActivity extends AppCompatActivity {


    private RecyclerView mExerciseRecycler;
    private ExerciseAdapter mExerciseAdapter;


    // имя файла настройки
    private SharedPreferences mSettings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chootsing_an_exercise);

        mSettings = getSharedPreferences(MainActivity.APP_PREFERENCES, Context.MODE_PRIVATE);

        onResume();

        List<Exercise> exerciseList = new ArrayList<>();

        exerciseList.add(new Exercise(1, "Подтягивания", Store.getmCountPull(), Store.getmPlanPull()));
        exerciseList.add(new Exercise(2, "Отжимания", Store.getmCountPush(), Store.getmPlanPush()));
        exerciseList.add(new Exercise(3, "Приседания", Store.getmCountSquats(), Store.getmPlanSquats()));
        exerciseList.add(new Exercise(4, "Прыжки", Store.getmCountJumping(), Store.getmPlanJumping()));

        setmExerciseRecycler(exerciseList);


    }

    private void setmExerciseRecycler(List<Exercise> exerciseList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        mExerciseRecycler = findViewById(R.id.exerciseRecycler);
        mExerciseRecycler.setLayoutManager(layoutManager);

        mExerciseAdapter = new ExerciseAdapter(this, exerciseList);
        mExerciseRecycler.setAdapter(mExerciseAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mSettings.contains(APP_PREFERENCES_COUNTER_PULL)) {
            Store.setmCountPull(mSettings.getInt(APP_PREFERENCES_COUNTER_PULL, 0));
        }
        if (mSettings.contains(APP_PREFERENCES_COUNTERS_PUSH)) {
            Store.setmCountPush(mSettings.getInt(APP_PREFERENCES_COUNTERS_PUSH, 0));
        }
        if (mSettings.contains(APP_PREFERENCES_COUNTER_SQUATS)) {
            Store.setmCountSquats(mSettings.getInt(APP_PREFERENCES_COUNTER_SQUATS, 0));
        }
        if (mSettings.contains(APP_PREFERENCES_COUNTER_JUMPING)) {
            Store.setmCountJumping(mSettings.getInt(APP_PREFERENCES_COUNTER_JUMPING, 0));
        }
    }


}