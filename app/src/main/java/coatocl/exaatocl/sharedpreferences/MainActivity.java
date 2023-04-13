package coatocl.exaatocl.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity
{

EditText editText,editText2;
Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.editText);
        editText2=findViewById(R.id.editText2);
        button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"SHARED PREFERENCE DONE!", LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

//        for read data for first time.
        SharedPreferences sharedPreferences=getSharedPreferences("shared",MODE_PRIVATE);
        String st=sharedPreferences.getString("name","");
        String a=sharedPreferences.getString("password","");

       editText.setText(st);
       editText2.setText(a);
    }

    @Override
    protected void onPause() {
        super.onPause();

//        when user close the app & again come to
        SharedPreferences sharedPreferences2=getSharedPreferences("shared",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences2.edit();

        editor.putString("name",editText.getText().toString());
        editor.putString("password",editText2.getText().toString());
        editor.apply();
    }
}
