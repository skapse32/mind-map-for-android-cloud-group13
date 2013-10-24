package com.example.mindmapcloud_tlcn;

import java.util.Random;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends Activity implements OnTouchListener,
		OnClickListener {

	LinearLayout mLinearLayout;
	RelativeLayout relLay;
	int iD = 1;
	float x, y;
	ImageView imageView;
	Bitmap bitmap;
	Canvas canvas;
	Paint paintButton;
	Paint paintLine;
	String[] buttonName = new String[] { "1", "2" };
	ImageButton button;
	ImageButton button1;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Create a LinearLayout in which to add the ImageView
		setContentView(R.layout.activity_main);
		relLay = (RelativeLayout) findViewById(R.id.relative);
		imageView = (ImageView) this.findViewById(R.id.imageView1);
		Display currentDisplay = getWindowManager().getDefaultDisplay();
		float dw = currentDisplay.getWidth();
		float dh = currentDisplay.getHeight();

		bitmap = Bitmap.createBitmap((int) dw, (int) dh,
				Bitmap.Config.ARGB_8888);
		canvas = new Canvas(bitmap);

		paintButton = new Paint();
		paintButton.setColor(Color.GREEN);

		paintLine = new Paint();
		paintLine.setColor(Color.RED);

		button = new ImageButton(this);
		button.setOnClickListener(this);

		imageView.setImageBitmap(bitmap);
		canvas.drawRoundRect(new RectF(100, 200, 100 + 200, 200 + 100), 70, 70,
				paintButton);

		addButton(button);
		imageView.setOnTouchListener(this);
	}

	private void random() {
		// TODO Auto-generated method stub
		Random rd = new Random();
		x = rd.nextInt((1000 - 2 + 1) + 2);
		y = rd.nextInt((1000 - 2 + 1) + 2);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		button1 = new ImageButton(getApplicationContext());
		addButton(button1);
		button1.setOnClickListener(this);
	}

	private void addButton(ImageButton button) {
		// TODO Auto-generated method stub
		random();
		button.setBackgroundResource(R.drawable.ic_launcher);
		button.setX(x);
		button.setY(y);
		button.setId(iD);
		iD++;

		relLay.addView(button, 200, 100);
	}

	private View addButtonNext(ImageButton button, float x, float y) {

		return button;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		int action = event.getAction();
		switch (action) {
		case MotionEvent.ACTION_DOWN:
			x = event.getX();
			y = event.getY();

			canvas.drawRoundRect(new RectF(x, y, x + 200, y + 100), 70, 70,
					paintButton);
			canvas.drawLine(100 + 100, 200 + 50, x + 100, y + 50, paintLine);
			imageView.invalidate();
			break;
		case MotionEvent.ACTION_MOVE:
			break;
		case MotionEvent.ACTION_UP:
			break;
		case MotionEvent.ACTION_CANCEL:
			break;
		default:
			break;
		}
		return true;
	}

}