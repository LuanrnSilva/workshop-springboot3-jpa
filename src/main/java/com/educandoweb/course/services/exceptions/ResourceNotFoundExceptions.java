package com.educandoweb.course.services.exceptions;

public class ResourceNotFoundExceptions extends RuntimeException {

    public ResourceNotFoundExceptions(Object id) {
        super("Resource not found. Id " + id);
    }
}
