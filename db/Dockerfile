# Use the latest MySQL image
FROM mysql
# Set the working directory
WORKDIR /tmp
COPY world.sql /docker-entrypoint-initdb.d
# Set the root password
ENV MYSQL_ROOT_PASSWORD Coursework