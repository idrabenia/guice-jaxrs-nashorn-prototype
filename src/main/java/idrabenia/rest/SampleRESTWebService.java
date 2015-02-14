package idrabenia.rest;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.sun.jersey.spi.resource.Singleton;
import idrabenia.infrastructure.hibernate.UserDao;
import idrabenia.model.User;
import idrabenia.model.UserDetails;
import idrabenia.service.HelloService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.List;

@Singleton
@Path("hello")
@Produces("application/json")
public class SampleRESTWebService {

    @Inject
    @Named("hello.world.string")
    private String helloWorldString;

    @Inject
    private HelloService helloService;

    @Inject
    private UserDao userDao;

    @GET
    public Response helloWorld() {
        return Response.ok(helloWorldString + "\n").build();
    }

    @GET
    @Path("/{name}")
    public Response sayHello(@PathParam("name") String name) {
        return Response
                .ok(helloService.sayHello(name))
                .build();
    }

    @XmlRootElement
    public static class ResponseEntry {
        private List<User> value;

        public ResponseEntry() {
        }

        public ResponseEntry(List<User> value) {
            this.value = value;
        }

        public List<User> getValue() {
            return value;
        }

        public void setValue(List<User> value) {
            this.value = value;
        }
    }

    @GET
    @Path("/user")
    public Response users() throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("Nashorn");

        engine.eval(new InputStreamReader(SampleRESTWebService.class.getResourceAsStream("RestService.js")));

        Invocable invocable = (Invocable) engine;

        return (Response) invocable.invokeFunction("listUsers", userDao);
    }
}
