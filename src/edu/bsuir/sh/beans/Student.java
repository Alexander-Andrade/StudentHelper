package edu.bsuir.sh.beans;

public class Student {
	private int id;
	private String first_name;
	private String second_name;
	private double avg_mark; 
	private String group_number;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getSecond_name() {
		return second_name;
	}
	public void setSecond_name(String second_name) {
		this.second_name = second_name;
	}
	public double getAvg_mark() {
		return avg_mark;
	}
	public void setAvg_mark(double avg_mark) {
		this.avg_mark = avg_mark;
	}
	public String getGroup_number() {
		return group_number;
	}
	public void setGroup_number(String group_number) {
		this.group_number = group_number;
	}
	
}
