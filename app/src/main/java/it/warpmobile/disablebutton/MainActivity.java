package it.warpmobile.disablebutton;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnRed;
    private Button btnBlu;
    private Button btnYellow;
    private Button btnGreen;

    private String colorSelected = "";
    private TextView tvColor;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler();
        findViews();
        setupViews();
    }

    private void setupViews() {
        btnRed.setOnClickListener(this);
        btnBlu.setOnClickListener(this);
        btnYellow.setOnClickListener(this);
        btnGreen.setOnClickListener(this);
    }

    private void findViews() {
        tvColor = (TextView) findViewById(R.id.tvColor);
        btnRed = (Button) findViewById(R.id.btnRed);
        btnBlu = (Button) findViewById(R.id.btnBlu);
        btnYellow = (Button) findViewById(R.id.btnYellow);
        btnGreen = (Button) findViewById(R.id.btnGreen);
    }

    @Override
    public void onClick(View view) {

        int id = view.getId();
        if (id == R.id.btnGreen) {

            colorSelected = "Green";
        } else if (id == R.id.btnBlu) {
            colorSelected = "Blu";

        } else if (id == R.id.btnYellow) {
            colorSelected = "Yellow";

        } else if (id == R.id.btnRed) {
            colorSelected = "Red";

        }
        disableEnableButtons(false);
        showColor();
        resetGame();

    }

    private void resetGame() {


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                disableEnableButtons(true);
            }
        }, 1500L);

    }

    private void showColor() {

        tvColor.setText("Hai selezionato il colore: " + colorSelected);
    }

    private void disableEnableButtons(boolean b) {
        btnRed.setEnabled(b);
        btnBlu.setEnabled(b);
        btnYellow.setEnabled(b);
        btnGreen.setEnabled(b);

    }
}
