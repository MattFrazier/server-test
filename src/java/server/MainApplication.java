package server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import server.config.AppConfiguration;
import server.data.model.request.MovieResource;
import server.healthcheck.AppHealthCheck;

/**
 * Main application
 */
public class MainApplication extends Application<AppConfiguration>
{
	final static Logger logger = LoggerFactory.getLogger(MainApplication.class);

	public static void main(String[] args) throws Exception
	{
        new MainApplication().run(args);
    }

    @Override
    public String getName()
	{
        return "test-server";
    }

    @Override
    public void initialize(Bootstrap<AppConfiguration> bootstrap)
	{
        // framework bootstrap initialization
    }

    @Override
    public void run(AppConfiguration configuration, Environment environment) throws Exception
	{
    	environment.jersey().setUrlPattern("/service/*");
		final MovieResource resource = new MovieResource(configuration.getDefaultName());
		environment.jersey().register(resource);
		environment.healthChecks().register("app", new AppHealthCheck());
		try
		{
			logger.info("Starting...");

			// application initialization goes here
		}
		catch (Exception exc)
		{
			// log failure to set up app
			logger.error("Failed to initialize application, exiting...", exc);
			throw new RuntimeException();
		}
		

        // register servlet route handlers
		// environment.jersey().register(new YourServlet());
    }
}
