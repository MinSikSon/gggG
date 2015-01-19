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
import son.funkydj3.thread.Thread1;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.LinearLayout;

public class Chart1 extends Activity {
	private GraphicalView mChart; // * Study about "GraphicalView"
	private XYSeries mCurrentSeries; // * series : set of numbers
	private XYMultipleSeriesDataset mDataset = new XYMultipleSeriesDataset();
	private SimpleSeriesRenderer mCurrentRenderer;
	private XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
	
	public static int COUNT = 0;
	
	private void initChart(){
		mCurrentSeries = new XYSeries("kWh");
		mDataset.addSeries(mCurrentSeries);
		
		mCurrentRenderer = new XYSeriesRenderer();
		mCurrentRenderer.setColor(Color.rgb(146, 208, 80)); // * GREEN
		mCurrentRenderer.setDisplayChartValues(true);
		mCurrentRenderer.setChartValuesTextAlign(Align.RIGHT);
		if(widthPixels <= 720){
			mCurrentRenderer.setChartValuesTextSize(15);
		}else if(widthPixels == 1080){
			mCurrentRenderer.setChartValuesTextSize(30);
		}
		
	    //mRenderer.setClickEnabled(false);

		// double[] zoomlimits = new double[] {0,20,0,40}; // {zoomMinimumX, zoomMaximumX, zoomMinimumY, zoomMaximumY}
		// mRenderer.setZoomLimits(zoomlimits);
		mRenderer.setChartTitle("Graph of Power Rates");
		if(widthPixels <= 720){
			mRenderer.setChartTitleTextSize(40);
		}else if(widthPixels == 1080){
			mRenderer.setChartTitleTextSize(80);
		}
		mRenderer.setLabelsColor(Color.YELLOW); // * "title + label"'s color
		if(widthPixels <= 720){
			mRenderer.setLabelsTextSize(18);
		}else if(widthPixels == 1080){
			mRenderer.setLabelsTextSize(36);
		}
		
		int[] margins = new int[] {0,0,0,0}; // {top, left, bottom, right}
		if(widthPixels <= 720){
			margins = new int[] {50,30,0,0};
		}else if(widthPixels == 1080){ // 1080*1920
			margins = new int[] {100,60,0,0};
		}
		mRenderer.setMargins(margins);
		mRenderer.setMarginsColor(Color.BLACK);
		
		mRenderer.setApplyBackgroundColor(true);
		//mRenderer.setBackgroundColor(Color.WHITE);
		
		//mRenderer.setShowGrid(true);
		mRenderer.setShowGridX(true);
		mRenderer.setGridColor(Color.GRAY);
		
		mRenderer.setPanEnabled(false, true); // * fix graph
		double[] panLimits = new double[] {0,0,0,450};
		mRenderer.setPanLimits(panLimits);
		mRenderer.setZoomEnabled(false, false); // * enable zoom
		double[] range = new double[] {0,12,0,200};
		mRenderer.setInitialRange(range);
		mRenderer.setYLabelsAlign(Align.RIGHT);
		mRenderer.setXTitle("Months");
		mRenderer.setYTitle("kWh");
		if(widthPixels <= 720){ // 720*1080
			mRenderer.setAxisTitleTextSize(16);
		}else if(widthPixels == 1080){ // 1080*1920
			mRenderer.setAxisTitleTextSize(32);
		}
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
		
		mRenderer.setXLabels(0);
		mRenderer.addYTextLabel(50, "50");
		mRenderer.addYTextLabel(100, "100");
		mRenderer.addYTextLabel(150, "150");
		mRenderer.addYTextLabel(200, "200");
		mRenderer.addYTextLabel(250, "250");
		mRenderer.addYTextLabel(300, "300");
		mRenderer.addYTextLabel(350, "350");
		mRenderer.addYTextLabel(400, "400");
		mRenderer.addYTextLabel(450, "450");
		mRenderer.addYTextLabel(500, "500");
		
		mRenderer.setBarSpacing(0.8);
		mRenderer.setXAxisMin(0.5);
		mRenderer.setXAxisMax(12.5);
		mRenderer.setYAxisMin(0);
		mRenderer.setYAxisMax(300);
		
		//mRenderer.setPointSize(1.0f);
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
	
	int widthPixels;
	int heightPixels;
	private void InfoDisplay(){
		int screenLayout = getResources().getConfiguration().screenLayout;
		// Get the metrics
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		widthPixels = metrics.widthPixels;
		heightPixels = metrics.heightPixels;
		int densityDpi = metrics.densityDpi;
		float density = metrics.density;
		float scaledDensity = metrics.scaledDensity;
		float xdpi = metrics.xdpi;
		float ydpi = metrics.ydpi;
		Log.d("SON", "Screen W x H pixels: " + widthPixels + " x " + heightPixels);
		Log.d("SON", "Screen X x Y dpi: " + xdpi + " x " + ydpi);
		Log.d("SON", "density = " + density + "  scaledDensity = " + scaledDensity + "  densityDpi = " + densityDpi);
	}
	
	
	Thread1 t1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chart1);
		t1 = new Thread1(mHandler);
		t1.start();
	}
	Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			if(COUNT >= 150){
				mCurrentRenderer.setColor(Color.rgb(255, 0, 0)); // * RED
			}
			// *error* mCurrentSeries.add(1,COUNT); 이렇게 하나만 해도, 나머지 값이 다 COUNT로 바뀐다
			mCurrentSeries.add(1,COUNT);
			mCurrentSeries.add(2,COUNT+1);
			mCurrentSeries.add(3,COUNT+2);
			mCurrentSeries.add(4,COUNT+3);
			mCurrentSeries.add(5,COUNT+4);
			mCurrentSeries.add(6,COUNT+5);
			mCurrentSeries.add(7,COUNT+6);
			mCurrentSeries.add(8,COUNT+7);
			mCurrentSeries.add(9,COUNT+8);
			mCurrentSeries.add(10,COUNT+9);
			mCurrentSeries.add(11,COUNT+10);
			mCurrentSeries.add(12,COUNT+11);
			if(mChart != null) mChart.repaint();
		}
	};
	
	@Override
	protected void onResume(){
		
		// * Study about "onResume()"
		super.onResume();
		LinearLayout layout = (LinearLayout)findViewById(R.id.chart1);
		if(mChart == null){
			InfoDisplay();
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
