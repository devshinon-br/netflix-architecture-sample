package iftm.logpool.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Objects;

@Document(collection = "newsletterLogs")
public class Log<T> {
    @Id
    private String id;
    private String action;
    private Date date = new Date();
    private T object;
    private String classType;

    public Log() {
    }

    public Log(final String action, final Date date, final T object, final String classType) {
        this.action = action;
        this.date = date;
        this.object = object;
        this.classType = classType;
    }

    public Log(final String id, final String action, final Date date, final T object, final String classType) {
        this.id = id;
        this.action = action;
        this.date = date;
        this.object = object;
        this.classType = classType;
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
        final Log<?> log = (Log<?>) o;
        return Objects.equals(id, log.id) && Objects.equals(action, log.action) && Objects.equals(date, log.date) && Objects.equals(object, log.object) && Objects.equals(classType, log.classType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, action, date, object, classType);
    }

    @Override
    public String toString() {
        return "Log{" + "id='" + id + '\'' + ", action='" + action + '\'' + ", date=" + date + ", object=" + object + ", classType='" + classType + '\'' + '}';
    }
}
