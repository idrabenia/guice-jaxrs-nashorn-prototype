package idrabenia.servlet.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Scope;
import com.google.inject.Scopes;
import idrabenia.service.HelloService;

/**
 * Created by ilya on 10/18/14.
 */
public class ServicesModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(HelloService.class);
    }
}
