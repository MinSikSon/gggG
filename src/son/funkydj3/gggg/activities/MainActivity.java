package son.funkydj3.gggg.activities;

import son.funkydj3.achartengine.Chart1;
import son.funkydj3.gggg.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Intent i = new Intent(MainActivity.this, Chart1.class);
		startActivity(i);
	}
}
