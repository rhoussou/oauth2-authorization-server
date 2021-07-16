FROM openjdk
MAINTAINER Roland Houssou <roc.houssou@gmail.com>
ADD deploy/*.jar /app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 5000
ENTRYPOINT ["java","-Dspring.profiles.active=docker","-jar","app.jar"]