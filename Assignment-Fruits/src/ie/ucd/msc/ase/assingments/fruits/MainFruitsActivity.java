package ie.ucd.msc.ase.assingments.fruits;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class MainFruitsActivity extends ActionBarActivity {

	private ListView listView;
	private static List<Fruit> fruits = new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fruits);
     
        Configuration conf = getResources().getConfiguration();
        DisplayMetrics metrics = new DisplayMetrics();
        Resources resources = new Resources(getAssets(), metrics, conf);
        
        fruits.add(new Fruit(R.drawable.apple, resources.getString(R.string.fruit_apple),Color.CYAN, R.drawable.apple_real));
        fruits.add(new Fruit(R.drawable.banana, resources.getString(R.string.fruit_banana), Color.GREEN, R.drawable.banana_real));
        fruits.add(new Fruit(R.drawable.grape, resources.getString(R.string.fruit_grape), Color.MAGENTA, R.drawable.grape_real));
        fruits.add(new Fruit(R.drawable.orange, resources.getString(R.string.fruit_orange), Color.RED, R.drawable.orange_real));
        fruits.add(new Fruit(R.drawable.pear, resources.getString(R.string.fruit_pear), Color.YELLOW, R.drawable.pear_real));
        
        FruitAdapter adapter = new FruitAdapter(this, R.layout.listview_custom_row, fruits);
        
        listView = (ListView) findViewById(R.id.fruitsList);
        listView.setAdapter(adapter);
        
        addEventListener();
    }
    
    private void addEventListener() {
		ListView listView = (ListView) findViewById(R.id.fruitsList);
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(parent.getContext(), ShowFruitActivity.class);
				intent.putExtra("ie.ucd.msc.ase.assingments.fruits.selectedFruit", fruits.get(position));
				MainFruitsActivity.this.startActivity(intent);
			}
			
		});
	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_fruits, menu);
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
