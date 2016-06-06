package notificationstera.teravision.com.teranotifications;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import notificationstera.teravision.com.teranotifications.util.StringUtil;

/**
 * Created by Sara Villarreal on 6/6/2016.
 */
public class LoginActivity extends Activity implements View.OnClickListener {
    private String mUser, mPassword;
    private  EditText mUserEditText, mPasswordEditText;
    private Button mAcceptButton, mCancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        mUserEditText = (EditText) findViewById(R.id.edit_text_usuario_login);
        mPasswordEditText = (EditText) findViewById(R.id.edit_text_password_login);
        mAcceptButton = (Button) findViewById(R.id.btn_accept_login);
        mAcceptButton.setOnClickListener(this);
        mCancelButton = (Button) findViewById(R.id.btn_cancel_login);
        mCancelButton.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_accept_login:
                login();
                break;
            case R.id.btn_cancel_login:
                break;
        }
    }

    private void login(){
            validateFields();
            Intent intent = new Intent(LoginActivity.this, MapsActivity.class);
            startActivity(intent);
    }

    private void validateFields(){
        mUser = mUserEditText.getText().toString().trim();
        mPassword = mPasswordEditText.getText().toString().trim();
        if (mUser.equals("")) {
            mUserEditText.requestFocus();
            mUserEditText.setError(getString(R.string.user_empty));
            return;
        } else if (mPassword.equals("")) {
            mPasswordEditText.setError(getString(R.string.password_empty));
            mPasswordEditText.requestFocus();
            return;
        }
    }

}
