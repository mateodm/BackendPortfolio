
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

# Utiliza una imagen base de Java
FROM amazoncorreto:11-alpine-jdk
MAINTAINER portfolio
COPY target/portfolio-0.0.1-SNAPSHOT.jar portfolio-app.jar
CMD ["java", "-jar", "portfolio-app.jar"]