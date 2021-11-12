package space.zverevalexandr.myexercisesconter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private int count;

    // имя файла настройки
    public static final String APP_PREFERENCES = "mySettings";
    public static final String APP_PREFERENCES_COUNTER_PULL = "counterPull";
    public static final String APP_PREFERENCES_COUNTERS_PUSH = "counterPush";
    public static final String APP_PREFERENCES_COUNTER_SQUATS = "counterSquats";
    public static final String APP_PREFERENCES_COUNTER_JUMPING = "counterJumping";
    private SharedPreferences mSettings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        onResume();
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

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt(APP_PREFERENCES_COUNTER_PULL, Store.getmCountPull());
        editor.putInt(APP_PREFERENCES_COUNTERS_PUSH, Store.getmCountPush());
        editor.putInt(APP_PREFERENCES_COUNTER_SQUATS, Store.getmCountSquats());
        editor.putInt(APP_PREFERENCES_COUNTER_JUMPING, Store.getmCountJumping());
        editor.apply();
    }

    public void onClickButtonStart(View view) {
        Intent intent = new Intent(MainActivity.this, ChoosingAnExerciseActivity.class);
        startActivity(intent);
    }

    public void onClickAbout(View view) {
        Intent intent = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(intent);
    }
}