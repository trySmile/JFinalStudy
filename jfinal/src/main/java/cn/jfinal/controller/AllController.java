package cn.jfinal.controller;

import com.jfinal.core.Controller;

public class AllController extends Controller {
	public void index(){
		renderText("张三");
	}
}
