FROM openjdk:8-jre
VOLUME /tmp

# 项目名
#ENV PRO_NAME="wyms"
# java启动参数
#ENV JAVA_OPTS="-server -Xms128m -Xmx1024m -Xss256k -XX:MaxDirectMemorySize=128m"
# 项目依赖
#ENV CLASSPATH="wyms/WEB-INF/classes:wyms/WEB-INF/WEB-INF/lib/*"
# 启动类
#ENV MAIN_CLASS=com.wxadt.wxcep.WxcepServerApplication
# 日志路径
#ENV LOG_PATH=""


# 复制项目代码到容器
COPY test/ /test
ENTRYPOINT ["java","-Duser.timezone=GMT+08","-Xmx1024m","-classpath","wyms/WEB-INF/classes:wyms/WEB-INF/lib/*","com.demo.BootApplication"]
