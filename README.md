# bizweb
소스코드 작성 위치 : src/main/java/com/bizweb 하위
로컬 실행 설정 : src\main\resources\application-local.yml

#############################################
90번 서버 Mysql Docker 설치 --> mysql docker(13306)
#############################################
[root@va /home/docker ]$ docker images
REPOSITORY          TAG                 IMAGE ID            CREATED             SIZE
mysql               latest              fcd86ff8ce8c        5 weeks ago         577.9 MB

[root@va /home/docker ]$ docker ps
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS                                NAMES
3892e78af340        mysql:latest        "docker-entrypoint.sh"   4 minutes ago       Up 3 minutes        33060/tcp, 0.0.0.0:13306->3306/tcp   mysql
[root@va /home/docker ]$

#############################################
mysql docker bizweb 계정 및 schema 생성
#############################################
mysql -u root -p
CREATE DATABASE bizweb;
CREATE USER bizweb@'%' IDENTIFIED BY 'bizweb';
GRANT ALL PRIVILEGES ON bizweb.* TO bizweb@'%';
FLUSH PRIVILEGES; #권한 적용을 서버에 반영

#############################################
bizweb 계정 접속 정보
#############################################
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://192.168.1.90:13306/bizweb?serverTimezone=UTC
spring.datasource.username=bizweb
spring.datasource.password=bizweb
#############################################
mysql docker image down + containfer 실행
#############################################
docker pull mysql
docker run --name mysql -p 13306:3306 -v /home/docker/mysql:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=root -d mysql:latest
