package space.zverevalexandr.myexercisesconter;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

import space.zverevalexandr.myexercisesconter.adapter.ExerciseAdapter;
import space.zverevalexandr.myexercisesconter.model.Exercise;

public class ChoosingAnExerciseActivity extends AppCompatActivity {


    RecyclerView exerciseRecycler;
    ExerciseAdapter exerciseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chootsing_an_exercise);

        List<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(new Exercise(1, "Отжимания", Store.getmCountPush(),Store.getmPlanPush()));
        exerciseList.add(new Exercise(2, "Подтягивания", Store.mCountPull, Store.mPlanPull));
        exerciseList.add(new Exercise(3, "Приседания", Store.mCountSquats, Store.mPlanSquats));
        exerciseList.add(new Exercise(4, "Прыжки", Store.mCountJumping, Store.mPlanJumping));

        setExerciseRecycler(exerciseList);
    }

    private void setExerciseRecycler(List<Exercise> exerciseList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        exerciseRecycler = findViewById(R.id.exerciseRecycler);
        exerciseRecycler.setLayoutManager(layoutManager);

        exerciseAdapter = new ExerciseAdapter(this, exerciseList);
        exerciseRecycler.setAdapter(exerciseAdapter);
    }
}