package org.vurtatoo.signalphonemode;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener {

	ImageView imageView;
	Button button;
	AudioManager audioManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		imageView = (ImageView) findViewById(R.id.imageView1);
		button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(this);
		
		audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.button1) {
			int ringMode = audioManager.getRingerMode();
			Drawable  drawable = null;
			switch (ringMode) {
			case AudioManager.RINGER_MODE_NORMAL: {
				audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
				drawable = getResources().getDrawable(R.drawable.phone_silent);
				
			}
				
				break;
			case AudioManager.RINGER_MODE_SILENT: {
				audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
				drawable = getResources().getDrawable(R.drawable.phone_on);
			}
				
				break;
			case AudioManager.RINGER_MODE_VIBRATE: {
				audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
				drawable = getResources().getDrawable(R.drawable.phone_on);
			}	
				break;

			}
			if (drawable != null) {
				imageView.setImageDrawable(drawable);	
			}
			
		}
		
	}
}
