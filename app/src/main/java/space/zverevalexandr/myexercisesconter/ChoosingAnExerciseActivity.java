package space.zverevalexandr.myexercisesconter;

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
    public int mPlanSquats = 100;
    public int mCountSquats;


    // имя файла настройки
    public static final String APP_PREFERENCES = "mySettings";
    public static final String APP_PREFERENCES_COUNTER_PUSH = "counterPush";
    private SharedPreferences mSettings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chootsing_an_exercise);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        onResume();

        List<Exercise> exerciseList = new ArrayList<>();

        exerciseList.add(new Exercise(1, "Отжимания", Store.getmCountPush(), Store.getmPlanPush()));
        exerciseList.add(new Exercise(2, "Подтягивания", Store.mCountPull, Store.mPlanPull));
        exerciseList.add(new Exercise(3, "Приседания", mCountSquats, mPlanSquats));
        exerciseList.add(new Exercise(4, "Прыжки", Store.mCountJumping, Store.mPlanJumping));

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
        if (mSettings.contains(APP_PREFERENCES_COUNTER_PUSH)) {
            Store.mCountJumping = mSettings.getInt(APP_PREFERENCES_COUNTER_PUSH, 0);
        }
    }


}