package it.scp.resttemplate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserBean {
    private String userId;
    private String id;
    private String body;
    private String title;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString()
    {
        return "UserBean [userId=" + this.userId + ", id=" + this.id + ", body=" + this.body + ", title=" + this.title + "]";
    }

    public String toJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        String valueAsString = null;
        try {
            valueAsString = objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return valueAsString;
    }

}
