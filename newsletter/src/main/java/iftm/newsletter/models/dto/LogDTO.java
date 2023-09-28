package iftm.newsletter.models.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class LogDTO<T> implements Serializable {
    private String action;
    private Date date = new Date();
    private T object;
    private String objectType;

    public LogDTO() {
    }

    public LogDTO(final String action, final T object) {
        this.action = action;
        this.object = object;
        this.objectType = object.getClass().toString();
    }

    public String getAction() {
        return action;
    }

    public void setAction(final String action) {
        this.action = action;
    }

    public T getObject() {
        return object;
    }

    public void setObject(final T object) {
        this.object = object;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(final String objectType) {
        this.objectType = objectType;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogDTO<?> logDTO = (LogDTO<?>) o;
        return Objects.equals(action, logDTO.action) && Objects.equals(date, logDTO.date) && Objects.equals(object, logDTO.object) && Objects.equals(objectType, logDTO.objectType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(action, date, object, objectType);
    }

    @Override
    public String toString() {
        return "LogDTO{" +
            "action='" + action + '\'' +
            ", date=" + date +
            ", object=" + object +
            ", objectType='" + objectType + '\'' +
            '}';
    }
}
