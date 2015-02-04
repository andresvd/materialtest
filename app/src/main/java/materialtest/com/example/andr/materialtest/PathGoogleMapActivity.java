package materialtest.com.example.andr.materialtest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class PathGoogleMapActivity extends FragmentActivity {
    Button terminarRota;

	private static final LatLng LOWER_MANHATTAN = new LatLng(40.722543,
			-73.998585);
	private static final LatLng BROOKLYN_BRIDGE = new LatLng(40.7057, -73.9964);
	private static final LatLng WALL_STREET = new LatLng(40.7064, -74.0094);


    private static final LatLng UFPE = new LatLng(-8.048156, -34.954280);
    private static final LatLng DERBY = new LatLng(-8.056719, -34.899305);
    private static final LatLng REC_ANTIGO = new LatLng(-8.064448, -34.874275);
    private static final LatLng CAXANGA = new LatLng(-8.043667, -34.933478);
    private static final LatLng CAPIBARIBE = new LatLng(-8.063393, -34.879411);


    Toolbar toolbar;

	GoogleMap googleMap;
	final String TAG = "PathGoogleMapActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_path_google_map);
		SupportMapFragment fm = (SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.map);
        toolbar = (Toolbar) findViewById(R.id.app_bar);

        //setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        //drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);


		googleMap = fm.getMap();
        terminarRota = (Button) findViewById(R.id.terminarRota);
        terminarRota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PathGoogleMapActivity.this, FeedbackActivity.class);
                startActivity(intent);
            }
        });

        googleMap.addMarker(new MarkerOptions().position(UFPE ).title("Pega ônibus 440 - CDU Caxangá/Boa Viagem"));
        fazPassoRota(UFPE, CAXANGA, null);
        fazPassoRota(CAXANGA, DERBY, "Pega ônibus 42 - Aeroporto");

        fazPassoRota(DERBY, CAPIBARIBE, "Pega bicileta e atravessa ponte Maurício de Nassau e dobra a primeira à esquerda");
        fazPassoRota(CAPIBARIBE, REC_ANTIGO, "Fim de rota");
        /*
        LatLng startLocation = UFPE;
        LatLng endLocation = DERBY;


        googleMap.addMarker(new MarkerOptions().position(startLocation ).title("start"));
        googleMap.addMarker(new MarkerOptions().position(endLocation ).title("Pega Bicicleta"));


        googleMap.addMarker(new MarkerOptions().position(REC_ANTIGO ).title("Fim"));

        Navigator navigator = new Navigator(googleMap, startLocation, endLocation);
        navigator.findDirections(true);

        Navigator navigator2 = new Navigator(googleMap, endLocation, REC_ANTIGO);
        navigator2.findDirections(true);*/
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UFPE,
                13));

		/*MarkerOptions options = new MarkerOptions();
		options.position(LOWER_MANHATTAN);
		options.position(BROOKLYN_BRIDGE);
		options.position(WALL_STREET);
		googleMap.addMarker(options);
		String url = getMapsApiDirectionsUrl();
		ReadTask downloadTask = new ReadTask();
		downloadTask.execute(url);

		googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BROOKLYN_BRIDGE,
				13));
		addMarkers();*/

	}

    private void fazPassoRota(LatLng inicio, LatLng fim, String textoFim){
        Navigator navigator = new Navigator(googleMap, inicio, fim);
        navigator.findDirections(true);
        if (textoFim != null){
            googleMap.addMarker(new MarkerOptions().position(fim ).title(textoFim));
        }

    }

	private String getMapsApiDirectionsUrl() {
		String waypoints =
                //"waypoints=optimize:true|" +
                LOWER_MANHATTAN.latitude + "," + LOWER_MANHATTAN.longitude
				+ "|" + "|" + BROOKLYN_BRIDGE.latitude + ","
				+ BROOKLYN_BRIDGE.longitude + "|" + WALL_STREET.latitude + ","
				+ WALL_STREET.longitude;

		String sensor = "sensor=false";
		String params = waypoints + "&" + sensor;
		String output = "json";
		String url = "https://maps.googleapis.com/maps/api/directions/"
				+ output + "?" + params;
		return url;
	}

	private void addMarkers() {
		if (googleMap != null) {
			googleMap.addMarker(new MarkerOptions().position(BROOKLYN_BRIDGE)
					.title("First Point"));
			googleMap.addMarker(new MarkerOptions().position(LOWER_MANHATTAN)
					.title("Second Point"));
			googleMap.addMarker(new MarkerOptions().position(WALL_STREET)
					.title("Third Point"));
		}
	}

	private class ReadTask extends AsyncTask<String, Void, String> {
		@Override
		protected String doInBackground(String... url) {
			String data = "";
			try {
				HttpConnection http = new HttpConnection();
				data = http.readUrl(url[0]);
			} catch (Exception e) {
				Log.d("Background Task", e.toString());
			}
			return data;
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			new ParserTask().execute(result);
		}
	}

	private class ParserTask extends
			AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {

		@Override
		protected List<List<HashMap<String, String>>> doInBackground(
				String... jsonData) {

			JSONObject jObject;
			List<List<HashMap<String, String>>> routes = null;

			try {
				jObject = new JSONObject(jsonData[0]);
				PathJSONParser parser = new PathJSONParser();
				routes = parser.parse(jObject);
			} catch (Exception e) {
                Log.d("André", "Erroooooooooooooooooo");
				e.printStackTrace();
			}
			return routes;
		}

		@Override
		protected void onPostExecute(List<List<HashMap<String, String>>> routes) {
			ArrayList<LatLng> points = null;
			PolylineOptions polyLineOptions = null;

			// traversing through routes
			for (int i = 0; i < routes.size(); i++) {
				points = new ArrayList<LatLng>();
				polyLineOptions = new PolylineOptions();
				List<HashMap<String, String>> path = routes.get(i);

				for (int j = 0; j < path.size(); j++) {
					HashMap<String, String> point = path.get(j);

					double lat = Double.parseDouble(point.get("lat"));
					double lng = Double.parseDouble(point.get("lng"));
					LatLng position = new LatLng(lat, lng);

					points.add(position);
				}

				polyLineOptions.addAll(points);
				polyLineOptions.width(2);
				polyLineOptions.color(Color.BLUE);
			}

			googleMap.addPolyline(polyLineOptions);
		}
	}
}
