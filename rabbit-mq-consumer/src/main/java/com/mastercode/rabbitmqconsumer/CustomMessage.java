package com.mastercode.rabbitmqconsumer;

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
        CustomMessage that = (CustomMessage) o;
        return Objects.equals(messageId, that.messageId) && Objects.equals(message, that.message)
                && Objects.equals(messageDate, that.messageDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, message, messageDate);
    }
}
