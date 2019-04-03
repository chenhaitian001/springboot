package com.four.server.entity;

public class Data {
	private String visitor_name ;
	private String visitor_uid ; 
	private String access_time ;
	private String img ;
	private int  dev_direction ;
	private String  tel_number ;
	public String getVisitor_name() {
		return visitor_name;
	}
	public void setVisitor_name(String visitor_name) {
		this.visitor_name = visitor_name;
	}
	public String getVisitor_uid() {
		return visitor_uid;
	}
	public void setVisitor_uid(String visitor_uid) {
		this.visitor_uid = visitor_uid;
	}
	public String getAccess_time() {
		return access_time;
	}
	public void setAccess_time(String access_time) {
		this.access_time = access_time;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getDev_direction() {
		return dev_direction;
	}
	public void setDev_direction(int dev_direction) {
		this.dev_direction = dev_direction;
	}
	public String getTel_number() {
		return tel_number;
	}
	public void setTel_number(String tel_number) {
		this.tel_number = tel_number;
	}
}
