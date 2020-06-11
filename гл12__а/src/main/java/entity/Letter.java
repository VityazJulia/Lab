package entity;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Letter {
    String sender;
    String recipient;
    String topic;
    String text;
    Date sendDate;

    public Letter(String sender, String recipient, String topic, String text, Date sendDate) {
        this.sender = sender;
        this.recipient = recipient;
        this.topic = topic;
        this.text = text;
        this.sendDate = sendDate;
    }

    public Letter() {
        this("noname", "noname","notopic","notext", new Date());
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getTopic() {
        return topic;
    }

    public String getText() {
        return text;
    }

    public String getSQLDate() {
        LocalDate localDate = this.sendDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return new StringBuilder()
                .append(localDate.getYear())
                .append("-")
                .append(localDate.getMonthValue())
                .append("-")
                .append(localDate.getDayOfMonth()).toString();
    }

    @Override
    public String toString() {
        return  "sender: " + sender +
                ", recipient: " + recipient +
                ", topic: " + topic + '\'' +
                ", text: " + text + '\'' +
                ", sendDate: " + sendDate ;
    }
}
