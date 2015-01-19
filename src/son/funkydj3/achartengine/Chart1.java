/*
 ref source) http://www.javaadvent.com/2012/12/achartengine-charting-library-for.html
 ref) http://www.programkr.com/blog/MQDN0ADMwYT3.html
 ref) http://www.achartengine.org/content/javadoc/index.html
*/

package son.funkydj3.achartengine;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.BarChart.Type;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import son.funkydj3.gggg.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class Chart1 extends Activity {
	private GraphicalView mChart; // * Study about "GraphicalView"
	private XYMultipleSeriesDataset mDataset = new XYMultipleSeriesDataset();
	private XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
	private XYSeries mCurrentSeries; // * series : 수열
	private XYSeriesRenderer mCurrentRenderer;
	
	private void initChart(){
		mCurrentSeries = new XYSeries("Power Rates");
		mDataset.addSeries(mCurrentSeries);
		
		mCurrentRenderer = new XYSeriesRenderer();
		mRenderer.addSeriesRenderer(mCurrentRenderer);
	}
	
	private void addSampleData(){
		mCurrentSeries.add(1,30);
		mCurrentSeries.add(2,60);
		mCurrentSeries.add(3,30);
		mCurrentSeries.add(4,50);
		mCurrentSeries.add(5,30);
		mCurrentSeries.add(6,30);
		mCurrentSeries.add(7,40);
		mCurrentSeries.add(8,30);
		mCurrentSeries.add(9,30);
		mCurrentSeries.add(10,70);
		mCurrentSeries.add(11,10);
		mCurrentSeries.add(12,80);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chart1);
		
	}
	
	@Override
	protected void onResume(){
		// * Study about "onResume()"
		super.onResume();
		LinearLayout layout = (LinearLayout)findViewById(R.id.chart1);
		if(mChart == null){
			initChart();
			addSampleData();
			// * Study about "ChartFactory"
			mChart = ChartFactory.getBarChartView(this, mDataset, mRenderer, Type.DEFAULT);
		}
	}
}
