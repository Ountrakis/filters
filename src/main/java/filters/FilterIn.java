package filters;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.container.ContainerRequestContext;
import org.jboss.resteasy.reactive.server.ServerRequestFilter;

import java.util.Calendar;

@ApplicationScoped
public class FilterIn {
    @ServerRequestFilter(priority = 1)
    public Uni<Void> filterIn(ContainerRequestContext containerRequestContext){
        containerRequestContext.getHeaders()
                .keySet()
                .forEach(key-> System.out.println("Key " + key +" value "+containerRequestContext.getHeaders().get(key).get(0)));
        Calendar calendar = Calendar.getInstance();

        long time = calendar.getTimeInMillis();
        containerRequestContext.setProperty("t0",time);
        return Uni.createFrom().nullItem();
    }

}
