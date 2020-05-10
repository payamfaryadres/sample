FROM openjdk:8-jre-alpine                                           

ENV VERTICLE_FILE countme-fat.jar     

# Set the location of the verticles
ENV VERTICLE_HOME /usr/verticles

EXPOSE 80

# Copy your fat jar to the container
COPY $VERTICLE_FILE $VERTICLE_HOME/                          

# Launch the verticle
WORKDIR $VERTICLE_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -jar $VERTICLE_FILE"]  
