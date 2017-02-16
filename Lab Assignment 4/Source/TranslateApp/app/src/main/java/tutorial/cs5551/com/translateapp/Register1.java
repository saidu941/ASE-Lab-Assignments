package tutorial.cs5551.com.translateapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Register1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    public void checkRegistrationCredentials(View v)
    {
        EditText reg_usernameCtrl= (EditText)findViewById(R.id.user_name);
        EditText reg_emailCtrl = (EditText)findViewById(R.id.user_email);
        EditText reg_pwdCtrl= (EditText)findViewById(R.id.user_pwd);
        EditText reg_cpwdCtrl= (EditText)findViewById(R.id.user_cpwd);
        TextView reg_textview =(TextView)findViewById(R.id.textView);

        String reg_username = reg_usernameCtrl.getText().toString();
        String reg_email = reg_emailCtrl.getText().toString();
        String reg_pwd = reg_pwdCtrl.getText().toString();
        String reg_cpwd = reg_cpwdCtrl.getText().toString();

        boolean validationFlag= false;
        //verify if the username and the password are empty
        if(!reg_username.isEmpty() && !reg_email.isEmpty() && !reg_pwd.isEmpty() && !reg_cpwd.isEmpty()){
            if(reg_username.equals("Admin") && reg_email.equals("Admin") && reg_pwd.equals("Admin") && reg_cpwd.equals(("Admin"))){
                validationFlag=true;
            }
        }
        if(!validationFlag){
            reg_textview.setVisibility(View.VISIBLE);
        }
        else{
            //this code redirects from login page to home page
            Intent redirect = new Intent (Register1.this, LoginActivity.class);
            startActivity(redirect);
        }
    }

    public void redirectToLogin(View v){
        Intent redirect_to_login = new Intent(Register1.this, LoginActivity.class);
        startActivity(redirect_to_login);
    }



}
