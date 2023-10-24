package iftm.newsletter.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class LogDTO<T> implements Serializable {
    private String action;
    private Date date = new Date();
    private T object;
    private String objectType;

    public LogDTO(final String action, final T object) {
        this.action = action;
        this.object = object;
        this.objectType = object.getClass().toString();
    }
}
