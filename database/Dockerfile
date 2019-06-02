# Versao mysql 5
FROM mysql:5

# Inserindo dados do banco
ENV MYSQL_ROOT_PASSWORD 1234 
ENV MYSQL_DATABASE users  
# ENV MYSQL_USER user_data  
# ENV MYSQL_PASSWORD 1234

ADD users.csv /docker-entrypoint-initdb.d
ADD setup.sql /docker-entrypoint-initdb.d
