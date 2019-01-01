package my.edu.tarc.user.smartplat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button register;
    private SQLiteHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        register = (Button)findViewById(R.id.register);

        //SQLite database handler
        db = new SQLiteHandler(getApplicationContext());

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usname = username.getText().toString();
                String psw = password.getText().toString();
                if(!usname.isEmpty()&&!psw.isEmpty()){
                    Toast.makeText(getApplicationContext(),
                            "Welcome",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),
                            "Please Fill In All Detail",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
