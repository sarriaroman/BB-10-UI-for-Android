package com.speryans.bb10ui;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BBeizer {
	public Activity activity;
	public Typeface bbfont;
	
	public BBeizer( Activity act ) {
		this.activity = act;
		
		bbfont = Typefaces.getBBFont(activity);
	}
	
	public BBeizer magic( int layout ) {
		this.activity.setContentView(R.layout.bb10);
		
		RelativeLayout root = (RelativeLayout) this.activity.findViewById(R.id.main_container);
		
		root.addView( LayoutInflater.from(this.activity).inflate(layout, root, false) );
		
		this.createBack();
		
		return this;
	}
	
	public BBeizer showTitle( CharSequence text ) {
		LinearLayout title = (LinearLayout) this.activity.findViewById(R.id.header_bar);
		title.setVisibility(View.VISIBLE);
		
		LinearLayout title_shadow = (LinearLayout) this.activity.findViewById(R.id.top_shadow);
		title_shadow.setVisibility(View.VISIBLE);
		
		TextView title_text = ( TextView ) this.activity.findViewById(R.id.header_text);
		title_text.setText(text);
		title_text.setTypeface(bbfont);
		
		return this;
	}
	
	
	public BBeizer showTitle( int text ) {
		return this.showTitle( this.activity.getText(text) );
	}
	
	public BBeizer hideTitle( ) {
		LinearLayout title = (LinearLayout) this.activity.findViewById(R.id.header_bar);
		title.setVisibility(View.GONE);
		
		LinearLayout title_shadow = (LinearLayout) this.activity.findViewById(R.id.top_shadow);
		title_shadow.setVisibility(View.GONE);
		
		return this;
	}
	
	private void createBack() {
		LinearLayout back_button = (LinearLayout) this.activity.findViewById(R.id.back_button);
		back_button.setOnClickListener( new OnClickListener() {

			@Override
			public void onClick(View v) {
				onBackButtonPressed();
			}
			
		});
		
		((TextView) this.activity.findViewById(R.id.back_text)).setTypeface(bbfont);
	}
	
	public void onBackButtonPressed() {
		this.activity.finish();
	}
}
