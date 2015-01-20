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
import son.funkydj3.thread.Thread3;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;

public class Chart3 extends Activity {

	public GraphicalView mChart3_1; // * Study about "GraphicalView"
	private XYSeries mCurrentSeries3_1; // * series : set of numbers
	private XYMultipleSeriesDataset mDataset3_1 = new XYMultipleSeriesDataset();
	private SimpleSeriesRenderer mCurrentRenderer3_1;
	private XYMultipleSeriesRenderer mRenderer3_1 = new XYMultipleSeriesRenderer();
	
	public GraphicalView mChart3_2; // * Study about "GraphicalView"
	private XYSeries mCurrentSeries3_2; // * series : set of numbers
	private XYMultipleSeriesDataset mDataset3_2 = new XYMultipleSeriesDataset();
	private SimpleSeriesRenderer mCurrentRenderer3_2;
	private XYMultipleSeriesRenderer mRenderer3_2 = new XYMultipleSeriesRenderer();
	
	private void initChart3_1(){
		mCurrentSeries3_1 = new XYSeries("Wh");
		mDataset3_1.addSeries(mCurrentSeries3_1);
		
		mCurrentRenderer3_1 = new XYSeriesRenderer();
		mCurrentRenderer3_1.setColor(Color.rgb(18, 105, 120));
		//mCurrentRenderer.setColor(Class_Color.GREEN()); // * GREEN
		mCurrentRenderer3_1.setDisplayChartValues(true);
		mCurrentRenderer3_1.setChartValuesTextAlign(Align.RIGHT);
		if(widthPixels3 <= 720){
			mCurrentRenderer3_1.setChartValuesTextSize(20);
		}else if(widthPixels3 == 1080){
			mCurrentRenderer3_1.setChartValuesTextSize(40);
		}
		
	    //mRenderer.setClickEnabled(false);

		// double[] zoomlimits = new double[] {0,20,0,40}; // {zoomMinimumX, zoomMaximumX, zoomMinimumY, zoomMaximumY}
		// mRenderer.setZoomLimits(zoomlimits);
		mRenderer3_1.setChartTitle("Day Electric Charge - sunrise");
		if(widthPixels3 <= 720){
			mRenderer3_1.setChartTitleTextSize(20);
		}else if(widthPixels3 == 1080){
			mRenderer3_1.setChartTitleTextSize(40);
		}
		mRenderer3_1.setLabelsColor(Color.BLACK); // * "title + label"'s color
		if(widthPixels3 <= 720){
			mRenderer3_1.setLabelsTextSize(20);
		}else if(widthPixels3 == 1080){
			mRenderer3_1.setLabelsTextSize(40);
		}
		
		int[] margins3 = new int[] {0,0,0,0}; // {top, left, bottom, right}
		if(widthPixels3 <= 720){
			margins3 = new int[] {50,50,10,0};
		}else if(widthPixels3 == 1080){ // 1080*1920
			margins3 = new int[] {100,100,20,0};
		}
		mRenderer3_1.setMargins(margins3);
		mRenderer3_1.setMarginsColor(Color.WHITE);
		
		mRenderer3_1.setApplyBackgroundColor(true);
		//mRenderer.setBackgroundColor(Color.rgb(255, 228, 0));
		
		
		mRenderer3_1.setPanEnabled(false, true); // * fix graph
		double[] panLimits3_1 = new double[] {0.5,12.5,0,300};
		mRenderer3_1.setPanLimits(panLimits3_1);
		mRenderer3_1.setZoomEnabled(false, false); // * enable zoom
		double[] range3_1 = new double[] {0.5,12.5,0,300};
		mRenderer3_1.setInitialRange(range3_1);
		mRenderer3_1.setYLabelsAlign(Align.RIGHT);
		mRenderer3_1.setXTitle("Hours");
		mRenderer3_1.setYTitle("Wh");
		if(widthPixels3 <= 720){ // 720*1080
			mRenderer3_1.setAxisTitleTextSize(18);
		}else if(widthPixels3 == 1080){ // 1080*1920
			mRenderer3_1.setAxisTitleTextSize(36);
		}

		
		mRenderer3_1.setShowGridX(true);
		mRenderer3_1.setGridColor(Color.rgb(93, 93, 93));
		mRenderer3_1.setXLabelsColor(Class_Color.BLACK());
		mRenderer3_1.setXLabelsAngle(330);
		mRenderer3_1.setXLabels(12); // sets the number of integer labels to appear
		for(int i = 1 ; i < 13 ; i++){
			mRenderer3_1.addXTextLabel(i, Integer.toString(i));
		}
		
		
		mRenderer3_1.setShowGridY(true);
		mRenderer3_1.setYLabels(5);
		mRenderer3_1.setYLabelsColor(0, Class_Color.BLACK());
		mRenderer3_1.setYLabelsAngle(0);
		for(int i = 0 ; i < 30 ; i++)
			mRenderer3_1.addYTextLabel(i*10, Integer.toString(i*10));
		
		
		mRenderer3_1.setBarSpacing(0.6);
		mRenderer3_1.setXAxisMin(0.5);
		mRenderer3_1.setXAxisMax(12.5);
		mRenderer3_1.setYAxisMin(0);
		mRenderer3_1.setYAxisMax(100);
		
		//mRenderer2.setPointSize(1.0f);
	    mRenderer3_1.addSeriesRenderer(mCurrentRenderer3_1);
	}
	
	private void initChart3_2(){
		mCurrentSeries3_2 = new XYSeries("Wh");
		mDataset3_2.addSeries(mCurrentSeries3_2);
		
		mCurrentRenderer3_2 = new XYSeriesRenderer();
		mCurrentRenderer3_2.setColor(Color.rgb(18, 105, 120));
		//mCurrentRenderer.setColor(Class_Color.GREEN()); // * GREEN
		mCurrentRenderer3_2.setDisplayChartValues(true);
		mCurrentRenderer3_2.setChartValuesTextAlign(Align.CENTER);
		if(widthPixels3 <= 720){
			mCurrentRenderer3_2.setChartValuesTextSize(20);
		}else if(widthPixels3 == 1080){
			mCurrentRenderer3_2.setChartValuesTextSize(40);
		}
		
	    //mRenderer.setClickEnabled(false);

		// double[] zoomlimits = new double[] {0,20,0,40}; // {zoomMinimumX, zoomMaximumX, zoomMinimumY, zoomMaximumY}
		// mRenderer.setZoomLimits(zoomlimits);
		mRenderer3_2.setChartTitle("Day Electric Charge - sunset");
		if(widthPixels3 <= 720){
			mRenderer3_2.setChartTitleTextSize(20);
		}else if(widthPixels3 == 1080){
			mRenderer3_2.setChartTitleTextSize(40);
		}
		mRenderer3_2.setLabelsColor(Color.BLACK); // * "title + label"'s color
		if(widthPixels3 <= 720){
			mRenderer3_2.setLabelsTextSize(20);
		}else if(widthPixels3 == 1080){
			mRenderer3_2.setLabelsTextSize(40);
		}
		
		int[] margins3 = new int[] {0,0,0,0}; // {top, left, bottom, right}
		if(widthPixels3 <= 720){
			margins3 = new int[] {50,50,10,0};
		}else if(widthPixels3 == 1080){ // 1080*1920
			margins3 = new int[] {100,100,20,0};
		}
		mRenderer3_2.setMargins(margins3);
		mRenderer3_2.setMarginsColor(Color.WHITE);
		
		mRenderer3_2.setApplyBackgroundColor(true);
		//mRenderer.setBackgroundColor(Color.rgb(255, 228, 0));
		
		
		mRenderer3_2.setPanEnabled(false, true); // * fix graph
		double[] panLimits3_2 = new double[] {12.5,24.5,0,300};
		mRenderer3_2.setPanLimits(panLimits3_2);
		mRenderer3_2.setZoomEnabled(false, false); // * enable zoom
		double[] range3_2 = new double[] {12.5,24.5,0,300};
		mRenderer3_2.setInitialRange(range3_2);
		mRenderer3_2.setYLabelsAlign(Align.RIGHT);
		mRenderer3_2.setXTitle("Hours");
		mRenderer3_2.setYTitle("Wh");
		if(widthPixels3 <= 720){ // 720*1080
			mRenderer3_2.setAxisTitleTextSize(18);
		}else if(widthPixels3 == 1080){ // 1080*1920
			mRenderer3_2.setAxisTitleTextSize(36);
		}

		
		mRenderer3_2.setShowGridX(true);
		mRenderer3_2.setGridColor(Color.rgb(93, 93, 93));
		mRenderer3_2.setXLabelsColor(Class_Color.BLACK());
		mRenderer3_2.setXLabelsAngle(330);
		mRenderer3_2.setXLabels(12); // sets the number of integer labels to appear
		for(int i = 1 ; i < 13 ; i++){
			mRenderer3_2.addXTextLabel(i+12, Integer.toString(i+12));
		}
		
		
		mRenderer3_2.setShowGridY(true);
		mRenderer3_2.setYLabels(5);
		mRenderer3_2.setYLabelsColor(0, Class_Color.BLACK());
		mRenderer3_2.setYLabelsAngle(0);
		for(int i = 0 ; i < 30 ; i++)
			mRenderer3_2.addYTextLabel(i*10, Integer.toString(i*10));
		
		
		mRenderer3_2.setBarSpacing(0.6);
		mRenderer3_2.setXAxisMin(12.5);
		mRenderer3_2.setXAxisMax(24.5);
		mRenderer3_2.setYAxisMin(0);
		mRenderer3_2.setYAxisMax(100);
		
		//mRenderer2.setPointSize(1.0f);
	    mRenderer3_2.addSeriesRenderer(mCurrentRenderer3_2);
	}
	
	/*private void addSampleData3(){
		mCurrentSeries3_1.add(1,30);
		mCurrentSeries3_1.add(2,60);
		mCurrentSeries3_1.add(3,30);
		mCurrentSeries3_1.add(4,50);
		mCurrentSeries3_1.add(5,30);
		mCurrentSeries3_1.add(6,30);
		mCurrentSeries3_1.add(7,40);
		mCurrentSeries3_1.add(8,30);
		mCurrentSeries3_1.add(9,30);
		mCurrentSeries3_1.add(10,70);
		mCurrentSeries3_1.add(11,10);
		mCurrentSeries3_1.add(12,80);
	}*/
	
	private int widthPixels3;
	private int heightPixels3;
	private void InfoDisplay3(){
		int screenLayout = getResources().getConfiguration().screenLayout;
		// Get the metrics
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		widthPixels3 = metrics.widthPixels;
		heightPixels3 = metrics.heightPixels;
		int densityDpi = metrics.densityDpi;
		float density = metrics.density;
		float scaledDensity = metrics.scaledDensity;
		float xdpi = metrics.xdpi;
		float ydpi = metrics.ydpi;
		//Log.d("SON", "Screen W x H pixels: " + widthPixels2 + " x " + heightPixels2);
		//Log.d("SON", "Screen X x Y dpi: " + xdpi + " x " + ydpi);
		//Log.d("SON", "density = " + density + "  scaledDensity = " + scaledDensity + "  densityDpi = " + densityDpi);
	}
	
	
	private Thread3 t3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chart3);
		t3 = new Thread3(mHandler3);
		t3.start();
	}
	private Handler mHandler3 = new Handler() {
		public void handleMessage(Message msg) {
			if(Constant.COUNT3 >= 30){
				//mCurrentRenderer.setColor(Color.rgb(255, 0, 0)); // * RED
				mCurrentRenderer3_1.setColor(Class_Color.RED()); // * RED
				mCurrentRenderer3_2.setColor(Class_Color.RED()); // * RED
			}
			// *error* mCurrentSeries.add(1,COUNT); �씠�젃寃� �븯�굹留� �빐�룄, �굹癒몄� 媛믪씠 �떎 COUNT濡� 諛붾�먮떎
			for(int i = 1 ; i < 13 ; i++){
				mCurrentSeries3_1.add(i,Constant.COUNT3+i);
				mCurrentSeries3_2.add(i+12,Constant.COUNT3+i);
			}
			if(mChart3_1 != null) mChart3_1.repaint();
			if(mChart3_2 != null) mChart3_2.repaint();
		}
	};
	
	@Override
	protected void onResume(){
		
		// * Study about "onResume()"
		super.onResume();
		LinearLayout layout3 = (LinearLayout)findViewById(R.id.chart3_1);
		LinearLayout layout3_2 = (LinearLayout)findViewById(R.id.chart3_2);
		if(mChart3_1 == null){
			InfoDisplay3();
			initChart3_1();
			//addSampleData3();
			// * Study about "ChartFactory"
			mChart3_1 = ChartFactory.getBarChartView(this, mDataset3_1, mRenderer3_1, Type.DEFAULT);
			layout3.addView(mChart3_1);
			
		} else{
			//mChart3_1.repaint();
		}
		if(mChart3_2 == null){
			InfoDisplay3();
			initChart3_2();
			//addSampleData3();
			// * Study about "ChartFactory"
			mChart3_2 = ChartFactory.getBarChartView(this, mDataset3_2, mRenderer3_2, Type.DEFAULT);
			layout3_2.addView(mChart3_2);
			
		} else{
			//mChart3_2.repaint();
		}
	}
}
