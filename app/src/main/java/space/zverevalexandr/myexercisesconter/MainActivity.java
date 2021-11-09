package space.zverevalexandr.myexercisesconter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // имя файла настройки
    public static final String APP_PREFERENCES = "mySettings";
    public static final String APP_PREFERENCES_COUNTER = "counter";
    private SharedPreferences mSettings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mSettings.contains(APP_PREFERENCES_COUNTER)) {
            Store.setmCountPull(mSettings.getInt(APP_PREFERENCES_COUNTER, 0));
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt(APP_PREFERENCES_COUNTER, Store.getmCountPull());
    }

    public void onClickButtonStart(View view) {
        Intent intent = new Intent(MainActivity.this, ChoosingAnExerciseActivity.class);
        startActivity(intent);
    }
}