package com.insys.anjforms;

import io.quarkus.logging.Log;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.javalite.activejdbc.Base;

import javax.sql.DataSource;

@QuarkusMain
public class Main {
    public static void main(String... args) {
        Quarkus.run(MyApp.class, args);
    }

    @Slf4j
    public static class MyApp implements QuarkusApplication {

        @Inject
        DataSource datasource;

        @Override
        public int run(String... args) throws Exception {
            Log.debug("Connecting to Database");
            Base.open(this.datasource);
            Log.debug("Connect OK.");


            Quarkus.waitForExit();
            return 0;
        }
    }
}