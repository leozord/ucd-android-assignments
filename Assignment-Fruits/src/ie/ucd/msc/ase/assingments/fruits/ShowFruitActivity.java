package ie.ucd.msc.ase.assingments.fruits;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowFruitActivity extends Activity {

	private Bitmap bitmap;
	private ImageView imageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_fruit);
		
		Fruit fruit = (Fruit) getIntent().getSerializableExtra("ie.ucd.msc.ase.assingments.fruits.selectedFruit");
		
		if(fruit == null) {
			return;
		}
		
		imageView = (ImageView) findViewById(R.id.imgView);
		
		InputStream openRawResource = getResources().openRawResource(fruit.getRealImg());
		bitmap = BitmapFactory.decodeStream(openRawResource);
		imageView.setImageBitmap(bitmap);
		
		try {
			openRawResource.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TextView initial = (TextView) findViewById(R.id.txtInitial);
		initial.setText(fruit.getName().substring(0, 1));
		
		TextView fruitName = (TextView) findViewById(R.id.txtFruitName);
		fruitName.setText(fruit.getName().substring(1));
		
		
		Typeface face=Typeface.createFromAsset(getAssets(),
                "fonts/LDFComicSansBold.ttf");

		initial.setTypeface(face);
		fruitName.setTypeface(face);
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		imageView.setImageBitmap(null);
		bitmap.recycle();
	}
	
	public void exit(View view) {
		onBackPressed();
	}
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		finish();
	}
}
