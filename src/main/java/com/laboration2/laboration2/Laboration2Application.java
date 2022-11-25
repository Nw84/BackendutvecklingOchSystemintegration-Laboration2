package com.laboration2.laboration2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.geolatte.geom.json.GeolatteGeomModule;


@SpringBootApplication
public class Laboration2Application {

	public static void main(String[] args) {
		SpringApplication.run(Laboration2Application.class, args);
	}


	@Bean
    GeolatteGeomModule geolatteGeomModule() {
        return new GeolatteGeomModule();
    }

}
