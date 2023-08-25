# eclipse-temurin because OpenJDK is deprecated
FROM eclipse-temurin:19.0.1_10-jdk-jammy

# create non-root user and group for security compliance
ARG THE_USER_ID=1001
ARG THE_GROUP_ID=1001
RUN \
  /usr/sbin/groupadd -g $THE_GROUP_ID spring && \
  /usr/sbin/useradd -l -u $THE_USER_ID -G spring -g $THE_GROUP_ID spring && \
  mkdir logs && chgrp spring logs && chmod ug+rwx logs

# run as non-root
USER spring:spring

# main port
EXPOSE 8090

COPY springBoot.jar springBoot.jar
CMD ["java","-jar","springBoot.jar"]
