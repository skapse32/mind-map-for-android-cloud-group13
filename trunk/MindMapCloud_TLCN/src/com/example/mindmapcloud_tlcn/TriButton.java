package com.example.mindmapcloud_tlcn;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.Button;
import android.widget.RelativeLayout;

public class TriButton extends Button {
	private Paint m_paint = new Paint();
	private int m_color = 0XFF92C84D; // LIKE AN OLIVE GREEN..

	public TriButton(Context context) {
		super(context);
	}

	public void onDraw(Canvas iCanvas) {
		// draw the button background
		m_paint.setColor(m_color);
		iCanvas.drawRoundRect(new RectF(0, 0, getWidth(), getHeight()), 70, 70,
				m_paint);
		// draw the text
		m_paint.setColor(Color.WHITE);
		iCanvas.drawText("bash is king", 0, 0, m_paint);
	}

	public RelativeLayout.LayoutParams GetRelativeParam(int iLeft, int iTop,
			int iWidth, int iHeight) {
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
				iHeight, iWidth);
		params.leftMargin = iLeft;
		params.topMargin = iTop;
		return params;
	}
}
