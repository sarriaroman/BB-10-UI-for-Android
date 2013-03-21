package com.speryans.bb10ui;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * BBeizer
 * 
 * Class to implement BB10 navigation bar and title bar on your Android app
 * This class will always return the pointer to the created class.
 * 
 * @author sarriaroman
 *
 */
public class BBeizer {
	public Activity activity;
	public Typeface bbfont;
	
	/**
	 * Create BBeizer class
	 * 
	 * @param act
	 */
	public BBeizer( Activity act ) {
		this.activity = act;
		
		bbfont = Typefaces.getBBFont(activity);
	}
	
	/**
	 * BBUI Builder
	 * 
	 * * Old UI construction method.
	 * 
	 * @param layout
	 * @return
	 */
	public BBeizer magic( int layout ) {
		return this.setContentView(layout);
	}
	
	/**
	 * BBUI Builder
	 * 
	 * @param layout
	 * @return
	 */
	public BBeizer setContentView( int layout ) {
		this.activity.setContentView(R.layout.bb10);
		
		RelativeLayout root = (RelativeLayout) this.activity.findViewById(R.id.main_container);
		
		root.addView( LayoutInflater.from(this.activity).inflate(layout, root, false) );
		
		this.createBack();
		
		return this;
	}
	
	/**
	 * Show BB10 UI Like title
	 * 
	 * @param text
	 * @return
	 */
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
	
	/**
	 * Show title using localizable resource
	 * 
	 * @param text
	 * @return
	 */
	public BBeizer showTitle( int text ) {
		return this.showTitle( this.activity.getText(text) );
	}
	
	/**
	 * Hide the title bar.
	 * 
	 * @return
	 */
	public BBeizer hideTitle( ) {
		LinearLayout title = (LinearLayout) this.activity.findViewById(R.id.header_bar);
		title.setVisibility(View.GONE);
		
		LinearLayout title_shadow = (LinearLayout) this.activity.findViewById(R.id.top_shadow);
		title_shadow.setVisibility(View.GONE);
		
		return this;
	}
	
	/**
	 * Show the navigation bar when hided.
	 * 
	 * @return
	 */
	public BBeizer showNavigationBar() {
		LinearLayout title = (LinearLayout) this.activity.findViewById(R.id.back_bar);
		title.setVisibility(View.VISIBLE);
		
		LinearLayout title_shadow = (LinearLayout) this.activity.findViewById(R.id.bottom_shadow);
		title_shadow.setVisibility(View.VISIBLE);
		
		return this;
	}
	
	/**
	 * Hides the navigation bar
	 * 
	 * @return
	 */
	public BBeizer hideNavigationBar() {
		LinearLayout title = (LinearLayout) this.activity.findViewById(R.id.back_bar);
		title.setVisibility(View.GONE);
		
		LinearLayout title_shadow = (LinearLayout) this.activity.findViewById(R.id.bottom_shadow);
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
	
	/**
	 * Method invoked when back button is pressed
	 * 
	 * Override if you need to take control over the back action.
	 * 
	 */
	public void onBackButtonPressed() {
		this.activity.finish();
	}
}
