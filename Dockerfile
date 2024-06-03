# Usa una imagen base con Java
FROM openjdk:17

# Instala Maven
RUN apt-get update && apt-get install -y maven

# Establece el directorio de trabajo en /app
WORKDIR /app

# Copia los archivos del proyecto al contenedor
COPY . .

# Ejecuta el comando Maven para construir la aplicación
RUN mvn clean install

# Expone el puerto 8080 para acceder a la aplicación
EXPOSE 8080

# Ejecuta la aplicación al iniciar el contenedor
CMD ["java", "-jar", "demo/target/*.jar"]
