package ie.ucd.msc.ase.assignement1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.TextView;

public class EditEmailActivity extends ActionBarActivity {

	public static final String SHARED_PREFERENCE = "Assignment1";
	private static final String EMAIL_ENTITY = "EMAIL_ENTITY";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_email);
		loadEmailIntoFields(this);
		addLostFocus();
	}
	
	
	private void loadEmailIntoFields(ActionBarActivity activity) {
		SharedPreferences preferences = activity.getSharedPreferences(SHARED_PREFERENCE, MODE_PRIVATE);
		
		setTextToEditText(preferences.getString("from", ""), R.id.txtFrom, activity);
		setTextToEditText(preferences.getString("to", ""), R.id.txtTo, activity);
		setTextToEditText(preferences.getString("cc", ""), R.id.txtCC, activity);
		setTextToEditText(preferences.getString("bcc", ""), R.id.txtBCC, activity);
		setTextToEditText(preferences.getString("subject", ""), R.id.txtSubject, activity);
		setTextToEditText(preferences.getString("message", ""), R.id.txtMessage, activity);
	}
	
	private void setTextToEditText(String value, int editTextId, ActionBarActivity activity) {
		final TextView editText = (TextView) activity.findViewById(editTextId);
		editText.setText(value);
	}

	private void addLostFocus() {
		SharedPreferences preferences = getSharedPreferences(SHARED_PREFERENCE, MODE_PRIVATE);
		final Editor edit = preferences.edit();
		
		final EditText txtFrom = (EditText) findViewById(R.id.txtFrom);

		txtFrom.setOnFocusChangeListener(new OnFocusChangeListener() {

			public void onFocusChange(View v, boolean hasFocus) {
				if (!hasFocus) {
					edit.putString("from", txtFrom.getText().toString());
					edit.commit();
				}
			}
		});
		final EditText txtTo = (EditText) findViewById(R.id.txtTo);
		
		txtTo.setOnFocusChangeListener(new OnFocusChangeListener() {
			
			public void onFocusChange(View v, boolean hasFocus) {
				if (!hasFocus) {
					edit.putString("to", txtTo.getText().toString());
					edit.commit();
				}
			}
		});
		final EditText txtCC = (EditText) findViewById(R.id.txtCC);
		
		txtCC.setOnFocusChangeListener(new OnFocusChangeListener() {
			
			public void onFocusChange(View v, boolean hasFocus) {
				if (!hasFocus) {
					edit.putString("cc", txtCC.getText().toString());
					edit.commit();
				}
			}
		});
		final EditText txtBCC = (EditText) findViewById(R.id.txtBCC);
		
		txtBCC.setOnFocusChangeListener(new OnFocusChangeListener() {
			
			public void onFocusChange(View v, boolean hasFocus) {
				if (!hasFocus) {
					edit.putString("bcc", txtBCC.getText().toString());
					edit.commit();
				}
			}
		});
		final EditText txtSubject = (EditText) findViewById(R.id.txtSubject);
		
		txtSubject.setOnFocusChangeListener(new OnFocusChangeListener() {
			
			public void onFocusChange(View v, boolean hasFocus) {
				if (!hasFocus) {
					edit.putString("subject", txtSubject.getText().toString());
					edit.commit();
				}
			}
		});
		final EditText txtMessage = (EditText) findViewById(R.id.txtMessage);
		
		txtMessage.setOnFocusChangeListener(new OnFocusChangeListener() {
			
			public void onFocusChange(View v, boolean hasFocus) {
				if (!hasFocus) {
					edit.putString("message", txtMessage.getText().toString());
					edit.commit();
				}
			}
		});
		
	}
	
	@Override
	protected void onDestroy() {
		saveAllFieldsState();
		super.onDestroy();
	}
	
	private void saveAllFieldsState() {
		SharedPreferences preferences = getSharedPreferences(SHARED_PREFERENCE, MODE_PRIVATE);
		final Editor edit = preferences.edit();
		saveTextFieldState(edit, "from", R.id.txtFrom);
		saveTextFieldState(edit, "to", R.id.txtTo);
		saveTextFieldState(edit, "cc", R.id.txtCC);
		saveTextFieldState(edit, "bcc", R.id.txtBCC);
		saveTextFieldState(edit, "subject", R.id.txtSubject);
		saveTextFieldState(edit, "message", R.id.txtMessage);
		edit.commit();
	}
	
	private void saveTextFieldState(Editor edit, String key, int fieldId) {
		final EditText editText = (EditText) findViewById(fieldId);
		edit.putString(key, editText.getText().toString());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_email, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void clearFields(View view) {
		clearText(this, R.id.txtFrom);
		clearText(this, R.id.txtTo);
		clearText(this, R.id.txtCC);
		clearText(this, R.id.txtBCC);
		clearText(this, R.id.txtSubject);
		clearText(this, R.id.txtMessage);
		saveAllFieldsState();
	}

	public static void clearText(ActionBarActivity activity, int fieldId) {
		EditText editText = (EditText) activity.findViewById(fieldId);
		editText.setText(null);
	}
	
	public void send(View view) {
		saveAllFieldsState();
		Intent intent = new Intent(view.getContext(), ReadEmailActivity.class);
		this.startActivity(intent);
	}
}
