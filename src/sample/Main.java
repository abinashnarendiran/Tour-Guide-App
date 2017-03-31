package sample;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.*;
import com.lynden.gmapsfx.service.directions.DirectionStatus;
import com.lynden.gmapsfx.service.directions.DirectionsRenderer;
import com.lynden.gmapsfx.service.directions.DirectionsResult;
import com.lynden.gmapsfx.service.geocoding.GeocodingService;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import netscape.javascript.JSObject;


public class Main extends Application implements MapComponentInitializedListener {

    GoogleMapView mapView;
    GoogleMap map;
    DirectionsPane directions;

    private Button zoomIn;
    private Button zoomOut;
    private Label lblCenter;
    private Label lblZoom;
    private Label lblClick;


    @Override
    public void start(Stage primaryStage) throws Exception{
        //Zoom in button
        zoomIn = new Button("Zoom In");
        zoomIn.setOnAction(e -> {
            map.zoomProperty().set(map.getZoom() +1);
        });
        zoomIn.setDisable(true);

        //Zoom out button
        zoomOut = new Button("Zoom Out");
        zoomOut.setOnAction(e -> {
            map.zoomProperty().set(map.getZoom()+1);
        });
        zoomOut.setDisable(true);

        lblZoom = new Label();
        lblCenter = new Label();
        lblClick = new Label();


        // view map
        mapView = new GoogleMapView();
        mapView.addMapInializedListener(this);

        Scene scene = new Scene(mapView);
        primaryStage.setTitle("Google Map");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    DirectionsRenderer renderer;

    @Override
    public void mapInitialized() {
        // set the inital properties of the  map
        MapOptions mapOptions = new MapOptions();
        LatLong latLong = new LatLong(47.6097,-122.3331);

        mapOptions.center(latLong)
                .mapType(MapTypeIdEnum.ROADMAP)
                .overviewMapControl(false)
                .panControl(false)
                .rotateControl(false)
                .scaleControl(false)
                .streetViewControl(false)
                .zoomControl(false)
                .zoom(12);

        map = mapView.createMap(mapOptions);

        // Add marker to the map
        MarkerOptions markerOptions = new MarkerOptions();

        markerOptions.position(new LatLong(47.6, -122.3))
                .visible(Boolean.FALSE)
                .title("My marker");

        Marker marker = new Marker(markerOptions);

        map.addMarker(marker);

        // displays info on current marker postion
        InfoWindowOptions infoOption = new InfoWindowOptions();
        infoOption.content("<h2>Here's an info window</h2><h3>with some info</h3>")
                .position(latLong);

        InfoWindow window = new InfoWindow(infoOption);
        window.open(map, marker);

        /* Labels: Deal with it later
        lblCenter.setText(map.getCenter().toString());
        map.centerProperty().addListener((ObservableValue<? extends LatLong> obs, LatLong o, LatLong n) -> {
            lblCenter.setText(n.toString());
        });

        lblZoom.setText(Integer.toString(map.getZoom()));
        map.zoomProperty().addListener((ObservableValue<? extends Number> obs, Number o, Number n) ->{
            lblZoom.setText(n.toString());
        });

        map.addUIEventHandler(UIEventType.click, (JSObject obj) -> {
            LatLong ll = new LatLong((JSObject) obj.getMember("latLong"));
            lblClick.setText(ll.toString());
        });
        */

    }


    public void directionsRecieved(DirectionsResult result, DirectionStatus status) {
        if(status.equals(DirectionStatus.OK)) {
            mapView.getMap().showDirectionsPane();
            System.out.println("OK");

            DirectionsResult e = result;
            GeocodingService gs = new GeocodingService();

            System.out.println("SIZE ROUTES: " + e.getRoutes().size() + "\n" + "ORIGIN:" +
                               e.getRoutes().get(0).getLegs().get(0).getStartLocation());
            System.out.println("LEG SIZE: " + e.getRoutes().get(0).getLegs().size());
            System.out.println("WAYPOINTS " + e.getGeocodedWaypoints().size());

            try {
                //System.out.println("Distance total = " + e.getRoutes().get(0).getLegs().getDistance().getText());
            } catch (Exception ec) {
                System.out.println("ERO: " + ec.getMessage());
            }
            System.out.println("LEG(0)");
            System.out.println(e.getRoutes().get(0).getLegs().get(0).getSteps().size());

            System.out.println(renderer.toString());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
