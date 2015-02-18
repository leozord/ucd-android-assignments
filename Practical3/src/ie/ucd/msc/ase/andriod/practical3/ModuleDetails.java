package ie.ucd.msc.ase.andriod.practical3;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class ModuleDetails extends ActionBarActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_module_details);
		
		Module module = (Module) getIntent().getSerializableExtra("ie.ucd.msc.ase.android.practical3.selected_module");
		TextView name = (TextView) findViewById(R.id.textView1);
		name.setText(module.getName());
		TextView credits = (TextView) findViewById(R.id.textView2);
		credits.setText("Credits: " + module.getNumberOfCredits());
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.module_details, menu);
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
	
	public void finish(View view) {
		finish();
	}
}
