# kafka-starter-confluent
kafka-topics.sh  --bootstrap-server localhost:29092 --list

kafka-topics.sh  --bootstrap-server localhost:29092 --delete --topic users

kafka-topics.sh  --bootstrap-server localhost:29092 --create --topic users --partitions 3 --replication-factor 1

kafka-console-producer.sh --bootstrap-server localhost:29092 --topic users --property parse.key=true --property key.separator=":"

Sample Data
1:Joe
2:Boon

 kafka-console-consumer.sh --bootstrap-server localhost:29092 --topic employees --from-beginning
