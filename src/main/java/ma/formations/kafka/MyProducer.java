package ma.formations.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class MyProducer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092"); // Adresse du cluster Kafka
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("acks", "all"); // Garantir que les données sont confirmées par Kafka

        Producer<String, String> producer = new KafkaProducer<>(props);

        try {
            int i = 1;
            String message = "Message " + (i + 1);
            // Création du message à envoyer
            ProducerRecord<String, String> record = new ProducerRecord<>("my-first-topic", Integer.toString(i), message);
            // Envoi du message
            producer.send(record);
            System.out.println("Message envoyé : clé = " + i + ", valeur = " + message);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fermeture du producteur
            producer.close();
        }
    }

}

