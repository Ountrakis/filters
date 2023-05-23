package filters;

import jakarta.ws.rs.client.ClientResponseContext;
import jakarta.ws.rs.ext.Provider;
import org.jboss.resteasy.reactive.client.spi.ResteasyReactiveClientRequestContext;
import org.jboss.resteasy.reactive.client.spi.ResteasyReactiveClientRequestFilter;
import org.jboss.resteasy.reactive.client.spi.ResteasyReactiveClientResponseFilter;

import java.util.Calendar;

@Provider
public class ClientFilter implements ResteasyReactiveClientRequestFilter, ResteasyReactiveClientResponseFilter {
    Calendar calendar = Calendar.getInstance();
    @Override
    public void filter(ResteasyReactiveClientRequestContext requestContext) {
        long time = calendar.getTimeInMillis();
        requestContext.setProperty("t0",time);
    }

    @Override
    public void filter(ResteasyReactiveClientRequestContext requestContext, ClientResponseContext responseContext) {
        long time = calendar.getTimeInMillis();
        long startingTime= (long) requestContext.getProperty("t0");
        System.out.println("RestEasy client response " + responseContext.getStatus());
        System.out.println("RestEasy Time is " +(time-startingTime)+" Milliseconds");
    }
}
