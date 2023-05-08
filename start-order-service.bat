docker-compose down 
docker-compose up -d
start cmd.exe @cmd /k ".\start-web-server.bat"
.\start-kafka-consumer.bat