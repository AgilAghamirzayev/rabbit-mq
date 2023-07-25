package com.mastercode.rabbitmq;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CustomMessage implements Serializable {
    @Serial
    private static final long serialVersionUID = 632672158751632132L;
    private String messageId;
    private String message;
    private LocalDateTime messageDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomMessage message1 = (CustomMessage) o;
        return Objects.equals(messageId, message1.messageId) && Objects.equals(message, message1.message) &&
                Objects.equals(messageDate, message1.messageDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, message, messageDate);
    }
}
