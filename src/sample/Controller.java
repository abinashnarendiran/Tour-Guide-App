package sample;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.JavascriptObject;
import com.lynden.gmapsfx.javascript.object.*;
import com.lynden.gmapsfx.service.directions.*;
import java.net.URL;
import java.sql.Time;
import java.util.Date;


import java.util.ResourceBundle;
import com.lynden.gmapsfx.service.geocoding.GeocodingService;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class Controller implements Initializable, MapComponentInitializedListener, DirectionsServiceCallback {


    private GoogleMap map;
    private DirectionsService directionsService;
    private DirectionsPane directionsPane;
    private GeocodingService geocodingService;

    // gets the value of wrapping string value
    private StringProperty from = new SimpleStringProperty();
    private StringProperty to = new SimpleStringProperty();


    // google map view
    @FXML
    protected GoogleMapView mapView;

    // user enters the from endpoint
    @FXML
    protected TextField fromTextField;

    // user enters the to endpoint
    @FXML
    protected TextField toTextField;




    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // sets the map inialized listener to fxml controller
        mapView.addMapInializedListener(this);

        // binds with from and to string properties to the text propertise
        from.bindBidirectional(fromTextField.textProperty());
        to.bindBidirectional(toTextField.textProperty());
    }

    // The user hits enters and calls the built in function getRoute which gets
    // the distance between to places
    @FXML
    private void toTextFieldAction() {
        // how the user is getting to a place from another place without (driving)
        DirectionsRequest request = new DirectionsRequest(from.get(), to.get(), TravelModes.DRIVING);

        // directionRender handles the display and the direction pane
        directionsService.getRoute(request, this, new DirectionsRenderer(true, mapView.getMap(), directionsPane));
    }


    // Checks to see if direction was recieved and once it was recieved it gets the total distance
    // outputs the total distance
    @Override
    public void directionsReceived(DirectionsResult results, DirectionStatus status) {
        if(status.equals(DirectionStatus.OK)) {
            DirectionsResult dr = results;
            try{
                // outputs the total distance from point A to point B
                System.out.println("Distance total = " + dr.getRoutes().get(0).getLegs().get(0).getDistance().getText());
            } catch (Exception ex) {
                // outputs the error, if there is one
                System.out.println("Error:" + ex.getMessage());
            }
        }
    }


    // initializes the map
    @Override
    public void mapInitialized() {
        MapOptions options = new MapOptions();

        // sets the initial location when the map opens up (Toronto)
        options.center(new LatLong(43.6532, -79.3832))
                .zoomControl(true) // allow zoom
                .zoom(12) // initial zoom set point
                .overviewMapControl(false)
                .mapType(MapTypeIdEnum.ROADMAP); // the typpe of map that used (road map)

        // instantiated map view from Google map
        map = mapView.createMap(options);

        // runs the direction service
        directionsService = new DirectionsService();

        // uses direction pane to display the map
        directionsPane = mapView.getDirec();
    }
}