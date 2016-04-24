package edu.bsuir.sh.beans;

public class StudiesBean {
	private int id;
	private String name;
	private String hours;
	private int professor_id;
	private double avg_mark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}
	public int getProfessor_id() {
		return professor_id;
	}
	public void setProfessor_id(int professor_id) {
		this.professor_id = professor_id;
	}
	public double getAvg_mark() {
		return avg_mark;
	}
	public void setAvg_mark(double avg_mark) {
		this.avg_mark = avg_mark;
	}
	
	
}
