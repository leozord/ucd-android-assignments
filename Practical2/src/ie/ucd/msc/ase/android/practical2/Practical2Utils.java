package ie.ucd.msc.ase.android.practical2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;

public final class Practical2Utils {

	public static void clearText(ActionBarActivity activity, int fieldId) {
		EditText editText = (EditText) activity.findViewById(fieldId);
		editText.setText(null);
	}
	
	public static void backToMain(ActionBarActivity activity) {
    	Intent intent = new Intent();
    	activity.setResult(ActionBarActivity.RESULT_OK, intent);
    	activity.finish();
    }
	
	public static void openLayout(ActionBarActivity sourceActivity, View view, Class targetActivity) {
		Intent intent = new Intent(view.getContext(), targetActivity);
		sourceActivity.startActivity(intent);
	}
}
