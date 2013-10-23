package com.example.mindmapcloud_tlcn;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Controller extends SurfaceView implements SurfaceHolder.Callback {
	private Paint paint = new Paint();
	Background background;

	public Controller(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		getHolder().addCallback(this);
		setFocusable(true);
		background = new Background(this.getResources());
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		paint.setColor(Color.BLUE);
		paint.setTextSize(20);
		canvas.drawColor(Color.BLACK);
		drawButton(canvas, 100, 100);
	}

	private void drawButton(Canvas canvas, int x, int y) {
		// TODO Auto-generated method stub
		canvas.drawRect(0, 0, getWidth(), getHeight(), paint);
	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void surfaceCreated(SurfaceHolder arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		// TODO Auto-generated method stub

	}
}
