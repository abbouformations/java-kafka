- Start Kafka using Docker :
  docker run -p 9092:9092 apache/kafka:3.9.0

- Create a topic :
  
  docker ps
  
  docker exec -it [A REMPLACER PAR LE VOTRE] /bin/bash
  
cd /opt/kafka/bin

sh kafka-topics.sh --bootstrap-server localhost:9092 --create --topic my-first-topic --partitions 1 --replication-factor 1

- Producce a message :
  sh kafka-console-producer.sh --bootstrap-server localhost:9092 --topic my-first-topic

- Consume a message :
sh kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic my-first-topic --from-beginning


![image](https://github.com/user-attachments/assets/46295004-7984-459f-8b60-57866b29bdeb)
