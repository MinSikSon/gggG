package son.funkydj3.thread;

import son.funkydj3.achartengine.Chart1;
import android.os.Handler;
import android.os.Message;

public class Thread1 extends Thread {
	Handler mHandler;

	public Thread1(Handler mHandler) {
		this.mHandler = mHandler;
	}

	@Override
	public void run() {
		while (true) {
			Message msg = Message.obtain();
			msg.arg1 = 1;
			mHandler.sendMessage(msg);
			Chart1.COUNT++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				;
			}
		}
	}
}
