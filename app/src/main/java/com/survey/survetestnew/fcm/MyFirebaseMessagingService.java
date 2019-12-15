package com.survey.survetestnew.fcm;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.survey.survetestnew.R;
import com.survey.survetestnew.survey.ActivityWithNavigationMenuPatient;

import java.util.Map;


public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage message) {
        //sendMyNotification(message.getNotification().getBody());

        if (message.getData().size() > 0) {
            Log.e("data_payload==>", "" + message.getData());
            // user_id = message.getData().get("message");
            Map<String, String> data = message.getData();
            String title = data.get("title");
            String body = data.get("body");
            String msg = data.get("message");
            String badge = data.get("badge");
            String Branch_Id = data.get("Branch_Id");
            sendMyNotification(title, body, msg, Branch_Id);
            //  startNotification(title,body,msg,Branch_Id);


        } else { // for testing from firebase console;

            String titile = message.getNotification().getTitle();
            String body = message.getNotification().getBody();

            sendMyNotification(titile, body,body, "22");

        }

    }

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        Log.e("NEW_TOKEN", s);
      /*  UTIL.setPref(this, UTIL.Key_FCMTOken, s);
        String type = UTIL.getPref(MyFirebaseMessagingService.this, UTIL.Key_Type);
        String UserId = UTIL.getPref(MyFirebaseMessagingService.this, UTIL.Key_UserId);
        if (type.equals("2")) {//patient
            if(!UserId.equals("")){
                UpdateFCMTokenAtServer();
            }

        } else if (type.equals("1")) {// admin

        }*/

    }

    private void sendMyNotification(String title, String message, String type, String Branch_Id) {
        //On click of notification it redirect to this Activity
      //  Intent intent = null;


           Intent intent = new Intent(this, ActivityWithNavigationMenuPatient.class);
        intent.putExtra("push", "1");
        intent.putExtra("Branch_Id", Branch_Id);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(message)
                .setAutoCancel(true)
                .setSound(soundUri)
                .setChannelId("my_channel_id_00011") // set channel id
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(1224, notificationBuilder.build());
    }

}
