#!/bin/sh
echo -------------------------------------------
echo starting test
echo -------------------------------------------

# ----------- 下面这些参数与项目有关，不同项目不同配置 --------------
# 这里定义项目名称
proName="test"
# 这里定义运行的端口(需要与application.yml中配置的一致)
runPort=81


# ----------- 下面的是公共参数，一般不需要改动 --------------
# 容器名字：全小写的项目名（docker限制，不允许大写）
conName=$(echo $proName | tr '[A-Z]' '[a-z]')

# 打包镜像（Dockerfile和脚本在相同目录下）
docker build -t test/$conName -f ~/workspace/$proName/target/$proName/bin/Dockerfile ~/workspace/$proName/target/

# 重启容器
docker stop $conName
docker rm $conName
docker rmi $(docker images | grep "none" | awk '{print $3}')
docker run --name $conName -d -p $runPort:$runPort test/$conName