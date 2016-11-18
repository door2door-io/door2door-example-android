package io.door2door.mobility_analytics_example_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Date;

import io.door2door.analytics.api.MobilityAnalytics;
import io.door2door.analytics.api.model.SearchTripEvent;
import io.door2door.analytics.base.model.ModeOfTransportation;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button recordAnEventButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recordAnEventButton = (Button) findViewById(R.id.recordAnEventButton);
        recordAnEventButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        SimpleExampleApplication application = (SimpleExampleApplication) getApplication();
        MobilityAnalytics mobilityAnalytics = application.getMobilityAnalytics();

        // prepare a sample event for tracking a trip creation
        SearchTripEvent event = new SearchTripEvent.SearchTripEventBuilder()
                .setDepartureTimestamp(new Date(1479198911636L)) // some dummy date in millis
                .setDepartureLatitude(52.529919)
                .setDepartureLongitude(13.403067)
                .setDepartureName("Door2Door HQ")
                .setDepartureStreet("Torstrasse 109")
                .setDepartureCity("Berlin")
                .setDeparturePostalCode("10119")
                .setDepartureCountry("Germany")
                .setArrivalTimestamp(new Date(1479198922313L)) // some dummy date in millis
                .setArrivalLatitude(52.522258)
                .setArrivalLongitude(13.412678)
                .setArrivalName("Alexanderplatz")
                .setArrivalStreet("AlexanderplatzStreet")
                .setArrivalCity("BerlinCity")
                .setArrivalPostalCode("10178")
                .setArrivalCountry("GermanyCountry")
                .addModeOfTransportation(ModeOfTransportation.BIKE_SHARING)
                .addModeOfTransportation(ModeOfTransportation.CAR_SHARING)
                .build();

        // send the event to the mobility analytics instance
        mobilityAnalytics.recordEvent(event);
    }
}
