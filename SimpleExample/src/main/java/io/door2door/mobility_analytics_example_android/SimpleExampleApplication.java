package io.door2door.mobility_analytics_example_android;

import android.app.Application;

import io.door2door.analytics.api.MobilityAnalytics;
import io.door2door.analytics.base.model.Environment;
import io.door2door.analytics.api.model.InitializationParameters;

/**
 * Extension of the application class.
 */
public class SimpleExampleApplication extends Application {

    // mobility analytics application singleton instance
    private MobilityAnalytics mobilityAnalytics;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public MobilityAnalytics getMobilityAnalytics() {
        // lazy load
        if (mobilityAnalytics == null) {
            // setup the initializations parameters for the mobility analytics
            InitializationParameters initializationParameters =
                    new InitializationParameters.InitializationParametersBuilder()
                            .setApplicationName("SimpleExample")
                            .setVersionName("1.0.0")
                            .setLoggerEnabled(true)
                            .setEnvironment(Environment.TEST)
                            .build();

            // setup the mobility analytics application singleton instance
            mobilityAnalytics = new MobilityAnalytics(this, initializationParameters);
        }

        return mobilityAnalytics;
    }

}
