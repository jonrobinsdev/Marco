package com.jonathanrobins.marco;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class LogInActivity extends ActionBarActivity {

    TextView logInTitle;
    EditText usernameTextField;
    EditText passwordTextField;
    Button logInButton;
    RelativeLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_log_in);

        //references
        mainLayout = (RelativeLayout) findViewById(R.id.mainLayout);
        usernameTextField = (EditText) findViewById(R.id.usernameTextField);
        passwordTextField = (EditText) findViewById(R.id.passwordTextField);
        logInButton = (Button) findViewById(R.id.logInButton);

        //text modifications
        Typeface typeface = Typeface.createFromAsset(getAssets(), "OpenSans-Regular.ttf");
        logInTitle = (TextView) findViewById(R.id.logInTitle);
        logInButton = (Button) findViewById(R.id.logInButton);
        usernameTextField.setTypeface(typeface);
        passwordTextField.setTypeface(typeface);
        logInTitle.setTypeface(typeface);
        logInButton.setTypeface(typeface);

        //on click/focus methods
        focusAndOnClickLogic();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_log_in, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void focusAndOnClickLogic() {
        mainLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        });
        logInButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(LogInActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
