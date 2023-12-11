FROM amazoncorretto:17

#Copia a aplicacao pro container
COPY target/gid.jar gid.jar

#Copia o java.security modificado, desabilitando o TLS1.0 para substituir o original. 
#Necessario para utilizar o SQL Server 2012+ 
ADD .dockerfile/java.security ${JAVA_HOME}/conf/security/java.security

#Habilita a imagem para utilizar a porta 8080 
EXPOSE 8080

#executa a aplicacao
CMD ["java", "-jar", "/gid.jar"]

#docker run -p 8080:8080 gid