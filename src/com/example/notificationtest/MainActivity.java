package com.example.notificationtest;

import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;

public class MainActivity extends Activity{
	 private static final int NOTIFY_ME_ID=1987;
	  private int count=0;
	  NotificationManager manager =null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		
	}
	
	@SuppressWarnings("deprecation")
	public void createNotification(View v){
		Notification notification = new Notification(R.drawable.ic_launcher,"New message", System.currentTimeMillis());
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, NotificationReceiverActivity.class), 0);
		notification.setLatestEventInfo(this, "New Email", "Conversation", pendingIntent);
		/*notification.number=++count;
		notification.vibrate=new long[] {500L, 200L, 200L, 500L};*/
		notification.flags |=Notification.FLAG_AUTO_CANCEL;	
	    
		manager.notify(NOTIFY_ME_ID,notification);
		
		
	}
	
	
	
}