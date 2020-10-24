package com.example.gipsg.search.dao;

import com.example.gipsg.search.dto.ProfileGroupInfoDto;
import com.example.gipsg.search.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ProfileDao {

    @Autowired
    HttpSession session;

    public List<User> getUsers() {
        Object userList = session.getAttribute("userDB");
        if (Objects.isNull(userList)) {
            String json = getAllUserByJson();
            try {
                userList = new ObjectMapper().readValue(json, new TypeReference<List<User>>() {
                });
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return (List<User>) userList;
    }

    public void saveUsers(List<User> userList) {
        session.setAttribute("userDB", userList);
    }

    private String getAllUserByJson() {
        return "[{\"id\":\"1\", \"name\":\"shuyeah\", \"nationality\":\"Japan\", \"office\":\"Singapore\", \"hobby\":\"Workout\"},"
                + "{\"id\":\"2\", \"name\":\"Nook\", \"nationality\":\"Singapore\", \"office\":\"Singapore\", \"hobby\":\"Buffet\"},"
                + "{\"id\":\"3\", \"name\":\"Sowei\", \"nationality\":\"China\", \"office\":\"Singapore\", \"hobby\":\"\"},"
                + "{\"id\":\"4\", \"name\":\"Dave\", \"nationality\":\"Sweden\", \"office\":\"Singapore\", \"hobby\":\"KoreanDrama\"},"
                + "{\"id\":\"5\", \"name\":\"Kick\", \"nationality\":\"Singapore\", \"office\":\"Singapore\", \"hobby\":\"\"},"
                + "{\"id\":\"6\", \"name\":\"Pearl\", \"nationality\":\"Singapore\", \"office\":\"Singapore\", \"hobby\":\"\"},"
                + "{\"id\":\"7\", \"name\":\"Shirah\", \"nationality\":\"Japan\", \"office\":\"Tokyo\", \"hobby\":\"\"},"
                + "{\"id\":\"8\", \"name\":\"Alexis\", \"nationality\":\"Belgium\", \"office\":\"Tokyo\", \"hobby\":\"\"},"
                + "{\"id\":\"9\", \"name\":\"Neehaa\", \"nationality\":\"India\", \"office\":\"Tokyo\", \"hobby\":\"\"}]";
    }

    public List<ProfileGroupInfoDto> getProfilesById(String id) {
        Object profileList = new Object();
        String json = "";
        if (id.equals("1")) {
            json = getProfile1Json();
        }
        try {
            profileList = new ObjectMapper().readValue(json, new TypeReference<List<ProfileGroupInfoDto>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return (List<ProfileGroupInfoDto>) profileList;
    }

    private String getProfile1Json() {
        return "[" +
                "{" +
                "\"id\": 2401" +
                "}," +
                "{" +
                "\"id\": 2526" +
                "}]";
    }


}
