package com.speryans.bb10ui;

import java.util.Hashtable;

import android.content.Context;
import android.graphics.Typeface;

public class Typefaces {
	private static final Hashtable<String, Typeface> cache = new Hashtable<String, Typeface>();

	public static Typeface get(Context c, String assetPath) {
		synchronized (cache) {
			if (!cache.containsKey(assetPath)) {
				try {
					Typeface t = Typeface.createFromAsset(c.getAssets(), assetPath);
					cache.put(assetPath, t);
					
					return t;
				} catch (Exception e) {
					return null;
				}
			}
			
			return cache.get(assetPath);
		}
	}
	
	/**
	 * Get BB Font to be used with setTypeface method.
	 * 
	 * @param c
	 * @return
	 */
	public static Typeface getBBFont( Context c ) {
		return Typefaces.get(c, "bbfont.ttf" );
	}
}
