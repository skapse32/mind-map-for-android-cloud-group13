package com.example.draw_demo_surface;

import java.util.Random;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Display;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.DragShadowBuilder;
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener,
		OnLongClickListener, OnDragListener {
	private android.widget.RelativeLayout.LayoutParams layoutParams;

	RelativeLayout relLay;
	int iD = 0, btnId;
	int status = 0;
	float x, y;
	float x_cord, y_cord;
	ImageView imageView;
	Bitmap bitmap;
	Canvas canvas;
	Paint paintButton;
	Paint paintLine;
	String[] buttonName = new String[] { "1", "2" };
	ImageButton button;
	ImageButton[] buttons = new ImageButton[100];

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

		paintLine = new Paint();
		paintLine.setColor(Color.RED);

		button = new ImageButton(this);
		button.setId(0);
		button.setOnClickListener(this);
		// button.setOnTouchListener(this);

		imageView.setImageBitmap(bitmap);
		addButton2(button, 200, 200);
		// imageView.setOnTouchListener(this);
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
		button = new ImageButton(getApplicationContext());
		addButton(button);
		button.setOnClickListener(this);
		button.setOnLongClickListener(this);
		button.setOnDragListener(this);
	}

	private void addButton(ImageButton button) {
		// TODO Auto-generated method stub
		random();
		button.setBackgroundResource(R.drawable.ic_launcher);
		button.setX(x);
		button.setY(y);
		button.setId(iD);
		iD++;
		// Toast.makeText(getApplicationContext(), "Id=" + button.getId(),
		// 2).show();
		relLay.addView(button, 200, 100);
		buttons[0] = button;
	}

	private void addButton2(ImageButton button, float x, float y) {
		// TODO Auto-generated method stub
		button.setBackgroundResource(R.drawable.ic_launcher);
		button.setX(x);
		button.setY(y);
		button.setId(iD);
		iD++;

		relLay.addView(button, 200, 100);
	}

	@Override
	public boolean onLongClick(View v) {
		// TODO Auto-generated method stub
		ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
		String[] clipDescription = { ClipDescription.MIMETYPE_TEXT_PLAIN };
		ClipData dragData = new ClipData((CharSequence) v.getTag(),
				clipDescription, item);
		DragShadowBuilder myShadow = new View.DragShadowBuilder(v);

		v.startDrag(dragData, myShadow, null, 0);
		v.setVisibility(View.INVISIBLE);
		return true;
	}

	@Override
	public boolean onDrag(View v, DragEvent event) {
		// TODO Auto-generated method stub
		int action = event.getAction();
		switch (event.getAction()) {
		case DragEvent.ACTION_DRAG_STARTED:
			// Do nothing
			layoutParams = (RelativeLayout.LayoutParams) v.getLayoutParams();
			Toast.makeText(getApplicationContext(),
					"ACTION_DRAG_STARTED" + v.getId(), 2).show();
			break;
		case DragEvent.ACTION_DRAG_ENTERED:
			x_cord = event.getX();
			y_cord = event.getY();
			Toast.makeText(getApplicationContext(), "ACTION_DRAG_ENTERED", 2)
					.show();
			break;
		case DragEvent.ACTION_DRAG_EXITED:
			x_cord = event.getX();
			y_cord = event.getY();
			layoutParams.leftMargin = (int) x_cord;
			layoutParams.topMargin = (int) y_cord;
			v.setLayoutParams(layoutParams);
			Toast.makeText(getApplicationContext(), "ACTION_DRAG_EXITED", 2)
					.show();

			break;
		case DragEvent.ACTION_DRAG_LOCATION:
			x_cord = event.getX();
			y_cord = event.getY();
			Toast.makeText(getApplicationContext(), "ACTION_DRAG_LOCATION", 2)
					.show();
			break;
		case DragEvent.ACTION_DROP:
			// Dropped, reassign View to ViewGroup
			x_cord = event.getX();
			y_cord = event.getY();
			Toast.makeText(getApplicationContext(), "ACTION_DROP", 2).show();
			break;
		case DragEvent.ACTION_DRAG_ENDED:
			x_cord = event.getX();
			y_cord = event.getY();
			Toast.makeText(getApplicationContext(), "ACTION_DRAG_ENDED", 2)
					.show();
		default:
			break;
		}
		return true;
	}

}
