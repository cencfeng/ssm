package com.cen.entity;

public class Moudle {
	private int m_id;
	private String m_name;
	private int m_order;
	private int m_level;
	private int m_parentid;
	private String m_url;
	public String getM_url() {
		return m_url;
	}
	public void setM_url(String m_url) {
		this.m_url = m_url;
	}
	public int getM_parentid() {
		return m_parentid;
	}
	public void setM_parentid(int m_parentid) {
		this.m_parentid = m_parentid;
	}
	
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public int getM_order() {
		return m_order;
	}
	public void setM_order(int m_order) {
		this.m_order = m_order;
	}
	public int getM_level() {
		return m_level;
	}
	public void setM_level(int m_level) {
		this.m_level = m_level;
	}
}
