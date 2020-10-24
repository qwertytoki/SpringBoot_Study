package com.example.gipsg.search.dao;

import com.example.gipsg.search.dto.AnswerOptionsDto;
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
        return "[\n" +
                "      {\n" +
                "        \"id\": 2401,\n" +
                "        \"attributeId\": 23,\n" +
                "        \"mainQuestionFlg\": true,\n" +
                "        \"mainQuestionId\": -1,\n" +
                "        \"question\": \"Marital Status\",\n" +
                "        \"values\": [\"1\"],\n" +
                "        \"fieldType\": 3,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          { \"id\": \"17230\", \"value\": \"1\", \"answer\": \"Single\" },\n" +
                "          { \"id\": \"17231\", \"value\": \"2\", \"answer\": \"Married\" },\n" +
                "          {\n" +
                "            \"id\": \"17232\",\n" +
                "            \"value\": \"3\",\n" +
                "            \"answer\": \"Divorced / Widowed / Widower / Separated\"\n" +
                "          }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"ma\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 2526,\n" +
                "        \"attributeId\": 25,\n" +
                "        \"mainQuestionFlg\": true,\n" +
                "        \"mainQuestionId\": -1,\n" +
                "        \"question\": \"Employment Status\",\n" +
                "        \"values\": [\"1\"],\n" +
                "        \"fieldType\": 3,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          { \"id\": \"17275\", \"value\": \"1\", \"answer\": \"Full time\" },\n" +
                "          { \"id\": \"17276\", \"value\": \"2\", \"answer\": \"Part time\" },\n" +
                "          { \"id\": \"17277\", \"value\": \"3\", \"answer\": \"Self employed\" },\n" +
                "          { \"id\": \"17278\", \"value\": \"4\", \"answer\": \"Freelance\" },\n" +
                "          { \"id\": \"17279\", \"value\": \"5\", \"answer\": \"Student\" },\n" +
                "          { \"id\": \"17280\", \"value\": \"6\", \"answer\": \"Home Maker\" },\n" +
                "          { \"id\": \"17281\", \"value\": \"7\", \"answer\": \"Retired\" },\n" +
                "          { \"id\": \"17282\", \"value\": \"8\", \"answer\": \"Not employed\" },\n" +
                "          { \"id\": \"17283\", \"value\": \"99\", \"answer\": \"Other\" }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"occ\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 2601,\n" +
                "        \"attributeId\": 26,\n" +
                "        \"mainQuestionFlg\": true,\n" +
                "        \"mainQuestionId\": -1,\n" +
                "        \"question\": \"Industry\",\n" +
                "        \"values\": [\"19\"],\n" +
                "        \"fieldType\": 3,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          {\n" +
                "            \"id\": \"17319\",\n" +
                "            \"value\": \"1\",\n" +
                "            \"answer\": \"Agriculture / Forestry / Fishing / Mining \"\n" +
                "          },\n" +
                "          { \"id\": \"17320\", \"value\": \"2\", \"answer\": \"Construction \" },\n" +
                "          {\n" +
                "            \"id\": \"17321\",\n" +
                "            \"value\": \"3\",\n" +
                "            \"answer\": \"Manufacturing (Foods / Beverages (excluding liquor)) \"\n" +
                "          },\n" +
                "          { \"id\": \"17322\", \"value\": \"4\", \"answer\": \"Manufacturing (Liquor) \" },\n" +
                "          {\n" +
                "            \"id\": \"17323\",\n" +
                "            \"value\": \"5\",\n" +
                "            \"answer\": \"Manufacturing (Apparel / Textile) \"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17324\",\n" +
                "            \"value\": \"6\",\n" +
                "            \"answer\": \"Manufacturing (Furniture / Equipment)\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17325\",\n" +
                "            \"value\": \"7\",\n" +
                "            \"answer\": \"Manufacturing (Pharmaceuticals / Cosmetics / Daily necessities) \"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17326\",\n" +
                "            \"value\": \"8\",\n" +
                "            \"answer\": \"Manufacturing (Petroleum products) \"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17327\",\n" +
                "            \"value\": \"9\",\n" +
                "            \"answer\": \"Manufacturing (AV/Consumer electronics / Electric machinery and apparatus) \"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17328\",\n" +
                "            \"value\": \"10\",\n" +
                "            \"answer\": \"Manufacturing (Automobiles / Transport machinery) \"\n" +
                "          },\n" +
                "          { \"id\": \"17329\", \"value\": \"11\", \"answer\": \"Manufacturing (Others) \" },\n" +
                "          { \"id\": \"17330\", \"value\": \"12\", \"answer\": \"Mining / Quarrying\" },\n" +
                "          { \"id\": \"17331\", \"value\": \"13\", \"answer\": \"Publishing / Printing \" },\n" +
                "          {\n" +
                "            \"id\": \"17332\",\n" +
                "            \"value\": \"14\",\n" +
                "            \"answer\": \"Public Utilities (Electric / Gas / Energy / Water supply)\"\n" +
                "          },\n" +
                "          { \"id\": \"17333\", \"value\": \"15\", \"answer\": \"Transport / Logistics\" },\n" +
                "          { \"id\": \"17334\", \"value\": \"16\", \"answer\": \"Aviation-related\" },\n" +
                "          { \"id\": \"17335\", \"value\": \"17\", \"answer\": \"Travel / Hotels\" },\n" +
                "          { \"id\": \"17336\", \"value\": \"18\", \"answer\": \"Telecommunications \" },\n" +
                "          { \"id\": \"17337\", \"value\": \"19\", \"answer\": \"IT\" },\n" +
                "          {\n" +
                "            \"id\": \"17338\",\n" +
                "            \"value\": \"20\",\n" +
                "            \"answer\": \"Wholesale / Retail (Foods / Beverages)\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17339\",\n" +
                "            \"value\": \"21\",\n" +
                "            \"answer\": \"Wholesale / Retail (Apparel / textile) \"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17340\",\n" +
                "            \"value\": \"22\",\n" +
                "            \"answer\": \"Wholesale / Retail (Furniture / Equipment)\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17341\",\n" +
                "            \"value\": \"23\",\n" +
                "            \"answer\": \"Wholesale / Retail (Pharmaceuticals / Cosmetics / Daily necessities) \"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17342\",\n" +
                "            \"value\": \"24\",\n" +
                "            \"answer\": \"Wholesale / Retail (AV / Consumer electronics / Electric machinery and apparatus) \"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17343\",\n" +
                "            \"value\": \"25\",\n" +
                "            \"answer\": \"Wholesale / Retail (Automobiles / Transport machinery) \"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17344\",\n" +
                "            \"value\": \"26\",\n" +
                "            \"answer\": \"Wholesale / Retail (Book / Stationery) \"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17345\",\n" +
                "            \"value\": \"27\",\n" +
                "            \"answer\": \"Wholesale / Retail (Department store / Supermarket / Convenience store)\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17346\",\n" +
                "            \"value\": \"28\",\n" +
                "            \"answer\": \"Wholesale / Retail (Others) \"\n" +
                "          },\n" +
                "          { \"id\": \"17347\", \"value\": \"29\", \"answer\": \"Merchants and traders\" },\n" +
                "          { \"id\": \"17348\", \"value\": \"30\", \"answer\": \"Restaurants\" },\n" +
                "          { \"id\": \"17349\", \"value\": \"31\", \"answer\": \"Financing / Banking\" },\n" +
                "          { \"id\": \"17350\", \"value\": \"32\", \"answer\": \"Insurance \" },\n" +
                "          { \"id\": \"17351\", \"value\": \"33\", \"answer\": \"Real Estate \" },\n" +
                "          {\n" +
                "            \"id\": \"17352\",\n" +
                "            \"value\": \"34\",\n" +
                "            \"answer\": \"Service (Hospitality / Entertainment) \"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17353\",\n" +
                "            \"value\": \"35\",\n" +
                "            \"answer\": \"Service (Leasing / Renting)\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17354\",\n" +
                "            \"value\": \"36\",\n" +
                "            \"answer\": \"Service (Cleaner / Barber / Beauty shop)\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17355\",\n" +
                "            \"value\": \"37\",\n" +
                "            \"answer\": \"Service (Software / Information service )\"\n" +
                "          },\n" +
                "          { \"id\": \"17356\", \"value\": \"38\", \"answer\": \"Service (Others) \" },\n" +
                "          { \"id\": \"17357\", \"value\": \"39\", \"answer\": \"Medical / Healthcare\" },\n" +
                "          { \"id\": \"17358\", \"value\": \"40\", \"answer\": \"Medical technician \" },\n" +
                "          {\n" +
                "            \"id\": \"17359\",\n" +
                "            \"value\": \"41\",\n" +
                "            \"answer\": \"Community / Social & personal services\"\n" +
                "          },\n" +
                "          { \"id\": \"17360\", \"value\": \"42\", \"answer\": \"Education\" },\n" +
                "          { \"id\": \"17361\", \"value\": \"43\", \"answer\": \"Government / Public\" },\n" +
                "          { \"id\": \"17362\", \"value\": \"44\", \"answer\": \"Media / Journalism\" },\n" +
                "          {\n" +
                "            \"id\": \"17363\",\n" +
                "            \"value\": \"45\",\n" +
                "            \"answer\": \"Market Research / Advertising / Public Relations\"\n" +
                "          },\n" +
                "          { \"id\": \"17364\", \"value\": \"99\", \"answer\": \"Other\" }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"ind\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 2476,\n" +
                "        \"attributeId\": 27,\n" +
                "        \"mainQuestionFlg\": true,\n" +
                "        \"mainQuestionId\": -1,\n" +
                "        \"question\": \"Annual Personal Income (Total)\",\n" +
                "        \"values\": [\"5\"],\n" +
                "        \"fieldType\": 3,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          {\n" +
                "            \"id\": \"17248\",\n" +
                "            \"value\": \"10\",\n" +
                "            \"answer\": \" 100,001 to 150,000 Singapore dollars\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17249\",\n" +
                "            \"value\": \"11\",\n" +
                "            \"answer\": \" 150,001 to 250,000 Singapore dollars\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17250\",\n" +
                "            \"value\": \"12\",\n" +
                "            \"answer\": \" 250,001 to 350,000 Singapore dollars\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17251\",\n" +
                "            \"value\": \"13\",\n" +
                "            \"answer\": \" 350,000 Singapore dollars or above\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17252\",\n" +
                "            \"value\": \"1\",\n" +
                "            \"answer\": \"Less than 20,000 Singapore dollars\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17253\",\n" +
                "            \"value\": \"2\",\n" +
                "            \"answer\": \" 20,001 to 30,000 Singapore dollars\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17254\",\n" +
                "            \"value\": \"3\",\n" +
                "            \"answer\": \" 30,001 to 40,000 Singapore dollars\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17255\",\n" +
                "            \"value\": \"4\",\n" +
                "            \"answer\": \" 40,001 to 50,000 Singapore dollars\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17256\",\n" +
                "            \"value\": \"5\",\n" +
                "            \"answer\": \" 50,001 to 60,000 Singapore dollars\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17257\",\n" +
                "            \"value\": \"6\",\n" +
                "            \"answer\": \" 60,001 to 70,000 Singapore dollars\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17258\",\n" +
                "            \"value\": \"7\",\n" +
                "            \"answer\": \" 70,001 to 80,000 Singapore dollars\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17259\",\n" +
                "            \"value\": \"8\",\n" +
                "            \"answer\": \" 80,001 to 90,000 Singapore dollars\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17260\",\n" +
                "            \"value\": \"9\",\n" +
                "            \"answer\": \" 90,001 to 100,000 Singapore dollars\"\n" +
                "          }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"p_in\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 2626,\n" +
                "        \"attributeId\": 28,\n" +
                "        \"mainQuestionFlg\": true,\n" +
                "        \"mainQuestionId\": -1,\n" +
                "        \"question\": \"Annual Household Income (Total)\",\n" +
                "        \"values\": [\"5\"],\n" +
                "        \"fieldType\": 3,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          {\n" +
                "            \"id\": \"17261\",\n" +
                "            \"value\": \"10\",\n" +
                "            \"answer\": \" 100,001 to 150,000 Singapore dollars\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17262\",\n" +
                "            \"value\": \"11\",\n" +
                "            \"answer\": \" 150,001 to 250,000 Singapore dollars\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17263\",\n" +
                "            \"value\": \"12\",\n" +
                "            \"answer\": \" 250,001 to 350,000 Singapore dollars\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17264\",\n" +
                "            \"value\": \"13\",\n" +
                "            \"answer\": \" 350,000 Singapore dollars or above\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17265\",\n" +
                "            \"value\": \"1\",\n" +
                "            \"answer\": \"Less than 20,000 Singapore dollars\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17266\",\n" +
                "            \"value\": \"2\",\n" +
                "            \"answer\": \" 20,001 to 30,000 Singapore dollars\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17267\",\n" +
                "            \"value\": \"3\",\n" +
                "            \"answer\": \" 30,001 to 40,000 Singapore dollars\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17268\",\n" +
                "            \"value\": \"4\",\n" +
                "            \"answer\": \" 40,001 to 50,000 Singapore dollars\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17269\",\n" +
                "            \"value\": \"5\",\n" +
                "            \"answer\": \" 50,001 to 60,000 Singapore dollars\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17270\",\n" +
                "            \"value\": \"6\",\n" +
                "            \"answer\": \" 60,001 to 70,000 Singapore dollars\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17271\",\n" +
                "            \"value\": \"7\",\n" +
                "            \"answer\": \" 70,001 to 80,000 Singapore dollars\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17272\",\n" +
                "            \"value\": \"8\",\n" +
                "            \"answer\": \" 80,001 to 90,000 Singapore dollars\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17273\",\n" +
                "            \"value\": \"9\",\n" +
                "            \"answer\": \" 90,001 to 100,000 Singapore dollars\"\n" +
                "          },\n" +
                "          { \"id\": \"17274\", \"value\": \"99\", \"answer\": \"I do not know\" }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"h_in\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 2451,\n" +
                "        \"attributeId\": 29,\n" +
                "        \"mainQuestionFlg\": true,\n" +
                "        \"mainQuestionId\": -1,\n" +
                "        \"question\": \"Education\",\n" +
                "        \"values\": [\"99\"],\n" +
                "        \"fieldType\": 3,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          { \"id\": \"17238\", \"value\": \"9\", \"answer\": \"Postgraduate Diploma\" },\n" +
                "          { \"id\": \"17239\", \"value\": \"1\", \"answer\": \"Primary School or lower\" },\n" +
                "          { \"id\": \"17240\", \"value\": \"2\", \"answer\": \"Secondary School\" },\n" +
                "          { \"id\": \"17241\", \"value\": \"3\", \"answer\": \"Polytechnic\" },\n" +
                "          { \"id\": \"17242\", \"value\": \"4\", \"answer\": \"Vocational Course (ITE)\" },\n" +
                "          { \"id\": \"17243\", \"value\": \"5\", \"answer\": \"Junior College\" },\n" +
                "          { \"id\": \"17244\", \"value\": \"6\", \"answer\": \"University\" },\n" +
                "          { \"id\": \"17245\", \"value\": \"7\", \"answer\": \"Masters Degree\" },\n" +
                "          { \"id\": \"17246\", \"value\": \"8\", \"answer\": \"Doctoral Degree\" },\n" +
                "          { \"id\": \"17247\", \"value\": \"99\", \"answer\": \"Other\" }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"edu\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 2551,\n" +
                "        \"attributeId\": 30,\n" +
                "        \"mainQuestionFlg\": true,\n" +
                "        \"mainQuestionId\": -1,\n" +
                "        \"question\": \"Job Function\",\n" +
                "        \"values\": [\"14\"],\n" +
                "        \"fieldType\": 3,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          {\n" +
                "            \"id\": \"17284\",\n" +
                "            \"value\": \"1\",\n" +
                "            \"answer\": \"Executive / Owner/General Management\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17285\",\n" +
                "            \"value\": \"2\",\n" +
                "            \"answer\": \"Business/Strategic Planning, Management\"\n" +
                "          },\n" +
                "          { \"id\": \"17286\", \"value\": \"3\", \"answer\": \"Accounting / Finance\" },\n" +
                "          { \"id\": \"17287\", \"value\": \"4\", \"answer\": \"Administrative/Clerical\" },\n" +
                "          { \"id\": \"17288\", \"value\": \"5\", \"answer\": \"Human Resources\" },\n" +
                "          { \"id\": \"17289\", \"value\": \"6\", \"answer\": \"Legal\" },\n" +
                "          { \"id\": \"17290\", \"value\": \"7\", \"answer\": \"Consulting / Advisory\" },\n" +
                "          {\n" +
                "            \"id\": \"17291\",\n" +
                "            \"value\": \"8\",\n" +
                "            \"answer\": \"Sales / Business Development\"\n" +
                "          },\n" +
                "          { \"id\": \"17292\", \"value\": \"9\", \"answer\": \"Customer Service \" },\n" +
                "          { \"id\": \"17293\", \"value\": \"10\", \"answer\": \"Marketing / Product\" },\n" +
                "          {\n" +
                "            \"id\": \"17294\",\n" +
                "            \"value\": \"11\",\n" +
                "            \"answer\": \"Communications / PR / Advertising\"\n" +
                "          },\n" +
                "          { \"id\": \"17295\", \"value\": \"12\", \"answer\": \"Creative/Design\" },\n" +
                "          { \"id\": \"17296\", \"value\": \"13\", \"answer\": \"R&D/Science\" },\n" +
                "          { \"id\": \"17297\", \"value\": \"14\", \"answer\": \"Engineering\" },\n" +
                "          { \"id\": \"17298\", \"value\": \"15\", \"answer\": \"IT/ MIS\" },\n" +
                "          {\n" +
                "            \"id\": \"17299\",\n" +
                "            \"value\": \"16\",\n" +
                "            \"answer\": \"Manufacturing/Operations / Production\"\n" +
                "          },\n" +
                "          { \"id\": \"17300\", \"value\": \"17\", \"answer\": \"Procurement\" },\n" +
                "          { \"id\": \"17301\", \"value\": \"18\", \"answer\": \"Quality Control\" },\n" +
                "          {\n" +
                "            \"id\": \"17302\",\n" +
                "            \"value\": \"19\",\n" +
                "            \"answer\": \"Logistics /Distribution/Transportation\"\n" +
                "          },\n" +
                "          { \"id\": \"17303\", \"value\": \"20\", \"answer\": \"Training / Education\" },\n" +
                "          { \"id\": \"17304\", \"value\": \"21\", \"answer\": \"Craftwork and related\" },\n" +
                "          { \"id\": \"17305\", \"value\": \"22\", \"answer\": \"Medical/Health\" },\n" +
                "          {\n" +
                "            \"id\": \"17306\",\n" +
                "            \"value\": \"23\",\n" +
                "            \"answer\": \"Hospitality Business Specialists\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17307\",\n" +
                "            \"value\": \"24\",\n" +
                "            \"answer\": \"Building / Construction / Equipment\"\n" +
                "          },\n" +
                "          { \"id\": \"17308\", \"value\": \"25\", \"answer\": \"Editorial/Writing\" },\n" +
                "          { \"id\": \"17309\", \"value\": \"99\", \"answer\": \"Other\" }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"div\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 2576,\n" +
                "        \"attributeId\": 31,\n" +
                "        \"mainQuestionFlg\": true,\n" +
                "        \"mainQuestionId\": -1,\n" +
                "        \"question\": \"Job Title\",\n" +
                "        \"values\": [\"7\"],\n" +
                "        \"fieldType\": 3,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          {\n" +
                "            \"id\": \"17310\",\n" +
                "            \"value\": \"1\",\n" +
                "            \"answer\": \"Director/General Manager/Vice President \"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17311\",\n" +
                "            \"value\": \"2\",\n" +
                "            \"answer\": \"Owner/Partner/Self Employed\"\n" +
                "          },\n" +
                "          { \"id\": \"17312\", \"value\": \"3\", \"answer\": \"Manager\" },\n" +
                "          {\n" +
                "            \"id\": \"17313\",\n" +
                "            \"value\": \"4\",\n" +
                "            \"answer\": \"Executive/Supervisor/Officer\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17314\",\n" +
                "            \"value\": \"5\",\n" +
                "            \"answer\": \"Other White Collar - skilled (eg. secretaries, draftsman, etc) \"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17315\",\n" +
                "            \"value\": \"6\",\n" +
                "            \"answer\": \"Other White Collar - unskilled (eg. sales assistants, etc) \"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17316\",\n" +
                "            \"value\": \"7\",\n" +
                "            \"answer\": \"Skilled/ Semi-skilled Blue Collar (eg. technician, craftsmen, etc) \"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"17317\",\n" +
                "            \"value\": \"8\",\n" +
                "            \"answer\": \"Unskilled Blue Collar (eg. factory floor, labourer, etc) \"\n" +
                "          },\n" +
                "          { \"id\": \"17318\", \"value\": \"99\", \"answer\": \"Other\" }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"pos\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 2426,\n" +
                "        \"attributeId\": 38,\n" +
                "        \"mainQuestionFlg\": true,\n" +
                "        \"mainQuestionId\": -1,\n" +
                "        \"question\": \"Ethnic Origin\",\n" +
                "        \"values\": [\"3\"],\n" +
                "        \"fieldType\": 3,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          { \"id\": \"17233\", \"value\": \"1\", \"answer\": \"Chinese\" },\n" +
                "          { \"id\": \"17234\", \"value\": \"2\", \"answer\": \"Malay\" },\n" +
                "          { \"id\": \"17235\", \"value\": \"3\", \"answer\": \"Indian\" },\n" +
                "          { \"id\": \"17236\", \"value\": \"4\", \"answer\": \"Eurasian\" },\n" +
                "          { \"id\": \"17237\", \"value\": \"9\", \"answer\": \"Other\" }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"race\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 2301,\n" +
                "        \"attributeId\": 108,\n" +
                "        \"mainQuestionFlg\": true,\n" +
                "        \"mainQuestionId\": -1,\n" +
                "        \"question\": \"Survey Languages\",\n" +
                "        \"values\": [\"1\"],\n" +
                "        \"fieldType\": 1,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          { \"id\": \"17220\", \"value\": \"1\", \"answer\": \"English\" },\n" +
                "          { \"id\": \"17221\", \"value\": \"3\", \"answer\": \"Chinese (Simplified)\" },\n" +
                "          { \"id\": \"17222\", \"value\": \"7\", \"answer\": \"Malay\" },\n" +
                "          { \"id\": \"17223\", \"value\": \"25\", \"answer\": \"Tamil\" },\n" +
                "          { \"id\": \"17224\", \"value\": \"15\", \"answer\": \"Hindi\" }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"plang\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 2376,\n" +
                "        \"attributeId\": 110,\n" +
                "        \"mainQuestionFlg\": true,\n" +
                "        \"mainQuestionId\": -1,\n" +
                "        \"question\": \"Resident Status\",\n" +
                "        \"values\": [\"3\"],\n" +
                "        \"fieldType\": 3,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          { \"id\": \"17225\", \"value\": \"1\", \"answer\": \"Citizen\" },\n" +
                "          { \"id\": \"17226\", \"value\": \"2\", \"answer\": \"Permanent Resident\" },\n" +
                "          { \"id\": \"17227\", \"value\": \"3\", \"answer\": \"EP Holder\" },\n" +
                "          { \"id\": \"17228\", \"value\": \"4\", \"answer\": \"SP Holder\" },\n" +
                "          { \"id\": \"17229\", \"value\": \"5\", \"answer\": \"Work Permit Holder\" }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"residence_sts\",\n" +
                "        \"storedJson\": null,\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      }\n" +
                "    ]";
    }


}
