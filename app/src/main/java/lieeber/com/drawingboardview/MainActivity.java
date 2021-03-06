package lieeber.com.drawingboardview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.lieeber.library.DrawingBoardView;
import com.lieeber.library.SheetUtil;

public class MainActivity extends AppCompatActivity {

    private DrawingBoardView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myView = (DrawingBoardView) findViewById(R.id.myView);

        findViewById(R.id.tvLine).setOnLongClickListener(new View.OnLongClickListener() {
            @Override public boolean onLongClick(View v) {
                SheetUtil sheetUtil = SheetUtil.getInstance();
                int color = myView.getlineColor();
                float progress = myView.getLineWidthProgress();
                sheetUtil.addSheet(MainActivity.this, color, progress);
                sheetUtil.showSheet();
                sheetUtil.setSeekBarChangeListener(new SheetUtil.SeekBarChangeListener() {
                    @Override public void onProgress(float progress) {
                        myView.setLineWidthProgress(progress);
                        myView.setLineWidth();
                    }

                    @Override public void onColorChange(int color) {
                        myView.setLineColor(color);
                    }
                });
                return false;
            }
        });

        findViewById(R.id.tvPaint).setOnLongClickListener(new View.OnLongClickListener() {
            @Override public boolean onLongClick(View v) {
                SheetUtil sheetUtil = SheetUtil.getInstance();
                int color = myView.getPaintColor();
                float progress = myView.getPaintWidthProgress();
                sheetUtil.addSheet(MainActivity.this, color, progress);
                sheetUtil.showSheet();
                sheetUtil.setSeekBarChangeListener(new SheetUtil.SeekBarChangeListener() {
                    @Override public void onProgress(float progress) {
                        myView.setPaintWidthProgress(progress);
                        myView.setPaintWidth();
                    }

                    @Override public void onColorChange(int color) {
                        myView.setPaintColor(color);
                    }
                });
                return false;
            }
        });
        findViewById(R.id.tvEraser).setOnLongClickListener(new View.OnLongClickListener() {
            @Override public boolean onLongClick(View v) {
                float progress = myView.getEraserWidthProgress();
                SheetUtil sheetUtil = SheetUtil.getInstance();
                sheetUtil.addSheet(MainActivity.this,-1, progress);
                sheetUtil.showSheet();
                sheetUtil.setSeekBarChangeListener(new SheetUtil.SeekBarChangeListener() {
                    @Override public void onProgress(float progress) {
                        myView.setEraserWidthProgress(progress);
                        myView.setEraserWidth();
                    }

                    @Override public void onColorChange(int color) {
                    }
                });
                return false;
            }
        });
        findViewById(R.id.tvLine).setSelected(true);
    }


//    public void click(View view) {
//        Vibrator vib = (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);
//        vib.vibrate(500);
//    }

    public void clear(View view) {
        myView.clear();
    }

    public void reset(View view) {
        myView.reset();
    }

    public void forward(View view) {
        myView.forward();
    }

    public void drawLine(View view) {
        clearSelect();
        findViewById(R.id.tvLine).setSelected(true);
        myView.setDrawLine();
    }

//    public void drawFill(View view) {
//        myView.setDrawFill();
//    }

    public void drawPaint(View view) {
        clearSelect();
        findViewById(R.id.tvPaint).setSelected(true);
        myView.setDrawPaint();
    }

    public void eraser(View view) {
        clearSelect();
        findViewById(R.id.tvEraser).setSelected(true);
        myView.setEraser();
    }
    public  void clearSelect() {
        findViewById(R.id.tvEraser).setSelected(false);
        findViewById(R.id.tvLine).setSelected(false);
        findViewById(R.id.tvPaint).setSelected(false);
    }

    public void save(View view) {
        myView.save();
    }
}
