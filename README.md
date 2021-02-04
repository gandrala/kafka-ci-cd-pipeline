# kafka-starter-confluent
kafka-topics.sh  --bootstrap-server localhost:29092 --list

kafka-topics.sh  --bootstrap-server localhost:29092 --delete --topic users

kafka-topics.sh  --bootstrap-server localhost:29092 --create --topic users --partitions 3 --replication-factor 1

kafka-console-producer.sh --bootstrap-server localhost:29092 --topic users --property parse.key=true --property key.separator=":"

Sample Data
1:Joe
2:Boon

 kafka-console-consumer.sh --bootstrap-server localhost:29092 --topic employees --from-beginning

eclipse run maven
/Library/Java/JavaVirtualMachines/jdk-13.0.1.jdk/Contents/Home/bin/java -Dfile.encoding=UTF-8 -classpath /Users/subbugandrala/Documents/Work/code/basic-kafka/target/classes:/Users/subbugandrala/.m2/repository/org/apache/kafka/kafka-clients/2.6.0/kafka-clients-2.6.0.jar:/Users/subbugandrala/.m2/repository/com/github/luben/zstd-jni/1.4.4-7/zstd-jni-1.4.4-7.jar:/Users/subbugandrala/.m2/repository/org/lz4/lz4-java/1.7.1/lz4-java-1.7.1.jar:/Users/subbugandrala/.m2/repository/org/xerial/snappy/snappy-java/1.1.7.3/snappy-java-1.1.7.3.jar:/Users/subbugandrala/.m2/repository/org/slf4j/slf4j-api/1.7.30/slf4j-api-1.7.30.jar:/Users/subbugandrala/.m2/repository/org/slf4j/slf4j-simple/1.7.26/slf4j-simple-1.7.26.jar:/Users/subbugandrala/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.11.3/jackson-databind-2.11.3.jar:/Users/subbugandrala/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.11.3/jackson-annotations-2.11.3.jar:/Users/subbugandrala/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.11.3/jackson-core-2.11.3.jar com.kafka.local.Consumer
