package fr.epita.configuration;

import java.util.Collections;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("")
public class AppConfig extends Application{
	
	public Set<Class<?>> getClasses(){
		return Collections.emptySet();
	}

}
