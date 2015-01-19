// ref source) http://www.javaadvent.com/2012/12/achartengine-charting-library-for.html
// ref) http://www.programkr.com/blog/MQDN0ADMwYT3.html
package son.funkydj3.achartengine;

import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import son.funkydj3.gggg.R;
import android.app.Activity;
import android.os.Bundle;

public class Chart1 extends Activity {
	private XYMultipleSeriesDataset mDataset = new XYMultipleSeriesDataset();
	private XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
	private XYSeries mCurrentSeries;
	private XYSeriesRenderer mCurrentRenderer;
	
	private void initChart(){
		
	}
	
	private void addSampleData(){
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chart1);
		
	}
	
	@Override
	protected void onResume(){
		
	}
}
