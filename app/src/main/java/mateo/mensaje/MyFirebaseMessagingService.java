package mateo.mensaje;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by mateo-_000 on 13/09/2016.
 */

//Se encarga de recibir el mensaje
public class MyFirebaseMessagingService extends FirebaseMessagingService {

    public static final String TAG = "NOTICIAS";

    //En este metodo llegan las notificaciones
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        //Codigo del originante
        String from = remoteMessage.getFrom();
        Log.d(TAG, "Mensaje recibido de: " + from);

        //Acceder al contenido de la aplicacion
        if (remoteMessage.getNotification() != null){
            Log.d(TAG, "Notificación: " + remoteMessage.getNotification().getBody()); //Contenido de la notificación

            mostrarNotificacion(remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody());
        }

        //Para saber si la notificacion tiene informacion extra
        if (remoteMessage.getData().size() > 0){
            Log.d(TAG, "Data: " + remoteMessage.getData());
        }
    }

    //Mostrar la notificacion push
    private void mostrarNotificacion(String title, String body) {

        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        //Lo que realiza cuando se presione sobre el
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        //Titulo, cuerpo e icono de la notificacion
        NotificationCompat.Builder notificacionBuilder = new NotificationCompat.Builder(this)
                //.setSmallIcon(R.drawable.)
                .setContentTitle(title)
                .setContentText(body)
                .setAutoCancel(true)
                .setSound(soundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notificacionBuilder.build());
    }
}
