package ie.ucd.msc.ase.assingments.fruits;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FruitAdapter extends ArrayAdapter<Fruit> {

	private Context context;
	private int layoutResourceId;
	private List<Fruit> fruits;

	public FruitAdapter(Context context, int layoutResourceId,
			List<Fruit> fruits) {
		super(context, layoutResourceId, fruits);
		this.context = context;
		this.layoutResourceId = layoutResourceId;
		this.fruits = fruits;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		FruitsHolder holder = null;

		if (row == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			row = inflater.inflate(layoutResourceId, parent, false);

			holder = new FruitsHolder();
			holder.imgIcon = (ImageView) row.findViewById(R.id.imgIcon);
			holder.txtTitle = (TextView) row.findViewById(R.id.txtTitle);
			holder.layout = (RelativeLayout) row.findViewById(R.id.item); 

			row.setTag(holder);
		} else {
			holder = (FruitsHolder) row.getTag();
		}

		Fruit fruit = fruits.get(position);
		holder.txtTitle.setText(fruit.getShortName());
		holder.imgIcon.setImageResource(fruit.getImage());
		holder.layout.setBackgroundColor(fruit.getColor());

		return row;
	}

	static class FruitsHolder {
		ImageView imgIcon;
		TextView txtTitle;
		RelativeLayout layout;
	}

}
