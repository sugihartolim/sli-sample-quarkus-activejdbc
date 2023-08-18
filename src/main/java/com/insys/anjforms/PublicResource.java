package com.insys.anjforms;

import com.insys.anjforms.models.Template;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.javalite.activejdbc.DB;

import javax.sql.DataSource;
import java.util.List;

@Path("/api/public")
@PermitAll()
@Slf4j
public class PublicResource {
    @Inject
    DataSource datasource;

    @ConfigProperty(name = "insys.pagination.pageLength")
    public Integer defaultPageLength;

    @Path("/template")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Template> getTemplateList(@QueryParam("page") Integer page, @QueryParam("len") Integer len) {
        try (DB db = new DB()) {
            db.open(this.datasource);
            List<Template> list = Template.findAll().orderBy("template_id");
            return list;
        }
    }

}

