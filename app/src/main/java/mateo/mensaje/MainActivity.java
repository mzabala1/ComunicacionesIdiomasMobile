package mateo.mensaje;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView infoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infoTextView = (TextView) findViewById(R.id.infoTextView);

        //Para mostrar informacion extra
        if (getIntent().getExtras() != null){

            for (String key : getIntent().getExtras().keySet()){

                String value = getIntent().getExtras().getString(key);
                infoTextView.append("\n" + key + ": " + value);

            }

        }
    }
}
