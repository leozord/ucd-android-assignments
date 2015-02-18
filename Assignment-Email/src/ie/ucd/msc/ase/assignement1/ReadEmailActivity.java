package ie.ucd.msc.ase.assignement1;

import android.support.v7.app.ActionBarActivity;
import android.text.method.ScrollingMovementMethod;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ReadEmailActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_read_email);
		
		TextView txtMessage = (TextView) findViewById(R.id.txtMessage);
		txtMessage.setMovementMethod(new ScrollingMovementMethod());
		
		loadEmailIntoFields(this);
	}
	
	private void loadEmailIntoFields(ActionBarActivity activity) {
		SharedPreferences preferences = activity.getSharedPreferences(EditEmailActivity.SHARED_PREFERENCE, MODE_PRIVATE);
		
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.read_email, menu);
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
	
	@Override
	public void onBackPressed() {
		Intent intent = new Intent();
    	this.setResult(ActionBarActivity.RESULT_OK, intent);
    	this.finish();
	}
}
