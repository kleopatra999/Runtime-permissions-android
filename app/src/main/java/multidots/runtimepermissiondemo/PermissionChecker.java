package multidots.runtimepermissiondemo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PermissionChecker extends AppCompatActivity implements View.OnClickListener {

    private Button btnCamera;
    private Button btnGallery;
    private Button btnLocation;
    private Button btnWifi;
    private Button btnContacts;
    private Button btnCall;
    private Button btnReadSms;
    private Button btnInternet;
    private Button btnFlashlight;
    private Button btnCalender;

    private static final int MY_PERMISSIONS_REQUEST = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);

        initialize();
    }

    private void initialize() {

        btnCamera = (Button) findViewById(R.id.permission_btn_camera);
        btnGallery = (Button) findViewById(R.id.permission_btn_gallery);
        btnLocation = (Button) findViewById(R.id.permission_btn_location);
        btnWifi = (Button) findViewById(R.id.permission_btn_wifi);
        btnContacts = (Button) findViewById(R.id.permission_btn_contact);
        btnCall = (Button) findViewById(R.id.permission_btn_call);
        btnReadSms = (Button) findViewById(R.id.permission_btn_sms);
        btnInternet = (Button) findViewById(R.id.permission_btn_internet);
        btnFlashlight = (Button) findViewById(R.id.permission_btn_flashlight);
        btnCalender = (Button) findViewById(R.id.permission_btn_calender);

        //onClick of this event
        btnCamera.setOnClickListener(this);
        btnGallery.setOnClickListener(this);
        btnLocation.setOnClickListener(this);
        btnWifi.setOnClickListener(this);
        btnContacts.setOnClickListener(this);
        btnCall.setOnClickListener(this);
        btnReadSms.setOnClickListener(this);
        btnInternet.setOnClickListener(this);
        btnFlashlight.setOnClickListener(this);
        btnCalender.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnCamera) {
            requestPermission(new String[]{Manifest.permission.CAMERA});
        } else if (v == btnGallery) {
            requestPermission(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE});
        } else if (v == btnLocation) {
            requestPermission(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION});
        } else if (v == btnWifi) {
            requestPermission(new String[]{Manifest.permission.CHANGE_WIFI_MULTICAST_STATE, Manifest.permission.ACCESS_WIFI_STATE, Manifest.permission.CHANGE_WIFI_STATE});
        } else if (v == btnContacts) {
            requestPermission(new String[]{Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS});
        } else if (v == btnCall) {
            requestPermission(new String[]{Manifest.permission.CALL_PHONE});
        } else if (v == btnReadSms) {
            requestPermission(new String[]{Manifest.permission.READ_SMS, Manifest.permission.SEND_SMS, Manifest.permission.BROADCAST_SMS, Manifest.permission.RECEIVE_SMS});
        } else if (v == btnInternet) {
            requestPermission(new String[]{Manifest.permission.INTERNET});
        } else if (v == btnFlashlight) {
            requestPermission(new String[]{Manifest.permission.FLASHLIGHT});
        } else if (v == btnCalender) {
            requestPermission(new String[]{Manifest.permission.READ_CALENDAR, Manifest.permission.WRITE_CALENDAR});
        }
    }

    /**
     * This is common method for requesting any kind of permissions
     *
     * @param permission
     */
    public void requestPermission(String[] permission) {
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(PermissionChecker.this,
                permission[0])
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(PermissionChecker.this,
                    permission[0])) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

//                Toast.makeText(PermissionChecker.this, "Permission already granted", Toast.LENGTH_SHORT).show();
            } else {
                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(PermissionChecker.this,
                        permission,
                        MY_PERMISSIONS_REQUEST);

                // MY_PERMISSIONS_REQUEST is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }
    }

    /**
     * This is the call back that is used to grant permission.
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(PermissionChecker.this, "Granted permission...", Toast.LENGTH_SHORT).show();
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {

                    Toast.makeText(PermissionChecker.this, "Permission denied...", Toast.LENGTH_SHORT).show();
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}
