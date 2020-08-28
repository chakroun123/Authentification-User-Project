package org.management.security;

public interface SecurityParam {
    public  final  String JWT_HEARDER_NAME = "Autorization";
    public  final  String SECRET = "ahmed@chakroun.net";
    public  final  long EXPIRATION = 10*24*3600;
    public  final  String HEADER_PREFIX = "Bearer ";
}
