package space.zverevalexandr.myexercisesconter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.text.MessageFormat;

public class MainActivity extends AppCompatActivity {

    private int count;
    private Button mButton;

    // имя файла настройки
    public static final String APP_PREFERENCES = "mySettings";
    public static final String APP_PREFERENCES_COUNTER_PUSH = "counterPush";
    private SharedPreferences mSettings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton =findViewById(R.id.button_count);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        onResume();
        mButton.setText(MessageFormat.format("{0}", Store.mCountJumping));
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mSettings.contains(APP_PREFERENCES_COUNTER_PUSH)) {
            Store.mCountJumping = mSettings.getInt(APP_PREFERENCES_COUNTER_PUSH, 0);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt(APP_PREFERENCES_COUNTER_PUSH, Store.mCountJumping);
        editor.apply();
    }

    public void onClickButtonStart(View view) {
        Intent intent = new Intent(MainActivity.this, ChoosingAnExerciseActivity.class);
        startActivity(intent);
    }

    public void onClickButtonCount(View view) {
        Store.mCountJumping++;
        mButton.setText(MessageFormat.format("{0}", Store.mCountJumping));

    }
}