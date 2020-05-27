package com.todos;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;  
import java.util.UUID;

public class Todos {
	String uniqueID;
	String text;
	Boolean isCompleted;
	String createdAt;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Todos [text=");
		builder.append(text);
		builder.append(", isCompleted=");
		builder.append(isCompleted);
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append(", uniqueID=");
		builder.append(uniqueID);
		builder.append("]");
		return builder.toString();
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getUniqueID() {
		return uniqueID;
	}
	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}
	public Todos(String text, Boolean isCompleted) {
		super();
		this.uniqueID = UUID.randomUUID().toString();
		this.text = text;
		this.isCompleted = false;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		this.createdAt = dtf.format(now);
	}
	public Boolean getIsCompleted() {
		return isCompleted;
	}
	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
}
