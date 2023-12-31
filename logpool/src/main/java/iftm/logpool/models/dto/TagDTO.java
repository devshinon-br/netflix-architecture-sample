package iftm.logpool.models.dto;

import java.io.Serializable;
import java.util.Objects;

public class TagDTO implements Serializable {
    private String name;

    public TagDTO() {
    }

    public TagDTO(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final TagDTO tagDTO = (TagDTO) o;
        return Objects.equals(name, tagDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "TagDTO{" + "name='" + name + '\'' + '}';
    }
}
