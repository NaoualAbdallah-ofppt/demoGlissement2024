package aa.bb.demoglissement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView img;
int[] TabImg ={R.drawable.ic_metro,R.drawable.ic_rer,R.drawable.ic_tgv};
int p=0;
float X1,X2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=findViewById(R.id.MonImg);
        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        X1=motionEvent.getX();
                        break;
                    case MotionEvent.ACTION_UP:
                        X2=motionEvent.getX();
                        if (X1<X2)
                            if (p==0)
                                p=TabImg.length-1;
                            else
                                p--;
                        if (X1>X2)
                            if (p==TabImg.length-1)
                                p=0;
                            else
                                p++;
                        img.setImageResource(TabImg[p])     ;
                        break;
                }

                return true;
            }
        });

    }
}