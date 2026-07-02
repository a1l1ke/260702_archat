package com.example.archat.presentation.controller;

import jakarta.servlet.http.HttpServlet;

// @WebServlet -> 여기는 붙이지 않음
public abstract class BaseController extends HttpServlet {
    protected static final String VIEW_PREFIX = "/WEB-INF/views/";
}
