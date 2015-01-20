/*
 ref source) http://www.javaadvent.com/2012/12/achartengine-charting-library-for.html
 ref) http://www.programkr.com/blog/MQDN0ADMwYT3.html
 ref) http://www.achartengine.org/content/javadoc/index.html
 display) width 480, 720, 1080
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
import son.funkydj3.gggg.activities.MainActivity;
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
	public GraphicalView mChart; // * Study about "GraphicalView"
	private XYSeries mCurrentSeries; // * series : set of numbers
	private XYMultipleSeriesDataset mDataset = new XYMultipleSeriesDataset();
	private SimpleSeriesRenderer mCurrentRenderer;
	private XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
	
	
	private void initChart(){
		mCurrentSeries = new XYSeries("WON");
		mDataset.addSeries(mCurrentSeries);
		
		mCurrentRenderer = new XYSeriesRenderer();
		mCurrentRenderer.setColor(Color.rgb(18, 105, 120));
		//mCurrentRenderer.setColor(Class_Color.GREEN()); // * GREEN
		mCurrentRenderer.setDisplayChartValues(true);
		mCurrentRenderer.setChartValuesTextAlign(Align.CENTER);
		if(widthPixels <= 720){
			mCurrentRenderer.setChartValuesTextSize(15);
		}else if(widthPixels == 1080){
			mCurrentRenderer.setChartValuesTextSize(30);
		}
		
	    //mRenderer.setClickEnabled(false);

		// double[] zoomlimits = new double[] {0,20,0,40}; // {zoomMinimumX, zoomMaximumX, zoomMinimumY, zoomMaximumY}
		// mRenderer.setZoomLimits(zoomlimits);
		mRenderer.setChartTitle("Year Electric Charge");
		if(widthPixels <= 720){
			mRenderer.setChartTitleTextSize(40);
		}else if(widthPixels == 1080){
			mRenderer.setChartTitleTextSize(80);
		}
		mRenderer.setLabelsColor(Color.BLACK); // * "title + label"'s color
		if(widthPixels <= 720){
			mRenderer.setLabelsTextSize(18);
		}else if(widthPixels == 1080){
			mRenderer.setLabelsTextSize(36);
		}
		
		int[] margins = new int[] {0,0,0,0}; // {top, left, bottom, right}
		if(widthPixels <= 720){
			margins = new int[] {75,45,0,0};
		}else if(widthPixels == 1080){ // 1080*1920
			margins = new int[] {150,90,0,0};
		}
		mRenderer.setMargins(margins);
		mRenderer.setMarginsColor(Color.WHITE);
		
		mRenderer.setApplyBackgroundColor(true);
		//mRenderer.setBackgroundColor(Color.rgb(255, 228, 0));
		
		
		mRenderer.setPanEnabled(false, true); // * fix graph
		double[] panLimits = new double[] {0,0,0,50000};
		mRenderer.setPanLimits(panLimits);
		mRenderer.setZoomEnabled(false, false); // * enable zoom
		double[] range = new double[] {0,12,0,40000};
		mRenderer.setInitialRange(range);
		mRenderer.setYLabelsAlign(Align.RIGHT);
		mRenderer.setXTitle("Months");
		mRenderer.setYTitle("WON");
		if(widthPixels <= 720){ // 720*1080
			mRenderer.setAxisTitleTextSize(16);
		}else if(widthPixels == 1080){ // 1080*1920
			mRenderer.setAxisTitleTextSize(32);
		}

		
		mRenderer.setShowGridX(true);
		mRenderer.setGridColor(Color.rgb(93, 93, 93));
		mRenderer.setXLabelsColor(Class_Color.BLACK());
		mRenderer.setXLabels(24); // sets the number of integer labels to appear
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
		
		
		mRenderer.setShowGridY(true);
		mRenderer.setYLabels(5);
		mRenderer.setYLabelsColor(0, Class_Color.BLACK());
		mRenderer.setYLabelsAngle(300);
		mRenderer.addYTextLabel(2500, "2,500");
		mRenderer.addYTextLabel(5000, "5,000");
		mRenderer.addYTextLabel(7500, "7,500");
		mRenderer.addYTextLabel(10000, "10,000");
		mRenderer.addYTextLabel(12500, "12,500");
		mRenderer.addYTextLabel(15000, "15,000");
		mRenderer.addYTextLabel(17500, "17,500");
		mRenderer.addYTextLabel(20000, "20,000");
		mRenderer.addYTextLabel(22500, "22,500");
		mRenderer.addYTextLabel(25000, "25,000");
		mRenderer.addYTextLabel(27500, "27,500");
		mRenderer.addYTextLabel(30000, "30,000");
		mRenderer.addYTextLabel(32500, "32,500");
		mRenderer.addYTextLabel(35000, "35,000");
		mRenderer.addYTextLabel(37500, "37,500");
		mRenderer.addYTextLabel(40000, "40,000");
		mRenderer.addYTextLabel(42500, "42,500");
		mRenderer.addYTextLabel(45000, "45,000");
		mRenderer.addYTextLabel(47500, "47,500");
		mRenderer.addYTextLabel(50000, "50,000");
		mRenderer.addYTextLabel(52500, "52,500");
		
		mRenderer.setBarSpacing(0.7);
		mRenderer.setXAxisMin(0.5);
		mRenderer.setXAxisMax(12.8);
		mRenderer.setYAxisMin(0);
		mRenderer.setYAxisMax(20000);
		
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
	
	private int widthPixels;
	private int heightPixels;
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
	
	
	private Thread1 t1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chart1);
		t1 = new Thread1(mHandler);
		t1.start();
	}
	private Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			if(Constant.COUNT >= 7500){
				//mCurrentRenderer.setColor(Color.rgb(255, 0, 0)); // * RED
				mCurrentRenderer.setColor(Class_Color.RED()); // * RED
			}
			// *error* mCurrentSeries.add(1,COUNT); 이렇게 하나만 해도, 나머지 값이 다 COUNT로 바뀐다
			mCurrentSeries.add(1,Constant.COUNT);
			mCurrentSeries.add(2,Constant.COUNT+500);
			mCurrentSeries.add(3,Constant.COUNT+200);
			mCurrentSeries.add(4,Constant.COUNT+1300);
			mCurrentSeries.add(5,Constant.COUNT+400);
			mCurrentSeries.add(6,Constant.COUNT);
			mCurrentSeries.add(7,Constant.COUNT+2600);
			mCurrentSeries.add(8,Constant.COUNT+1700);
			mCurrentSeries.add(9,Constant.COUNT+800);
			mCurrentSeries.add(10,Constant.COUNT+100);
			mCurrentSeries.add(11,Constant.COUNT+3000);
			mCurrentSeries.add(12,Constant.COUNT+1100);
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
			//mChart.repaint();
		}
	}
}
