package iftm.logpool.models.dto;

import iftm.logpool.models.Log;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class LogDTO<T> implements Serializable {
    private String id;
    private String action;
    private Date date = new Date();
    private T object;
    private String classType;

    public LogDTO() {
    }

    public LogDTO(final String action, final T object, final String classType) {
        this.action = action;
        this.object = object;
        this.classType = classType;
    }

    public LogDTO(final Log log) {
        this.id = log.getId();
        this.action = log.getAction();
        this.date = log.getDate();
        this.object = (T) log.getObject();
        this.classType = log.getClassType();
    }

    public Log toLog() {
        var log = new Log<T>();
        log.setAction(this.action);
        log.setDate(this.date);
        log.setObject(this.object);

        if (this.id != null && !this.id.isBlank()) log.setId(this.id);

        if (this.classType != null && !this.classType.isBlank()) log.setClassType(this.classType);

        return log;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(final String action) {
        this.action = action;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

    public T getObject() {
        return object;
    }

    public void setObject(final T object) {
        this.object = object;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(final String classType) {
        this.classType = classType;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogDTO<?> logDTO = (LogDTO<?>) o;
        return Objects.equals(id, logDTO.id) && Objects.equals(action, logDTO.action) && Objects.equals(date, logDTO.date) && Objects.equals(object, logDTO.object) && Objects.equals(classType, logDTO.classType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, action, date, object, classType);
    }

    @Override
    public String toString() {
        return "LogDTO{" + "id='" + id + '\'' + ", action='" + action + '\'' + ", date=" + date + ", object=" + object + ", objectType='" + classType + '\'' + '}';
    }
}