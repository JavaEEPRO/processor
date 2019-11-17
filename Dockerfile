FROM openjdk:11-jdk
ADD ./target/processor.jar /processor.jar
ENTRYPOINT ["java","-jar","/processor.jar"]