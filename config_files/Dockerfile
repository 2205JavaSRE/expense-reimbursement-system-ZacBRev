FROM maven:3.8.5-openjdk-8 as BUILD_STAGE

COPY ./ ./

RUN mvn clean package

FROM openjdk:8-jre

COPY --from=BUILD_STAGE /target/expense-reimbursement-system-ZacBRev-1.0-SNAPSHOT-jar-with-dependencies.jar /expense.jar

ENV db_url=[REDACTED]
ENV db_username=[REDACTED]
ENV db_password=[REDACTED]


CMD ["java", "-jar", "expense.jar"]
