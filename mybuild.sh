# react project build
cd ../prj2-react-20240521
npm run build

# index.html, main.js 복사(이동) : dist -> static
cd ../prj2-spring-20240521
rm -rf src/main/resources/static
mv ../prj2-react-20240521/dist src/main/resources/static

# spring project build
./gradlew bootJar

# build image
docker build -t sebaek/prj3 .

# push image
docker push sebaek/prj3

# remote 에서

# 컨테이너 멈추고
ssh -i src/main/resources/secret/key0527.pem ubuntu@13.209.74.178 'docker stop prj3'
# 컨테이너 삭제
ssh -i src/main/resources/secret/key0527.pem ubuntu@13.209.74.178 'docker rm prj3'
# pull image
ssh -i src/main/resources/secret/key0527.pem ubuntu@13.209.74.178 'docker pull sebaek/prj3'
# 컨테이너 실행
ssh -i src/main/resources/secret/key0527.pem ubuntu@13.209.74.178 'docker run -d -p 8080:8080 --restart always --name prj3 sebaek/prj3'
