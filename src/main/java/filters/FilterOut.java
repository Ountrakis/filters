package filters;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import org.jboss.resteasy.reactive.server.ServerResponseFilter;

import java.util.Calendar;

@ApplicationScoped
public class FilterOut {

    @ServerResponseFilter(priority = 1)
    public Uni<Void> filterOut(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext){
        Calendar calendar = Calendar.getInstance();
        long time = calendar.getTimeInMillis();
        long startingTime= (long) containerRequestContext.getProperty("t0");
        System.out.println("I delayed: " +(time-startingTime)+" Milliseconds and my status is : " +containerResponseContext.getStatus());
        return Uni.createFrom().nullItem();
    }
}
