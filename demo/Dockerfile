FROM openjdk:17-jdk-alpine

# Instalar Maven
RUN apk add --no-cache maven

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el contenido del proyecto al contenedor
COPY . .

# Exponer el puerto 8080
EXPOSE 8080

# Construir la aplicación
RUN cd demo && mvn clean install -DskipTests

# Especificar el comando de inicio
CMD ["java", "-jar", "demo/target/demo-0.0.1-SNAPSHOT.jar"]
