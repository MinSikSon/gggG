package son.funkydj3.gggg.activities;

import son.funkydj3.achartengine.Chart1;
import son.funkydj3.achartengine.Chart2;
import son.funkydj3.achartengine.Chart3;
import son.funkydj3.achartengine.Chart_total;
import son.funkydj3.gggg.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	
	Button btn_Chart1;
	Button btn_Chart2;
	Button btn_Chart3;
	Button btn_Chart_total;
	private void init(){
		btn_Chart1 = (Button)findViewById(R.id.btn_Chart1);
		btn_Chart1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this, Chart1.class);
				startActivity(i);
			}
		});
		btn_Chart2 = (Button)findViewById(R.id.btn_Chart2);
		btn_Chart2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent ii = new Intent(MainActivity.this, Chart2.class);
				startActivity(ii);
			}
		});
		btn_Chart3 = (Button)findViewById(R.id.btn_Chart3);
		btn_Chart3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent iii = new Intent(MainActivity.this, Chart3.class);
				startActivity(iii);
			}
		});
		btn_Chart_total = (Button)findViewById(R.id.btn_Chart_total);
		btn_Chart_total.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent iiii = new Intent(MainActivity.this, Chart_total.class);
				startActivity(iiii);
			}
		});
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		Log.d("SON", "MainActivity - onCreate()");
	}
}
