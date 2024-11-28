# Define la imagen base de Java
FROM openjdk:latest
# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app
# Copia los archivos .java al contenedor (suponiendo que los archivos están en la misma carpeta que el Dockerfile)
COPY . /app
# Compila los archivos Java
RUN javac *.java
# Expone el puerto 1099 para la comunicación RMI (puedes usar otro puerto si es necesario)
EXPOSE 1099
# Inicia el servidor RMI al ejecutar el contenedor
CMD ["java", "ServidorRMI"]