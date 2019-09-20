package controller;

import db.DataBase;
import http.request.HttpRequest;
import http.request.QueryParams;
import http.response.HttpResponseEntity;
import http.response.HttpStatus;
import model.User;

public class UserController extends AbstractController {
    @Override
    protected HttpResponseEntity doPost(HttpRequest httpRequest) {
        QueryParams queryParams = httpRequest.getQueryParams();
        User user = new User(queryParams.getParam("userId"), queryParams.getParam("password"),
                queryParams.getParam("name"), queryParams.getParam("email"));
        DataBase.addUser(user);
        return new HttpResponseEntity("index.html", HttpStatus.FOUND);
    }
}
