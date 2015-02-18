package ie.ucd.msc.ase.andriod.practical3;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

	private List<Module> modules;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateModules();
        listModulesOnGUI();
        addEventListener();
    }

	private void populateModules() {
    	modules = new ArrayList<Module>();
    	modules.add(new Module("COMP 3041 - Android Dev", 5));
    	modules.add(new Module("COMP 3042 - BPM", 8));
    	modules.add(new Module("COMP 3043 - C++", 4));
    	modules.add(new Module("COMP 3044 - Delphi", 2));
    	modules.add(new Module("COMP 3045 - Erlang", 3));
    	modules.add(new Module("COMP 3046 - Go Lang", 2));
    	modules.add(new Module("COMP 3047 - Functional Programming", 6));
    	modules.add(new Module("COMP 3048 - Hadoop", 8));
    	modules.add(new Module("COMP 3049 - Illustrator", 5));
    	modules.add(new Module("COMP 3050 - Java", 10));
	}

	private void listModulesOnGUI() {
		ArrayAdapter<Module> modulesAdapter = new ArrayAdapter<Module>(this, android.R.layout.simple_list_item_1, modules);
		ListView listView = (ListView) findViewById(R.id.listView1);
		listView.setAdapter(modulesAdapter);
	}
	
	private void addEventListener() {
		ListView listView = (ListView) findViewById(R.id.listView1);
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				TextView selectedView = (TextView) view;
				//Toast.makeText(MainActivity.this, modules.get(position).toString(), Toast.LENGTH_LONG).show();;
				
				Intent intent = new Intent(parent.getContext(), ModuleDetails.class);
				intent.putExtra("ie.ucd.msc.ase.android.practical3.selected_module", modules.get(position));
				MainActivity.this.startActivity(intent);
			}
			
		});
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
}
