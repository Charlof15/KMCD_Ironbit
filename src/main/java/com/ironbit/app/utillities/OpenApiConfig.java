package com.ironbit.app.utillities;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.ironbit.app.entity.Empleado;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@OpenAPIDefinition(info = @Info(title = "${ironbi.api.title}",version = "${ironbi.api.version}",description = "${ironbi.api.description}",
contact = @Contact(name = "${ironbi.developer.name}",email = "${ironbi.developer.email}",url = "${ironbi.developer.url}")))
@ApiResponse(responseCode = "200", description = "Ejecución correcta", content = @Content(schema = @Schema(implementation = Empleado.class)))	
@ApiResponse(responseCode = "201", description = "Ejecución correcta", content = @Content(schema = @Schema(implementation = Empleado.class)))	
@ApiResponse(responseCode = "204", description = "No content")
@ApiResponse(responseCode = "401", description = "Sin permisos de acceso", content = @Content(schema = @Schema(implementation = Empleado.class)))		
@ApiResponse(responseCode = "403", description = "JWT no valido", content = @Content(schema = @Schema(implementation = Empleado.class)))
@ApiResponse(responseCode = "500", description = "Error en el servidor.", content = @Content(schema = @Schema(implementation = Empleado.class)))
public @interface OpenApiConfig {}