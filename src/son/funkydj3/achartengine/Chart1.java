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
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import son.funkydj3.gggg.R;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.os.Bundle;
import android.widget.LinearLayout;

public class Chart1 extends Activity {
	private GraphicalView mChart; // * Study about "GraphicalView"
	private XYSeries mCurrentSeries; // * series : set of numbers
	private XYMultipleSeriesDataset mDataset = new XYMultipleSeriesDataset();
	private SimpleSeriesRenderer mCurrentRenderer;
	private XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
	
	private void initChart(){
		mCurrentSeries = new XYSeries("kWh");
		mDataset.addSeries(mCurrentSeries);
		
		mCurrentRenderer = new XYSeriesRenderer();
		mCurrentRenderer.setColor(Color.RED);
		
		
		
	    //mRenderer.setClickEnabled(false);

		// double[] zoomlimits = new double[] {0,20,0,40}; // {zoomMinimumX, zoomMaximumX, zoomMinimumY, zoomMaximumY}
		// mRenderer.setZoomLimits(zoomlimits);
		mRenderer.setChartTitle("Graph of Power Rates");

		int[] margins = new int[] {50,30,-100,0}; // {top, left, bottom, right}
		mRenderer.setMargins(margins);
		mRenderer.setChartTitleTextSize(40);
		mRenderer.setAxisTitleTextSize(15);
		//mRenderer.setBackgroundColor(Color.BLUE);
		
		mRenderer.setZoomEnabled(false, false); // * enable zoom
		double[] range = new double[] {0,12,0,500};
		mRenderer.setInitialRange(range);
		mRenderer.setYLabelsAlign(Align.RIGHT);
		mRenderer.setXTitle("Months");
		mRenderer.setYTitle("kWh");
		mRenderer.setShowGrid(true);
		mRenderer.setGridColor(Color.GRAY);
		mRenderer.setXLabels(0); // sets the number of integer labels to appear
		mRenderer.addXTextLabel(0, "0");
		mRenderer.addXTextLabel(1, "1");
		mRenderer.addXTextLabel(2, "2");
		mRenderer.addXTextLabel(3, "3");
		mRenderer.addXTextLabel(4, "4");
		mRenderer.addXTextLabel(5, "5");
		mRenderer.addXTextLabel(6, "6");
		mRenderer.addXTextLabel(7, "7");
		mRenderer.addXTextLabel(8, "8");
		mRenderer.addXTextLabel(9, "9");
		mRenderer.addXTextLabel(10, "10");
		mRenderer.addXTextLabel(11, "11");
		mRenderer.addXTextLabel(12, "12");
		mRenderer.setBarSpacing(0.8);
		mRenderer.setXAxisMin(0.5);
		mRenderer.setXAxisMax(12.5);
		mRenderer.setYAxisMin(0);
		mRenderer.setYAxisMax(500);
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
			layout.addView(mChart);
		} else{
			mChart.repaint();
		}
	}
}
