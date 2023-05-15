
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

# Utiliza una imagen base de Java
FROM openjdk:11

# Establece el directorio de trabajo en la raíz de la aplicación
WORKDIR /app

# Copia los archivos de la aplicación al contenedor
COPY . /app

# Ejecuta el comando de compilación o construcción de tu aplicación
RUN ./gradlew build

# Expone el puerto en el que se ejecuta la aplicación
EXPOSE 8080

# Define el comando para ejecutar la aplicación cuando se inicie el contenedor
CMD ["java", "-jar", "target\portfolio-0.0.1-SNAPSHOT.jar"]