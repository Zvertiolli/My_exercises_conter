package space.zverevalexandr.myexercisesconter.adapter;


import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.text.MessageFormat;
import java.util.List;

import space.zverevalexandr.myexercisesconter.ExerciseActivity;
import space.zverevalexandr.myexercisesconter.ProgressTextView;
import space.zverevalexandr.myexercisesconter.R;
import space.zverevalexandr.myexercisesconter.model.Exercise;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder> {

    Context context;
    List<Exercise> exerciseList;

    public ExerciseAdapter(Context context, List<Exercise> exerciseList) {
        this.context = context;
        this.exerciseList = exerciseList;
    }

    @NonNull
    @Override
    public ExerciseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View exerciseItems = LayoutInflater.from(context).inflate(R.layout.exercise_item_progress_bar, parent, false);
        return new ExerciseViewHolder(exerciseItems);
    }

    @Override
    public void onBindViewHolder(@NonNull final ExerciseViewHolder holder, int position) {
       // holder.exerciseTitle.setText(exerciseList.get(position).getTitle());
        holder.progressTextView.setValue(
                exerciseList.get(position).getId(),
                exerciseList.get(position).getTitle(),
                exerciseList.get(position).getCount(),
                exerciseList.get(position).getPlan()
                );

        //holder.exerciseCount.setText(MessageFormat.format("{0}", exerciseList.get(holder.getAdapterPosition()).getCount()));

        holder.itemView.setOnClickListener(v -> {

            Intent intent =new Intent(context, ExerciseActivity.class);

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((Activity) context,
                    new Pair<View, String>(holder.progressTextView,"progressBarImage"));


            intent.putExtra("titleExercise",exerciseList.get(holder.getAdapterPosition()).getTitle());
            intent.putExtra("plan",exerciseList.get(holder.getAdapterPosition()).getPlan());
            intent.putExtra("ready",exerciseList.get(holder.getAdapterPosition()).getCount());
            intent.putExtra("id",exerciseList.get(holder.getAdapterPosition()).getId());
            context.startActivity(intent, options.toBundle());
        });
    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }

    public static final class ExerciseViewHolder extends RecyclerView.ViewHolder {

        //TextView exerciseTitle;
        TextView exerciseCount;
        ProgressTextView progressTextView;

        public ExerciseViewHolder(@NonNull View itemView) {
            super(itemView);

            //exerciseTitle = itemView.findViewById(R.id.progressTextView);
            //exerciseCount = itemView.findViewById(R.id.exerciseCount);
            progressTextView =itemView.findViewById(R.id.progressTextView);
        }
    }
}
