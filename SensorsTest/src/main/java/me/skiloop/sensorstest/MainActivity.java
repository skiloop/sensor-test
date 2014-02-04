package me.skiloop.sensorstest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.*;
import android.widget.TextView;
import org.openintents.sensorsimulator.hardware.Sensor;
import org.openintents.sensorsimulator.hardware.SensorEvent;
import org.openintents.sensorsimulator.hardware.SensorEventListener;
import org.openintents.sensorsimulator.hardware.SensorManagerSimulator;

//import android.hardware.Sensor;
//import android.hardware.SensorEvent;
//import android.hardware.SensorEventListener;
//import android.hardware.SensorManager;
//import android.hardware.SensorEventListener;
//import android.hardware.SensorManager;


public class MainActivity extends ActionBarActivity implements SensorEventListener {


    //    SensorManager sensorManager;
    SensorManagerSimulator sensorManager;
    private TextView tvAcc;
    TextView tvOrientation;
    TextView tvMagnetic;
    TextView tvTemperature;
    TextView tvLight;
    TextView tvPressure;
    TextView tvGravity;
    TextView tvGyroscope;
    TextView tvProximity;
    TextView tvRotationVector;
    TextView tvHumidity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new DummyFragment())
                    .commit();
        }

        tvAcc = (TextView) findViewById(R.id.tvAcc);
        tvOrientation = (TextView) findViewById(R.id.tvOrientation);
        tvTemperature = (TextView) findViewById(R.id.tvTemperature);
        tvMagnetic = (TextView) findViewById(R.id.tvMagnetic);
        tvLight = (TextView) findViewById(R.id.tvLight);
        tvPressure = (TextView) findViewById(R.id.tvPressure);
        tvGravity = (TextView) findViewById(R.id.tvGravity);
        tvGyroscope = (TextView) findViewById(R.id.tvGyroscope);
        tvProximity = (TextView) findViewById(R.id.tvProximity);
        tvRotationVector = (TextView) findViewById(R.id.tvRotationVector);
        tvHumidity = (TextView) findViewById(R.id.tvHumidity);


//        get system sensor manager
//        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        SensorManagerSimulator sensorManager = SensorManagerSimulator.getSystemService(this, SENSOR_SERVICE);
        sensorManager.connectSimulator();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A dummy fragment containing a simple view.
     */
    public static class DummyFragment extends Fragment {

        public DummyFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
//        // register accelerometer sensor
//        sensorManager.registerListener(this,
//                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
//                SensorManager.SENSOR_DELAY_NORMAL);
//        // register orientation sensor
//        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
//                SensorManager.SENSOR_DELAY_GAME);
//        // register magnetic sensor
//        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),
//                SensorManager.SENSOR_DELAY_GAME);
//        // register temperature sensor
//        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE),
//                SensorManager.SENSOR_DELAY_GAME);
//        // register light sensor
//        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT),
//                SensorManager.SENSOR_DELAY_GAME);
//        // register pressure sensor
//        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE),
//                SensorManager.SENSOR_DELAY_GAME);
//        // register gravity sensor
//        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY),
//                SensorManager.SENSOR_DELAY_GAME);
//        // register gyroscope sensor
//        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE),
//                SensorManager.SENSOR_DELAY_GAME);
//        // register proximity sensor
//        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY),
//                SensorManager.SENSOR_DELAY_GAME);
//        // register rotation vector sensor
//        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR),
//                SensorManager.SENSOR_DELAY_GAME);
//        // register Humidity sensor
//        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY),
//                SensorManager.SENSOR_DELAY_GAME);
        // register accelerometer sensor
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManagerSimulator.SENSOR_DELAY_NORMAL);
        // register orientation sensor
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
                SensorManagerSimulator.SENSOR_DELAY_GAME);
        // register magnetic sensor
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),
                SensorManagerSimulator.SENSOR_DELAY_GAME);
        // register temperature sensor
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_TEMPERATURE),
                SensorManagerSimulator.SENSOR_DELAY_GAME);
        // register light sensor
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT),
                SensorManagerSimulator.SENSOR_DELAY_GAME);
        // register pressure sensor
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE),
                SensorManagerSimulator.SENSOR_DELAY_GAME);
        // register gravity sensor
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY),
                SensorManagerSimulator.SENSOR_DELAY_GAME);
        // register gyroscope sensor
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE),
                SensorManagerSimulator.SENSOR_DELAY_GAME);
        // register proximity sensor
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY),
                SensorManagerSimulator.SENSOR_DELAY_GAME);
        // register rotation vector sensor
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR),
                SensorManagerSimulator.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onStop() {
        // cancel register
        sensorManager.unregisterListener(this);
        super.onStop();
    }

    @Override
    protected void onPause() {
        // cancel register
        sensorManager.unregisterListener(this);
        super.onPause();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float[] values = event.values;
//        get sensor type
//        int sensorType = event.sensor.getType();
        int sensorType = event.type;

        StringBuffer sb = null;
        switch (sensorType) {
            case Sensor.TYPE_ACCELEROMETER:
                sb = new StringBuffer();
                sb.append("accelerometer on x direction: ");
                sb.append(values[0]);
                sb.append("\naccelerometer on y direction: ");
                sb.append(values[1]);
                sb.append("\naccelerometer on z direction: ");
                sb.append(values[2]);
                sb.append("\ntotal:" + Math.sqrt(values[0] * values[0] + values[1] * values[1] + values[2] * values[2]));
                tvAcc.setText(sb.toString());
                break;
            case Sensor.TYPE_ORIENTATION:
                sb = new StringBuffer();
                sb.append("orientation on x direction: ");
                sb.append(values[0]);
                sb.append("\norientation on y direction: ");
                sb.append(values[1]);
                sb.append("\norientation on z direction: ");
                sb.append(values[2]);
                tvOrientation.setText(sb.toString());
                break;
            case Sensor.TYPE_MAGNETIC_FIELD:
                sb = new StringBuffer();
                sb.append("magnetic on x direction: ");
                sb.append(values[0]);
                sb.append("\nmagnetic on y direction: ");
                sb.append(values[1]);
                sb.append("\nmagnetic on z direction: ");
                sb.append(values[2]);
                tvMagnetic.setText(sb.toString());
                break;
            case Sensor.TYPE_TEMPERATURE:
                sb = new StringBuffer();
                sb.append("Current temperature: ");
                sb.append(values[0]);
                //sb.append("摄氏度");
                tvTemperature.setText(sb.toString());
                break;
            case Sensor.TYPE_LIGHT:
                sb = new StringBuffer();
                sb.append("Current light: ");
                sb.append(values[0]);
                sb.append(" lux");
                tvLight.setText(sb.toString());
                break;
            case Sensor.TYPE_PRESSURE:
                sb = new StringBuffer();
                sb.append("Current pressure: ");
                sb.append(values[0]);
                sb.append(" hPa");
                tvPressure.setText(sb.toString());
                break;
            case Sensor.TYPE_GRAVITY:
                sb = new StringBuffer();
                sb.append("gravity on x direction: ");
                sb.append(values[0]);
                sb.append("\ngravity on y direction: ");
                sb.append(values[1]);
                sb.append("\ngravity on z direction: ");
                sb.append(values[2]);
                tvGravity.setText(sb.toString());
                break;
            case Sensor.TYPE_GYROSCOPE:
                sb = new StringBuffer();
                sb.append("gyroscope on x direction: ");
                sb.append(values[0]);
                sb.append("\ngyroscope on y direction: ");
                sb.append(values[1]);
                sb.append("\ngyroscope on z direction: ");
                sb.append(values[2]);
                tvGyroscope.setText(sb.toString());
                break;
            case Sensor.TYPE_PROXIMITY:
                sb = new StringBuffer();
                sb.append("Proximity : ");
                sb.append(values[0]);
                sb.append(" cm");
                tvProximity.setText(sb.toString());
                break;
            case Sensor.TYPE_ROTATION_VECTOR:
                sb = new StringBuffer();
                sb.append(getResources().getString(R.string.rotation_vector) + ":\n");
                sb.append("x:" + values[0] + "\n");
                sb.append("y:" + values[1] + "\n");
                sb.append("z:" + values[2] + "\n");
                tvProximity.setText(sb.toString());
                break;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}