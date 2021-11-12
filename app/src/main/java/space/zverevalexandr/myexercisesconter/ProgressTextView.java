package space.zverevalexandr.myexercisesconter;

import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.MessageFormat;

public class ProgressTextView extends androidx.appcompat.widget.AppCompatTextView {

    // Максимальное значение шкалы
    //private int mMaxValue = 100;


    public ProgressTextView(Context context) {
        super(context);
    }

    public ProgressTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ProgressTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    public void setMaxValue(int maxValue) {
//        maxValue = maxValue;
//    }

    public synchronized void setValue(int id, String title, int count, int plan) {
        // Установка новой надписи
        this.setText(MessageFormat.format("{0}\n{1} / {2}", title, count, plan));

        // Drawable, отвечающий за фон
        LayerDrawable background = (LayerDrawable) this.getBackground();

        // Достаём Clip, отвечающий за шкалу, по индексу 1
        ClipDrawable barValue = (ClipDrawable) background.getDrawable(1);

        // Устанавливаем уровень шкалы
        int newClipLevel = (int) (count * 10000 / plan);
        barValue.setLevel(newClipLevel);

        // Уведомляем об изменении Drawable
        drawableStateChanged();
    }
}
