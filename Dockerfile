FROM open-liberty:javaee8-java12

COPY target/russia.war /config/dropins/
