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
        if (id.equals("2")) {
            json = getProfile2Json();
        }
        if (id.equals("3")) {
            json = getProfile3Json();
        }
        if (id.equals("4")) {
            json = getProfile4Json();
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
    private String getProfile2Json(){
        return "[\n" +
                "      {\n" +
                "        \"id\": 1001,\n" +
                "        \"attributeId\": 24,\n" +
                "        \"mainQuestionFlg\": true,\n" +
                "        \"mainQuestionId\": -1,\n" +
                "        \"question\": \"Family Size\",\n" +
                "        \"values\": [],\n" +
                "        \"fieldType\": 4,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          { \"id\": \"1\", \"value\": \"1\", \"answer\": \"1(living alone)\" },\n" +
                "          { \"id\": \"26\", \"value\": \"2\", \"answer\": \"2\" },\n" +
                "          { \"id\": \"51\", \"value\": \"3\", \"answer\": \"3\" },\n" +
                "          { \"id\": \"76\", \"value\": \"4\", \"answer\": \"4\" },\n" +
                "          { \"id\": \"101\", \"value\": \"5\", \"answer\": \"5\" },\n" +
                "          { \"id\": \"126\", \"value\": \"6\", \"answer\": \"6\" },\n" +
                "          { \"id\": \"151\", \"value\": \"7\", \"answer\": \"7\" },\n" +
                "          { \"id\": \"176\", \"value\": \"8\", \"answer\": \"8\" },\n" +
                "          { \"id\": \"201\", \"value\": \"9\", \"answer\": \"9\" },\n" +
                "          { \"id\": \"226\", \"value\": \"10\", \"answer\": \"10 or more\" }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"fam\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 1051,\n" +
                "        \"attributeId\": 33,\n" +
                "        \"mainQuestionFlg\": true,\n" +
                "        \"mainQuestionId\": 0,\n" +
                "        \"question\": \"Children\",\n" +
                "        \"values\": [],\n" +
                "        \"fieldType\": 4,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          { \"id\": \"251\", \"value\": \"1\", \"answer\": \"1\" },\n" +
                "          { \"id\": \"276\", \"value\": \"2\", \"answer\": \"2\" },\n" +
                "          { \"id\": \"301\", \"value\": \"3\", \"answer\": \"3\" },\n" +
                "          { \"id\": \"326\", \"value\": \"4\", \"answer\": \"4 or above\" },\n" +
                "          {\n" +
                "            \"id\": \"351\",\n" +
                "            \"value\": \"5\",\n" +
                "            \"answer\": \"No children / Not living together\"\n" +
                "          }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"ch_n\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 1076,\n" +
                "        \"attributeId\": 34,\n" +
                "        \"mainQuestionFlg\": false,\n" +
                "        \"mainQuestionId\": 33,\n" +
                "        \"question\": \"Date of birth of the youngest child in your household\",\n" +
                "        \"values\": [],\n" +
                "        \"fieldType\": 2,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"ch[0].ch_bd.$date\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 1151,\n" +
                "        \"attributeId\": 35,\n" +
                "        \"mainQuestionFlg\": false,\n" +
                "        \"mainQuestionId\": 33,\n" +
                "        \"question\": \"Date of birth of the 2nd-youngest child in your household\",\n" +
                "        \"values\": [],\n" +
                "        \"fieldType\": 2,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"ch[1].ch_bd.$date\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 1201,\n" +
                "        \"attributeId\": 36,\n" +
                "        \"mainQuestionFlg\": false,\n" +
                "        \"mainQuestionId\": 33,\n" +
                "        \"question\": \"Date of birth of the 3rd-youngest child in your household\",\n" +
                "        \"values\": [],\n" +
                "        \"fieldType\": 2,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"ch[2].ch_bd.$date\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 1251,\n" +
                "        \"attributeId\": 37,\n" +
                "        \"mainQuestionFlg\": false,\n" +
                "        \"mainQuestionId\": 33,\n" +
                "        \"question\": \"Date of birth of the 4th-youngest child in your household\",\n" +
                "        \"values\": [],\n" +
                "        \"fieldType\": 2,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"ch[3].ch_bd.$date\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 1426,\n" +
                "        \"attributeId\": 44,\n" +
                "        \"mainQuestionFlg\": true,\n" +
                "        \"mainQuestionId\": -1,\n" +
                "        \"question\": \"Number of trips for leisure in the past six months\",\n" +
                "        \"values\": [],\n" +
                "        \"fieldType\": 4,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          { \"id\": \"1176\", \"value\": \"1\", \"answer\": \"Once\" },\n" +
                "          { \"id\": \"1201\", \"value\": \"2\", \"answer\": \"Twice\" },\n" +
                "          { \"id\": \"1226\", \"value\": \"3\", \"answer\": \"Three times\" },\n" +
                "          { \"id\": \"1251\", \"value\": \"4\", \"answer\": \"Four times\" },\n" +
                "          { \"id\": \"1276\", \"value\": \"5\", \"answer\": \"Five times or more\" },\n" +
                "          {\n" +
                "            \"id\": \"1301\",\n" +
                "            \"value\": \"9\",\n" +
                "            \"answer\": \"None within the past 6 months\"\n" +
                "          }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"ltrip\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 1126,\n" +
                "        \"attributeId\": 49,\n" +
                "        \"mainQuestionFlg\": false,\n" +
                "        \"mainQuestionId\": 33,\n" +
                "        \"question\": \"Gender of the youngest child in your household\",\n" +
                "        \"values\": [],\n" +
                "        \"fieldType\": 4,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          { \"id\": \"376\", \"value\": \"1\", \"answer\": \"Male\" },\n" +
                "          { \"id\": \"401\", \"value\": \"2\", \"answer\": \"Female\" }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"ch[0].ch_g\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 1176,\n" +
                "        \"attributeId\": 50,\n" +
                "        \"mainQuestionFlg\": false,\n" +
                "        \"mainQuestionId\": 33,\n" +
                "        \"question\": \"Gender of the 2nd-youngest child in your household\",\n" +
                "        \"values\": [],\n" +
                "        \"fieldType\": 4,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          { \"id\": \"426\", \"value\": \"1\", \"answer\": \"Male\" },\n" +
                "          { \"id\": \"451\", \"value\": \"2\", \"answer\": \"Female\" }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"ch[1].ch_g\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 1226,\n" +
                "        \"attributeId\": 51,\n" +
                "        \"mainQuestionFlg\": false,\n" +
                "        \"mainQuestionId\": 33,\n" +
                "        \"question\": \"Gender of the 3rd-youngest child in your household\",\n" +
                "        \"values\": [],\n" +
                "        \"fieldType\": 4,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          { \"id\": \"576\", \"value\": \"1\", \"answer\": \"Male\" },\n" +
                "          { \"id\": \"601\", \"value\": \"2\", \"answer\": \"Female\" }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"ch[2].ch_g\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 1276,\n" +
                "        \"attributeId\": 52,\n" +
                "        \"mainQuestionFlg\": false,\n" +
                "        \"mainQuestionId\": 33,\n" +
                "        \"question\": \"Gender of the 4th-youngest child in your household\",\n" +
                "        \"values\": [],\n" +
                "        \"fieldType\": 4,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          { \"id\": \"626\", \"value\": \"1\", \"answer\": \"Male\" },\n" +
                "          { \"id\": \"651\", \"value\": \"2\", \"answer\": \"Female\" }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"ch[3].ch_g\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 1301,\n" +
                "        \"attributeId\": 72,\n" +
                "        \"mainQuestionFlg\": true,\n" +
                "        \"mainQuestionId\": -1,\n" +
                "        \"question\": \"Are you the primary decision maker in your household for grocery shopping?\",\n" +
                "        \"values\": [],\n" +
                "        \"fieldType\": 4,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          { \"id\": \"676\", \"value\": \"1\", \"answer\": \"Yes\" },\n" +
                "          {\n" +
                "            \"id\": \"701\",\n" +
                "            \"value\": \"2\",\n" +
                "            \"answer\": \"I contribute equally in grocery decisions\"\n" +
                "          },\n" +
                "          { \"id\": \"726\", \"value\": \"3\", \"answer\": \"No\" },\n" +
                "          { \"id\": \"751\", \"value\": \"4\", \"answer\": \"Prefer not to say\" }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"au.au_1\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 1326,\n" +
                "        \"attributeId\": 73,\n" +
                "        \"mainQuestionFlg\": true,\n" +
                "        \"mainQuestionId\": -1,\n" +
                "        \"question\": \"Are you the primary decision maker in your household for automotive-related purchases?\",\n" +
                "        \"values\": [],\n" +
                "        \"fieldType\": 4,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          { \"id\": \"776\", \"value\": \"1\", \"answer\": \"Yes\" },\n" +
                "          {\n" +
                "            \"id\": \"801\",\n" +
                "            \"value\": \"2\",\n" +
                "            \"answer\": \"I contribute equally in automotive decisions\"\n" +
                "          },\n" +
                "          { \"id\": \"826\", \"value\": \"3\", \"answer\": \"No\" },\n" +
                "          { \"id\": \"851\", \"value\": \"4\", \"answer\": \"Prefer not to say\" }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"au.au_2\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 1351,\n" +
                "        \"attributeId\": 75,\n" +
                "        \"mainQuestionFlg\": true,\n" +
                "        \"mainQuestionId\": -1,\n" +
                "        \"question\": \"Are you the primary decision maker in your household for Finance related decisions?\",\n" +
                "        \"values\": [],\n" +
                "        \"fieldType\": 4,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          { \"id\": \"876\", \"value\": \"1\", \"answer\": \"Yes\" },\n" +
                "          {\n" +
                "            \"id\": \"901\",\n" +
                "            \"value\": \"2\",\n" +
                "            \"answer\": \"I contribute equally in finance related decisions\"\n" +
                "          },\n" +
                "          { \"id\": \"926\", \"value\": \"3\", \"answer\": \"No\" },\n" +
                "          { \"id\": \"951\", \"value\": \"4\", \"answer\": \"Prefer not to say\" }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"au.au_4\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 1376,\n" +
                "        \"attributeId\": 76,\n" +
                "        \"mainQuestionFlg\": true,\n" +
                "        \"mainQuestionId\": -1,\n" +
                "        \"question\": \"Are you the primary decision maker in your household for insurance decisions?\",\n" +
                "        \"values\": [],\n" +
                "        \"fieldType\": 4,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          { \"id\": \"976\", \"value\": \"1\", \"answer\": \"Yes\" },\n" +
                "          {\n" +
                "            \"id\": \"1001\",\n" +
                "            \"value\": \"2\",\n" +
                "            \"answer\": \"I contribute equally in insurance decisions\"\n" +
                "          },\n" +
                "          { \"id\": \"1026\", \"value\": \"3\", \"answer\": \"No\" },\n" +
                "          { \"id\": \"1051\", \"value\": \"4\", \"answer\": \"Prefer not to say\" }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"au.au_5\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 1401,\n" +
                "        \"attributeId\": 80,\n" +
                "        \"mainQuestionFlg\": true,\n" +
                "        \"mainQuestionId\": -1,\n" +
                "        \"question\": \"Are you the primary decision maker in your household for real estate decisions?\",\n" +
                "        \"values\": [],\n" +
                "        \"fieldType\": 4,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          { \"id\": \"1076\", \"value\": \"1\", \"answer\": \"Yes\" },\n" +
                "          {\n" +
                "            \"id\": \"1101\",\n" +
                "            \"value\": \"2\",\n" +
                "            \"answer\": \"I contribute equally in Real Estate decisions\"\n" +
                "          },\n" +
                "          { \"id\": \"1126\", \"value\": \"3\", \"answer\": \"No\" },\n" +
                "          { \"id\": \"1151\", \"value\": \"4\", \"answer\": \"Prefer not to say\" }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"au.au_9\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 1451,\n" +
                "        \"attributeId\": 98,\n" +
                "        \"mainQuestionFlg\": true,\n" +
                "        \"mainQuestionId\": -1,\n" +
                "        \"question\": \"Financial Products you currently have or services you use\",\n" +
                "        \"values\": [],\n" +
                "        \"fieldType\": 1,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          {\n" +
                "            \"id\": \"1860\",\n" +
                "            \"value\": \"1\",\n" +
                "            \"answer\": \"Credit card(s) with required monthly payment\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"1885\",\n" +
                "            \"value\": \"2\",\n" +
                "            \"answer\": \"Credit card(s) without required monthly payment\"\n" +
                "          },\n" +
                "          { \"id\": \"1910\", \"value\": \"3\", \"answer\": \"Current account\" },\n" +
                "          { \"id\": \"1935\", \"value\": \"4\", \"answer\": \"Savings account\" },\n" +
                "          {\n" +
                "            \"id\": \"1960\",\n" +
                "            \"value\": \"5\",\n" +
                "            \"answer\": \"Cash or Fixed Term Investment\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"1985\",\n" +
                "            \"value\": \"6\",\n" +
                "            \"answer\": \"Foreign Currency Savings Account\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"2010\",\n" +
                "            \"value\": \"7\",\n" +
                "            \"answer\": \"Foreign Currency Fixed Term Account\"\n" +
                "          },\n" +
                "          { \"id\": \"2035\", \"value\": \"8\", \"answer\": \"Mortgage\" },\n" +
                "          { \"id\": \"2060\", \"value\": \"9\", \"answer\": \"Auto Loan\" },\n" +
                "          { \"id\": \"2085\", \"value\": \"10\", \"answer\": \"Investment Loan\" },\n" +
                "          { \"id\": \"2110\", \"value\": \"11\", \"answer\": \"Personal Loan\" },\n" +
                "          {\n" +
                "            \"id\": \"2135\",\n" +
                "            \"value\": \"12\",\n" +
                "            \"answer\": \"Health / Medical Insurance (paid for by yourself)\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"2160\",\n" +
                "            \"value\": \"13\",\n" +
                "            \"answer\": \"Term Life Insurance (paid for by yourself)\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"2185\",\n" +
                "            \"value\": \"14\",\n" +
                "            \"answer\": \"Whole Life Insurance (paid for by yourself)\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"2210\",\n" +
                "            \"value\": \"15\",\n" +
                "            \"answer\": \"Home and Contents Insurance\"\n" +
                "          },\n" +
                "          { \"id\": \"2235\", \"value\": \"16\", \"answer\": \"Pet Insurance\" },\n" +
                "          {\n" +
                "            \"id\": \"2260\",\n" +
                "            \"value\": \"17\",\n" +
                "            \"answer\": \"Comprehensive Car / Motorbike Insurance\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"2285\",\n" +
                "            \"value\": \"18\",\n" +
                "            \"answer\": \"Stocks / Funds / ETF with Traditional Stockbroker\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"2310\",\n" +
                "            \"value\": \"19\",\n" +
                "            \"answer\": \"Stocks / Funds / ETF with Online Stockbroker\"\n" +
                "          },\n" +
                "          { \"id\": \"2335\", \"value\": \"20\", \"answer\": \"Real Estate\" },\n" +
                "          {\n" +
                "            \"id\": \"2360\",\n" +
                "            \"value\": \"98\",\n" +
                "            \"answer\": \"Personal Pension (Not provided by your employer)\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"2385\",\n" +
                "            \"value\": \"99\",\n" +
                "            \"answer\": \"Don't have or use any financial products or services\"\n" +
                "          }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"fin\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      }\n" +
                "    ]";
    }
    private String getProfile3Json(){
        return "[\n" +
                "      {\n" +
                "        \"id\": 1501,\n" +
                "        \"attributeId\": 40,\n" +
                "        \"mainQuestionFlg\": true,\n" +
                "        \"mainQuestionId\": -1,\n" +
                "        \"question\": \"Which of the following licences do you have?\",\n" +
                "        \"values\": [],\n" +
                "        \"fieldType\": 1,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          { \"id\": \"2410\", \"value\": \"1\", \"answer\": \"Drivers licence\" },\n" +
                "          { \"id\": \"2435\", \"value\": \"2\", \"answer\": \"Motorbike/Scooter Licence\" },\n" +
                "          { \"id\": \"2460\", \"value\": \"3\", \"answer\": \"None of the above\" }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"driv\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 1526,\n" +
                "        \"attributeId\": 41,\n" +
                "        \"mainQuestionFlg\": true,\n" +
                "        \"mainQuestionId\": 0,\n" +
                "        \"question\": \"How many cars do you own or lease in your household?\",\n" +
                "        \"values\": [],\n" +
                "        \"fieldType\": 4,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          { \"id\": \"2485\", \"value\": \"1\", \"answer\": \"1 car\" },\n" +
                "          { \"id\": \"2510\", \"value\": \"2\", \"answer\": \"2 cars\" },\n" +
                "          { \"id\": \"2535\", \"value\": \"3\", \"answer\": \"3 or more cars\" },\n" +
                "          { \"id\": \"2560\", \"value\": \"4\", \"answer\": \"I don't own or lease a car\" }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"car_n\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 1551,\n" +
                "        \"attributeId\": 53,\n" +
                "        \"mainQuestionFlg\": false,\n" +
                "        \"mainQuestionId\": 41,\n" +
                "        \"question\": \"Which make/brand of car is the main car used in your household?\",\n" +
                "        \"values\": [],\n" +
                "        \"fieldType\": 4,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          { \"id\": \"2585\", \"value\": \"1\", \"answer\": \"Acura\" },\n" +
                "          { \"id\": \"2610\", \"value\": \"2\", \"answer\": \"Alfa Romeo\" },\n" +
                "          { \"id\": \"2635\", \"value\": \"3\", \"answer\": \"Audi\" },\n" +
                "          { \"id\": \"2660\", \"value\": \"4\", \"answer\": \"BMW\" },\n" +
                "          { \"id\": \"2685\", \"value\": \"5\", \"answer\": \"Buick\" },\n" +
                "          { \"id\": \"2710\", \"value\": \"6\", \"answer\": \"Cadillac\" },\n" +
                "          { \"id\": \"2735\", \"value\": \"7\", \"answer\": \"Chery\" },\n" +
                "          { \"id\": \"2760\", \"value\": \"8\", \"answer\": \"Chevrolet\" },\n" +
                "          { \"id\": \"2785\", \"value\": \"9\", \"answer\": \"Chrysler\" },\n" +
                "          { \"id\": \"2810\", \"value\": \"10\", \"answer\": \"Citroen\" },\n" +
                "          { \"id\": \"2835\", \"value\": \"11\", \"answer\": \"Dacia\" },\n" +
                "          { \"id\": \"2860\", \"value\": \"12\", \"answer\": \"Daewoo\" },\n" +
                "          { \"id\": \"2885\", \"value\": \"13\", \"answer\": \"Daihatsu\" },\n" +
                "          { \"id\": \"2910\", \"value\": \"14\", \"answer\": \"Eunos\" },\n" +
                "          { \"id\": \"2935\", \"value\": \"15\", \"answer\": \"Ferrari\" },\n" +
                "          { \"id\": \"2960\", \"value\": \"16\", \"answer\": \"Fiat\" },\n" +
                "          { \"id\": \"2985\", \"value\": \"17\", \"answer\": \"Ford\" },\n" +
                "          { \"id\": \"3010\", \"value\": \"18\", \"answer\": \"Geely\" },\n" +
                "          { \"id\": \"3035\", \"value\": \"19\", \"answer\": \"GMC\" },\n" +
                "          { \"id\": \"3060\", \"value\": \"20\", \"answer\": \"Holden\" },\n" +
                "          { \"id\": \"3085\", \"value\": \"21\", \"answer\": \"Honda\" },\n" +
                "          { \"id\": \"3110\", \"value\": \"22\", \"answer\": \"Hummer\" },\n" +
                "          { \"id\": \"3135\", \"value\": \"23\", \"answer\": \"Hyundai\" },\n" +
                "          { \"id\": \"3160\", \"value\": \"24\", \"answer\": \"Infiniti\" },\n" +
                "          { \"id\": \"3185\", \"value\": \"25\", \"answer\": \"Isuzu\" },\n" +
                "          { \"id\": \"3210\", \"value\": \"26\", \"answer\": \"Jaguar\" },\n" +
                "          { \"id\": \"3235\", \"value\": \"27\", \"answer\": \"Jeep\" },\n" +
                "          { \"id\": \"3260\", \"value\": \"28\", \"answer\": \"Kia\" },\n" +
                "          { \"id\": \"3285\", \"value\": \"29\", \"answer\": \"Lada\" },\n" +
                "          { \"id\": \"3310\", \"value\": \"30\", \"answer\": \"Lamborghini\" },\n" +
                "          { \"id\": \"3335\", \"value\": \"31\", \"answer\": \"Lancia\" },\n" +
                "          { \"id\": \"3360\", \"value\": \"32\", \"answer\": \"Land/Range Rover\" },\n" +
                "          { \"id\": \"3385\", \"value\": \"33\", \"answer\": \"Lexus\" },\n" +
                "          { \"id\": \"3410\", \"value\": \"34\", \"answer\": \"Lotus\" },\n" +
                "          { \"id\": \"3435\", \"value\": \"35\", \"answer\": \"Maserati\" },\n" +
                "          { \"id\": \"3460\", \"value\": \"36\", \"answer\": \"Mazda\" },\n" +
                "          { \"id\": \"3485\", \"value\": \"37\", \"answer\": \"Mercedes\" },\n" +
                "          { \"id\": \"3510\", \"value\": \"38\", \"answer\": \"MG\" },\n" +
                "          { \"id\": \"3535\", \"value\": \"39\", \"answer\": \"Mini\" },\n" +
                "          { \"id\": \"3560\", \"value\": \"40\", \"answer\": \"Mitsubishi\" },\n" +
                "          { \"id\": \"3585\", \"value\": \"41\", \"answer\": \"Nissan\" },\n" +
                "          { \"id\": \"3610\", \"value\": \"42\", \"answer\": \"Opel\" },\n" +
                "          { \"id\": \"3635\", \"value\": \"43\", \"answer\": \"Peugeot\" },\n" +
                "          { \"id\": \"3660\", \"value\": \"44\", \"answer\": \"Pontiac\" },\n" +
                "          { \"id\": \"3685\", \"value\": \"45\", \"answer\": \"Porsche\" },\n" +
                "          { \"id\": \"3710\", \"value\": \"46\", \"answer\": \"Proton\" },\n" +
                "          { \"id\": \"3735\", \"value\": \"47\", \"answer\": \"Renault\" },\n" +
                "          { \"id\": \"3760\", \"value\": \"48\", \"answer\": \"Rover\" },\n" +
                "          { \"id\": \"3785\", \"value\": \"49\", \"answer\": \"Saab\" },\n" +
                "          { \"id\": \"3810\", \"value\": \"50\", \"answer\": \"Saturn\" },\n" +
                "          { \"id\": \"3835\", \"value\": \"51\", \"answer\": \"Seat\" },\n" +
                "          { \"id\": \"3860\", \"value\": \"52\", \"answer\": \"Skoda\" },\n" +
                "          { \"id\": \"3885\", \"value\": \"53\", \"answer\": \"Smart\" },\n" +
                "          { \"id\": \"3910\", \"value\": \"54\", \"answer\": \"Ssangyong\" },\n" +
                "          { \"id\": \"3935\", \"value\": \"55\", \"answer\": \"Subaru\" },\n" +
                "          { \"id\": \"3960\", \"value\": \"56\", \"answer\": \"Suzuki\" },\n" +
                "          { \"id\": \"3985\", \"value\": \"57\", \"answer\": \"Tata\" },\n" +
                "          { \"id\": \"4010\", \"value\": \"58\", \"answer\": \"Tesla\" },\n" +
                "          { \"id\": \"4035\", \"value\": \"59\", \"answer\": \"Toyota\" },\n" +
                "          { \"id\": \"4060\", \"value\": \"60\", \"answer\": \"Vauxhall\" },\n" +
                "          { \"id\": \"4085\", \"value\": \"61\", \"answer\": \"Volkswagen\" },\n" +
                "          { \"id\": \"4108\", \"value\": \"62\", \"answer\": \"Volvo\" },\n" +
                "          { \"id\": \"4129\", \"value\": \"63\", \"answer\": \"Bogdan\" },\n" +
                "          { \"id\": \"4206\", \"value\": \"97\", \"answer\": \"Other\" },\n" +
                "          { \"id\": \"4231\", \"value\": \"98\", \"answer\": \"I don't own/lease a car\" },\n" +
                "          { \"id\": \"4256\", \"value\": \"99\", \"answer\": \"Prefer not to say\" }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"car[0].car_b\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 1576,\n" +
                "        \"attributeId\": 55,\n" +
                "        \"mainQuestionFlg\": false,\n" +
                "        \"mainQuestionId\": 41,\n" +
                "        \"question\": \"What type of car is the main car used in your household?\",\n" +
                "        \"values\": [],\n" +
                "        \"fieldType\": 4,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          {\n" +
                "            \"id\": \"4281\",\n" +
                "            \"value\": \"1\",\n" +
                "            \"answer\": \"Micro/City Car (e.g. Smart Fortwo)\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"4306\",\n" +
                "            \"value\": \"2\",\n" +
                "            \"answer\": \"Sub Compact (e.g. Toyota Yaris)\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"4331\",\n" +
                "            \"value\": \"3\",\n" +
                "            \"answer\": \"Compact Sedan/Stationwagon/Hatch (e.g. VW Golf)\"\n" +
                "          },\n" +
                "          { \"id\": \"4356\", \"value\": \"4\", \"answer\": \"Mid Size (e.g. Mazda 6)\" },\n" +
                "          {\n" +
                "            \"id\": \"4381\",\n" +
                "            \"value\": \"5\",\n" +
                "            \"answer\": \"Luxury/Prestige (e.g. BMW/Mercedes)\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"4406\",\n" +
                "            \"value\": \"6\",\n" +
                "            \"answer\": \"Hybrid/Electric/Biogas (e.g. Toyota Prius)\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"4431\",\n" +
                "            \"value\": \"7\",\n" +
                "            \"answer\": \"Sports/Performance Car (e.g. Audi TT)\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"4456\",\n" +
                "            \"value\": \"8\",\n" +
                "            \"answer\": \"MPV/Minivan (e.g. Dodge Caravan)\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"4481\",\n" +
                "            \"value\": \"9\",\n" +
                "            \"answer\": \"SUV/Cross Over/4x4 (e.g. Honda CR-V)\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"4506\",\n" +
                "            \"value\": \"10\",\n" +
                "            \"answer\": \"Pick up (e.g. Ford F-150)\"\n" +
                "          },\n" +
                "          { \"id\": \"4531\", \"value\": \"11\", \"answer\": \"Van (e.g. Ford E-Series)\" },\n" +
                "          {\n" +
                "            \"id\": \"4556\",\n" +
                "            \"value\": \"12\",\n" +
                "            \"answer\": \"RV/Motor Home or Camper Van\"\n" +
                "          },\n" +
                "          { \"id\": \"4581\", \"value\": \"98\", \"answer\": \"Other\" },\n" +
                "          { \"id\": \"4606\", \"value\": \"99\", \"answer\": \"I don't know\" }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"car[0].car_t\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 1601,\n" +
                "        \"attributeId\": 57,\n" +
                "        \"mainQuestionFlg\": false,\n" +
                "        \"mainQuestionId\": 41,\n" +
                "        \"question\": \"When did you purchase the main car used in your household?\",\n" +
                "        \"values\": [],\n" +
                "        \"fieldType\": 4,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          { \"id\": \"5431\", \"value\": \"1\", \"answer\": \"1990 or before\" },\n" +
                "          { \"id\": \"5456\", \"value\": \"2\", \"answer\": \"1991\" },\n" +
                "          { \"id\": \"5481\", \"value\": \"3\", \"answer\": \"1992\" },\n" +
                "          { \"id\": \"5506\", \"value\": \"4\", \"answer\": \"1993\" },\n" +
                "          { \"id\": \"5531\", \"value\": \"5\", \"answer\": \"1994\" },\n" +
                "          { \"id\": \"5556\", \"value\": \"6\", \"answer\": \"1995\" },\n" +
                "          { \"id\": \"5581\", \"value\": \"7\", \"answer\": \"1996\" },\n" +
                "          { \"id\": \"5606\", \"value\": \"8\", \"answer\": \"1997\" },\n" +
                "          { \"id\": \"5631\", \"value\": \"9\", \"answer\": \"1998\" },\n" +
                "          { \"id\": \"5656\", \"value\": \"10\", \"answer\": \"1999\" },\n" +
                "          { \"id\": \"5681\", \"value\": \"11\", \"answer\": \"2000\" },\n" +
                "          { \"id\": \"5706\", \"value\": \"12\", \"answer\": \"2001\" },\n" +
                "          { \"id\": \"5731\", \"value\": \"13\", \"answer\": \"2002\" },\n" +
                "          { \"id\": \"5756\", \"value\": \"14\", \"answer\": \"2003\" },\n" +
                "          { \"id\": \"5781\", \"value\": \"15\", \"answer\": \"2004\" },\n" +
                "          { \"id\": \"5806\", \"value\": \"16\", \"answer\": \"2005\" },\n" +
                "          { \"id\": \"5831\", \"value\": \"17\", \"answer\": \"2006\" },\n" +
                "          { \"id\": \"5856\", \"value\": \"18\", \"answer\": \"2007\" },\n" +
                "          { \"id\": \"5881\", \"value\": \"19\", \"answer\": \"2008\" },\n" +
                "          { \"id\": \"5906\", \"value\": \"20\", \"answer\": \"2009\" },\n" +
                "          { \"id\": \"5931\", \"value\": \"21\", \"answer\": \"2010\" },\n" +
                "          { \"id\": \"5956\", \"value\": \"22\", \"answer\": \"2011\" },\n" +
                "          { \"id\": \"5981\", \"value\": \"23\", \"answer\": \"2012\" },\n" +
                "          { \"id\": \"6006\", \"value\": \"24\", \"answer\": \"2013\" },\n" +
                "          { \"id\": \"6031\", \"value\": \"25\", \"answer\": \"2014\" },\n" +
                "          { \"id\": \"6056\", \"value\": \"26\", \"answer\": \"2015\" },\n" +
                "          { \"id\": \"6081\", \"value\": \"27\", \"answer\": \"2016\" },\n" +
                "          { \"id\": \"6106\", \"value\": \"28\", \"answer\": \"2017\" },\n" +
                "          { \"id\": \"6131\", \"value\": \"29\", \"answer\": \"2018\" },\n" +
                "          { \"id\": \"6156\", \"value\": \"30\", \"answer\": \"2019\" },\n" +
                "          { \"id\": \"6181\", \"value\": \"31\", \"answer\": \"2020\" },\n" +
                "          { \"id\": \"6206\", \"value\": \"99\", \"answer\": \"I don't know\" }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"car[0].car_y\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 1626,\n" +
                "        \"attributeId\": 59,\n" +
                "        \"mainQuestionFlg\": false,\n" +
                "        \"mainQuestionId\": 41,\n" +
                "        \"question\": \"In what condition did you purchase your main household car?\",\n" +
                "        \"values\": [],\n" +
                "        \"fieldType\": 4,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          { \"id\": \"6231\", \"value\": \"1\", \"answer\": \"New \" },\n" +
                "          { \"id\": \"6256\", \"value\": \"2\", \"answer\": \"Used \" },\n" +
                "          { \"id\": \"6281\", \"value\": \"9\", \"answer\": \"I don't know\" }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"car[0].car_s\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 1651,\n" +
                "        \"attributeId\": 65,\n" +
                "        \"mainQuestionFlg\": true,\n" +
                "        \"mainQuestionId\": 0,\n" +
                "        \"question\": \"How many motorbikes / scooters do you own in your household?\",\n" +
                "        \"values\": [],\n" +
                "        \"fieldType\": 4,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          { \"id\": \"6306\", \"value\": \"1\", \"answer\": \"1\" },\n" +
                "          { \"id\": \"6331\", \"value\": \"2\", \"answer\": \"2\" },\n" +
                "          { \"id\": \"6356\", \"value\": \"3\", \"answer\": \"3 or above\" },\n" +
                "          { \"id\": \"6381\", \"value\": \"4\", \"answer\": \"I don't own a motorbike\" }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"bike_n\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 1676,\n" +
                "        \"attributeId\": 66,\n" +
                "        \"mainQuestionFlg\": false,\n" +
                "        \"mainQuestionId\": 65,\n" +
                "        \"question\": \"What is the make/brand or the motorbike most used in your household?\",\n" +
                "        \"values\": [],\n" +
                "        \"fieldType\": 4,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          { \"id\": \"6406\", \"value\": \"1\", \"answer\": \"BMW\" },\n" +
                "          { \"id\": \"6431\", \"value\": \"2\", \"answer\": \"Aprilia\" },\n" +
                "          { \"id\": \"6456\", \"value\": \"3\", \"answer\": \"Ducati\" },\n" +
                "          { \"id\": \"6481\", \"value\": \"4\", \"answer\": \"Vespa\" },\n" +
                "          { \"id\": \"6506\", \"value\": \"5\", \"answer\": \"Honda\" },\n" +
                "          { \"id\": \"6531\", \"value\": \"6\", \"answer\": \"Kawasaki\" },\n" +
                "          { \"id\": \"6556\", \"value\": \"7\", \"answer\": \"Suzuki\" },\n" +
                "          { \"id\": \"6581\", \"value\": \"8\", \"answer\": \"Yamaha\" },\n" +
                "          { \"id\": \"6606\", \"value\": \"9\", \"answer\": \"KTM\" },\n" +
                "          { \"id\": \"6631\", \"value\": \"10\", \"answer\": \"Harley-Davidson\" },\n" +
                "          { \"id\": \"6733\", \"value\": \"98\", \"answer\": \"Other\" },\n" +
                "          { \"id\": \"6758\", \"value\": \"99\", \"answer\": \"I don't know\" }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"bike[0].bike_b\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 1701,\n" +
                "        \"attributeId\": 67,\n" +
                "        \"mainQuestionFlg\": false,\n" +
                "        \"mainQuestionId\": 65,\n" +
                "        \"question\": \"What type of motorbike is the main motorbike used in your household?\",\n" +
                "        \"values\": [],\n" +
                "        \"fieldType\": 4,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          { \"id\": \"6783\", \"value\": \"1\", \"answer\": \"Street - Standard\" },\n" +
                "          { \"id\": \"6808\", \"value\": \"2\", \"answer\": \"Street - Cruiser\" },\n" +
                "          { \"id\": \"6833\", \"value\": \"3\", \"answer\": \"Street - Sport bike\" },\n" +
                "          { \"id\": \"6858\", \"value\": \"4\", \"answer\": \"Street - Touring\" },\n" +
                "          { \"id\": \"6883\", \"value\": \"5\", \"answer\": \"Street - Sport Touring\" },\n" +
                "          { \"id\": \"6908\", \"value\": \"6\", \"answer\": \"Street - Dual Sport\" },\n" +
                "          { \"id\": \"6933\", \"value\": \"7\", \"answer\": \"Scooter, mopeds\" },\n" +
                "          { \"id\": \"6958\", \"value\": \"8\", \"answer\": \"Off-road\" },\n" +
                "          { \"id\": \"6981\", \"value\": \"9\", \"answer\": \"Utility\" },\n" +
                "          { \"id\": \"7004\", \"value\": \"10\", \"answer\": \"Tricycle\" },\n" +
                "          { \"id\": \"7028\", \"value\": \"99\", \"answer\": \"I don't know\" }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"bike[0].bike_t\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 1726,\n" +
                "        \"attributeId\": 68,\n" +
                "        \"mainQuestionFlg\": false,\n" +
                "        \"mainQuestionId\": 65,\n" +
                "        \"question\": \"When did you buy the main motorbike used in your household?\",\n" +
                "        \"values\": [],\n" +
                "        \"fieldType\": 4,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          { \"id\": \"7053\", \"value\": \"1\", \"answer\": \"1990 or before\" },\n" +
                "          { \"id\": \"7078\", \"value\": \"2\", \"answer\": \"1991\" },\n" +
                "          { \"id\": \"7103\", \"value\": \"3\", \"answer\": \"1992\" },\n" +
                "          { \"id\": \"7128\", \"value\": \"4\", \"answer\": \"1993\" },\n" +
                "          { \"id\": \"7153\", \"value\": \"5\", \"answer\": \"1994\" },\n" +
                "          { \"id\": \"7178\", \"value\": \"6\", \"answer\": \"1995\" },\n" +
                "          { \"id\": \"7203\", \"value\": \"7\", \"answer\": \"1996\" },\n" +
                "          { \"id\": \"7228\", \"value\": \"8\", \"answer\": \"1997\" },\n" +
                "          { \"id\": \"7253\", \"value\": \"9\", \"answer\": \"1998\" },\n" +
                "          { \"id\": \"7278\", \"value\": \"10\", \"answer\": \"1999\" },\n" +
                "          { \"id\": \"7303\", \"value\": \"11\", \"answer\": \"2000\" },\n" +
                "          { \"id\": \"7328\", \"value\": \"12\", \"answer\": \"2001\" },\n" +
                "          { \"id\": \"7353\", \"value\": \"13\", \"answer\": \"2002\" },\n" +
                "          { \"id\": \"7378\", \"value\": \"14\", \"answer\": \"2003\" },\n" +
                "          { \"id\": \"7403\", \"value\": \"15\", \"answer\": \"2004\" },\n" +
                "          { \"id\": \"7428\", \"value\": \"16\", \"answer\": \"2005\" },\n" +
                "          { \"id\": \"7453\", \"value\": \"17\", \"answer\": \"2006\" },\n" +
                "          { \"id\": \"7478\", \"value\": \"18\", \"answer\": \"2007\" },\n" +
                "          { \"id\": \"7503\", \"value\": \"19\", \"answer\": \"2008\" },\n" +
                "          { \"id\": \"7528\", \"value\": \"20\", \"answer\": \"2009\" },\n" +
                "          { \"id\": \"7553\", \"value\": \"21\", \"answer\": \"2010\" },\n" +
                "          { \"id\": \"7578\", \"value\": \"22\", \"answer\": \"2011\" },\n" +
                "          { \"id\": \"7603\", \"value\": \"23\", \"answer\": \"2012\" },\n" +
                "          { \"id\": \"7628\", \"value\": \"24\", \"answer\": \"2013\" },\n" +
                "          { \"id\": \"7653\", \"value\": \"25\", \"answer\": \"2014\" },\n" +
                "          { \"id\": \"7678\", \"value\": \"26\", \"answer\": \"2015\" },\n" +
                "          { \"id\": \"7703\", \"value\": \"27\", \"answer\": \"2016\" },\n" +
                "          { \"id\": \"7728\", \"value\": \"28\", \"answer\": \"2017\" },\n" +
                "          { \"id\": \"7753\", \"value\": \"29\", \"answer\": \"2018\" },\n" +
                "          { \"id\": \"7778\", \"value\": \"30\", \"answer\": \"2019\" },\n" +
                "          { \"id\": \"7803\", \"value\": \"31\", \"answer\": \"2020\" },\n" +
                "          { \"id\": \"7828\", \"value\": \"99\", \"answer\": \"I don't know\" }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"bike[0].bike_y\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 1751,\n" +
                "        \"attributeId\": 69,\n" +
                "        \"mainQuestionFlg\": false,\n" +
                "        \"mainQuestionId\": 65,\n" +
                "        \"question\": \"In what condition did you purchase your main household motorbike?\",\n" +
                "        \"values\": [],\n" +
                "        \"fieldType\": 4,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          { \"id\": \"7853\", \"value\": \"1\", \"answer\": \"Same as \\nVehicle：No17\" },\n" +
                "          { \"id\": \"7878\", \"value\": \"2\", \"answer\": \"Same as \\nVehicle：No17\" },\n" +
                "          { \"id\": \"7903\", \"value\": \"9\", \"answer\": \"I don't know\" }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"bike[0].bike_s\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      }\n" +
                "    ]";
    }

    private String getProfile4Json(){
        return "[\n" +
                "      {\n" +
                "        \"id\": 1901,\n" +
                "        \"attributeId\": 32,\n" +
                "        \"mainQuestionFlg\": true,\n" +
                "        \"mainQuestionId\": -1,\n" +
                "        \"question\": \"Number of employees in company (Including all branches, headquarters, and overseas offices)\",\n" +
                "        \"values\": [],\n" +
                "        \"fieldType\": 4,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          { \"id\": \"8129\", \"value\": \"1\", \"answer\": \"10 or below\" },\n" +
                "          { \"id\": \"8154\", \"value\": \"2\", \"answer\": \"11-49\" },\n" +
                "          { \"id\": \"8179\", \"value\": \"3\", \"answer\": \"50-99\" },\n" +
                "          { \"id\": \"8204\", \"value\": \"4\", \"answer\": \"100-499\" },\n" +
                "          { \"id\": \"8229\", \"value\": \"5\", \"answer\": \"500-999\" },\n" +
                "          { \"id\": \"8254\", \"value\": \"6\", \"answer\": \"1,000-4,999\" },\n" +
                "          { \"id\": \"8279\", \"value\": \"7\", \"answer\": \"5,000-9,999\" },\n" +
                "          { \"id\": \"8304\", \"value\": \"8\", \"answer\": \"10,000 or above\" },\n" +
                "          { \"id\": \"8329\", \"value\": \"99\", \"answer\": \"I don't know\" }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"co_si\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 1951,\n" +
                "        \"attributeId\": 43,\n" +
                "        \"mainQuestionFlg\": true,\n" +
                "        \"mainQuestionId\": -1,\n" +
                "        \"question\": \"Number of Business Trips over the past 6 months\",\n" +
                "        \"values\": [],\n" +
                "        \"fieldType\": 4,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          { \"id\": \"8615\", \"value\": \"1\", \"answer\": \"Once\" },\n" +
                "          { \"id\": \"8640\", \"value\": \"2\", \"answer\": \"Twice\" },\n" +
                "          { \"id\": \"8665\", \"value\": \"3\", \"answer\": \"Three times\" },\n" +
                "          { \"id\": \"8690\", \"value\": \"4\", \"answer\": \"Four times\" },\n" +
                "          { \"id\": \"8715\", \"value\": \"5\", \"answer\": \"Five times or more\" },\n" +
                "          {\n" +
                "            \"id\": \"8740\",\n" +
                "            \"value\": \"9\",\n" +
                "            \"answer\": \"Have not been on a business trip in the past 6 months\"\n" +
                "          }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"btrip\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 1926,\n" +
                "        \"attributeId\": 61,\n" +
                "        \"mainQuestionFlg\": true,\n" +
                "        \"mainQuestionId\": -1,\n" +
                "        \"question\": \"Company's Annual Sales\",\n" +
                "        \"values\": [],\n" +
                "        \"fieldType\": 4,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          { \"id\": \"8354\", \"value\": \"1\", \"answer\": \"Less than 500,000 SGD\" },\n" +
                "          {\n" +
                "            \"id\": \"8379\",\n" +
                "            \"value\": \"2\",\n" +
                "            \"answer\": \"500,000 to less than 1 million SGD\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"8404\",\n" +
                "            \"value\": \"3\",\n" +
                "            \"answer\": \"1 million to less than 3 million SGD\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"8429\",\n" +
                "            \"value\": \"4\",\n" +
                "            \"answer\": \"3 million to less than 5 million SGD\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"8454\",\n" +
                "            \"value\": \"5\",\n" +
                "            \"answer\": \"5 million to less than 10 million SGD\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"8479\",\n" +
                "            \"value\": \"6\",\n" +
                "            \"answer\": \"10 million to less than 15 million SGD\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"8504\",\n" +
                "            \"value\": \"7\",\n" +
                "            \"answer\": \"15 million to less than 20 million SGD\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"8529\",\n" +
                "            \"value\": \"8\",\n" +
                "            \"answer\": \"20 million to less than 50 million SGD\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"8554\",\n" +
                "            \"value\": \"9\",\n" +
                "            \"answer\": \"50 million to less than 100 million SGD\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"8576\",\n" +
                "            \"value\": \"10\",\n" +
                "            \"answer\": \"100 million to less than 300 million SGD\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"8583\",\n" +
                "            \"value\": \"11\",\n" +
                "            \"answer\": \"300 million to less than 500 million SGD\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"id\": \"8586\",\n" +
                "            \"value\": \"12\",\n" +
                "            \"answer\": \"500 million to less than 1 billion SGD\"\n" +
                "          },\n" +
                "          { \"id\": \"8589\", \"value\": \"13\", \"answer\": \"1 billion SGD or over\" },\n" +
                "          {\n" +
                "            \"id\": \"8590\",\n" +
                "            \"value\": \"99\",\n" +
                "            \"answer\": \"I don't know / refuse to answer\"\n" +
                "          }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"co_sa\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 1976,\n" +
                "        \"attributeId\": 82,\n" +
                "        \"mainQuestionFlg\": true,\n" +
                "        \"mainQuestionId\": -1,\n" +
                "        \"question\": \"Decisions about workplace computer hardware\",\n" +
                "        \"values\": [],\n" +
                "        \"fieldType\": 4,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          { \"id\": \"8765\", \"value\": \"1\", \"answer\": \"Final decision maker\" },\n" +
                "          { \"id\": \"8790\", \"value\": \"2\", \"answer\": \"Involved in decision\" },\n" +
                "          { \"id\": \"8815\", \"value\": \"3\", \"answer\": \"Give comments on decision\" },\n" +
                "          { \"id\": \"8840\", \"value\": \"9\", \"answer\": \"No involvement in decision\" }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"au_b.au_b_2\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 2001,\n" +
                "        \"attributeId\": 83,\n" +
                "        \"mainQuestionFlg\": true,\n" +
                "        \"mainQuestionId\": -1,\n" +
                "        \"question\": \"Decisions about workplace computer software\",\n" +
                "        \"values\": [],\n" +
                "        \"fieldType\": 4,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          { \"id\": \"8865\", \"value\": \"1\", \"answer\": \"Final decision maker\" },\n" +
                "          { \"id\": \"8890\", \"value\": \"2\", \"answer\": \"Involved in decision\" },\n" +
                "          { \"id\": \"8915\", \"value\": \"3\", \"answer\": \"Give comments on decision\" },\n" +
                "          { \"id\": \"8940\", \"value\": \"9\", \"answer\": \"No involvement in decision\" }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"au_b.au_b_3\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 2026,\n" +
                "        \"attributeId\": 84,\n" +
                "        \"mainQuestionFlg\": true,\n" +
                "        \"mainQuestionId\": -1,\n" +
                "        \"question\": \"Decisions about workplace printers\",\n" +
                "        \"values\": [],\n" +
                "        \"fieldType\": 4,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          { \"id\": \"8965\", \"value\": \"1\", \"answer\": \"Final decision maker\" },\n" +
                "          { \"id\": \"8990\", \"value\": \"2\", \"answer\": \"Involved in decision\" },\n" +
                "          { \"id\": \"9015\", \"value\": \"3\", \"answer\": \"Give comments on decision\" },\n" +
                "          { \"id\": \"9040\", \"value\": \"9\", \"answer\": \"No involvement in decision\" }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"au_b.au_b_4\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 2051,\n" +
                "        \"attributeId\": 86,\n" +
                "        \"mainQuestionFlg\": true,\n" +
                "        \"mainQuestionId\": -1,\n" +
                "        \"question\": \"Decisions about workplace internet service provider\",\n" +
                "        \"values\": [],\n" +
                "        \"fieldType\": 4,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          { \"id\": \"9065\", \"value\": \"1\", \"answer\": \"Final decision maker\" },\n" +
                "          { \"id\": \"9090\", \"value\": \"2\", \"answer\": \"Involved in decision\" },\n" +
                "          { \"id\": \"9115\", \"value\": \"3\", \"answer\": \"Give comments on decision\" },\n" +
                "          { \"id\": \"9140\", \"value\": \"9\", \"answer\": \"No involvement in decision\" }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"au_b.au_b_6\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 2101,\n" +
                "        \"attributeId\": 87,\n" +
                "        \"mainQuestionFlg\": true,\n" +
                "        \"mainQuestionId\": -1,\n" +
                "        \"question\": \"Decisions about workplace financial services (auditing, insurance, accounting, banking, etc)\",\n" +
                "        \"values\": [],\n" +
                "        \"fieldType\": 4,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          { \"id\": \"9165\", \"value\": \"1\", \"answer\": \"Final decision maker\" },\n" +
                "          { \"id\": \"9190\", \"value\": \"2\", \"answer\": \"Involved in decision\" },\n" +
                "          { \"id\": \"9215\", \"value\": \"3\", \"answer\": \"Give comments on decision\" },\n" +
                "          { \"id\": \"9240\", \"value\": \"9\", \"answer\": \"No involvement in decision\" }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"au_b.au_b_7\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 2126,\n" +
                "        \"attributeId\": 89,\n" +
                "        \"mainQuestionFlg\": true,\n" +
                "        \"mainQuestionId\": -1,\n" +
                "        \"question\": \"Decisions about workplace human resources (recruitment, training etc)\",\n" +
                "        \"values\": [],\n" +
                "        \"fieldType\": 4,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          { \"id\": \"9265\", \"value\": \"1\", \"answer\": \"Final decision maker\" },\n" +
                "          { \"id\": \"9290\", \"value\": \"2\", \"answer\": \"Involved in decision\" },\n" +
                "          { \"id\": \"9315\", \"value\": \"3\", \"answer\": \"Give comments on decision\" },\n" +
                "          { \"id\": \"9340\", \"value\": \"9\", \"answer\": \"No involvement in decision\" }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"au_b.au_b_9\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 2151,\n" +
                "        \"attributeId\": 91,\n" +
                "        \"mainQuestionFlg\": true,\n" +
                "        \"mainQuestionId\": -1,\n" +
                "        \"question\": \"Decisions about workplace couriers, mail services\",\n" +
                "        \"values\": [],\n" +
                "        \"fieldType\": 4,\n" +
                "        \"mandatory\": true,\n" +
                "        \"isNumber\": false,\n" +
                "        \"options\": [\n" +
                "          { \"id\": \"9365\", \"value\": \"1\", \"answer\": \"Final decision maker\" },\n" +
                "          { \"id\": \"9390\", \"value\": \"2\", \"answer\": \"Involved in decision\" },\n" +
                "          { \"id\": \"9415\", \"value\": \"3\", \"answer\": \"Give comments on decision\" },\n" +
                "          { \"id\": \"9440\", \"value\": \"9\", \"answer\": \"No involvement in decision\" }\n" +
                "        ],\n" +
                "        \"storedColumn\": \"profile_json\",\n" +
                "        \"storedJson\": \"au_b.au_b_11\",\n" +
                "        \"max\": null,\n" +
                "        \"min\": null,\n" +
                "        \"pattern\": null\n" +
                "      }\n" +
                "    ]";
    }

}
