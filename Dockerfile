FROM azul/zulu-openjdk-alpine:11 AS builder

COPY . /app/source/
WORKDIR /app/source
RUN ./mvnw clean install package

FROM builder
WORKDIR /app
COPY --from=builder /app/source/target/tokenlab-challenge.jar /app/tokenlab-challenge.jar

CMD ["java", "-jar", "./tokenlab-challenge.jar"]