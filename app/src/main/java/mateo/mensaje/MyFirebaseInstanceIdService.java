package mateo.mensaje;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by mateo-_000 on 13/09/2016.
 */

//Clase que gestiona los tokens
public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {

    public static final String TAG = "NOTICIAS";

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh(); //se ejecuta cuando se asigna un token o cuando se actualiza

        //Para acceder al token
        String token = FirebaseInstanceId.getInstance().getToken();

        //Para mostrar por consola
        Log.d(TAG, "Token: " + token);
    }
}
