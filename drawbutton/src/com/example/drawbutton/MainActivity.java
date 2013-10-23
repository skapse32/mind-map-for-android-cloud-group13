package com.example.drawbutton;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.Display;
import android.view.Menu;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

	RelativeLayout relLay;
	TriButton m_button;
	Canvas canvas;
	Paint paint = new Paint();
	Bitmap bitmap;

	int downx, downy, upx, upy;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		relLay = new RelativeLayout(this);
		paint.setColor(Color.BLUE);
		
		createButton(0, 0);
		setContentView(relLay);
	}

	public void createButton(int x, int y)
	{
		m_button = new TriButton(this);
		relLay.addView(m_button, m_button.GetRelativeParam(x, y, 40, 80));
		
		
	}
	
	
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		
		if(event.getAction()==MotionEvent.ACTION_DOWN)
		{
			downx  = (int)event.getX();
			downy = (int)event.getY();
			createButton(downx, downy);
		}
		
		return true;
		//return super.onTouchEvent(event);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
