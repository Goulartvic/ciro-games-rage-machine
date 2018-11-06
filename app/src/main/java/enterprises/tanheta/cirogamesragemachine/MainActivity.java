package enterprises.tanheta.cirogamesragemachine;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int lastSortImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeCiraoPicture();
        setOnClickListener(R.id.generate_rage);
    }

    private void setOnClickListener(int id) {
        findViewById(id).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.generate_rage: {
                rageGenerator();
                break;
            }
        }
    }

    private void rageGenerator() {
        Random random = new Random();
        List<String> firstPartList = Arrays.asList(getApplicationContext().getResources().getStringArray(R.array.rage_first_part));
        List<String> secondPartList = Arrays.asList(getApplicationContext().getResources().getStringArray(R.array.rage_second_part));
        List<String> thirdPartList = Arrays.asList(getApplicationContext().getResources().getStringArray(R.array.rage_third_part));
        int firstIndex = random.nextInt(firstPartList.size());
        int secondIndex = random.nextInt(secondPartList.size());
        int thirdIndex = random.nextInt(thirdPartList.size());

        String rage = firstPartList.get(firstIndex)
                + " "+ secondPartList.get(secondIndex) + " " + thirdPartList.get(thirdIndex);

        ((TextView) findViewById(R.id.rage_text)).setText(rage.toUpperCase() + "!");
        changeCiraoPicture();
    }

    private void changeCiraoPicture() {
        Random random = new Random();
        int sortImage = random.nextInt(8);
        while (sortImage == lastSortImage) {
            sortImage = random.nextInt(8);
        }
        lastSortImage = sortImage;
        Resources resources = getApplicationContext().getResources();
        final int resourceId = resources.getIdentifier("cirao" + sortImage, "drawable",
                getApplicationContext().getPackageName());
        Drawable ciraoPicture = resources.getDrawable(resourceId);

        ((ImageView) findViewById(R.id.ciro_face)).setImageDrawable(ciraoPicture);
    }
}
