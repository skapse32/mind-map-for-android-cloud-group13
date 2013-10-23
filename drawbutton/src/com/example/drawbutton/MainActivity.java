package com.example.drawbutton;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity {
	Canvas canvas;
	RelativeLayout relLay;
	TriButton m_button;
	int iD = 1;
	int x = 100, y = 100;
	Paint paint;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		relLay = new RelativeLayout(this);
		createTestButton(200, 400);
		setContentView(relLay);
		canvas = new Canvas();
		paint = new Paint();
		paint.setColor(Color.RED);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			x = (int) event.getX();
			y = (int) event.getY();
			createTestButton(x, y);
			Log.d("Draw", "Chuan bi draw");
			canvas.drawLine(100, 200, x - 100, y - 200, paint);
			Log.d("Draw", "Da draw");
		}

		return true;
	}

	private void createTestButton(int x, int y) {
		// TODO Auto-generated method stub
		m_button = new TriButton(this);
		m_button.setId(iD);
		iD++;
		// Toast.makeText(MainActivity.this, "x=" + x, 1).show();

		relLay.addView(m_button,
				m_button.GetRelativeParam(x - 100, y - 200, 100, 200));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
