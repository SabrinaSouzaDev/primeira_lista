package com.primeira_lista.primeiro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String description;
  private boolean completed;

  // Getters e Setters
  public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

  public void setTitle(String title){
    this.title = title;
  }

  public void setDescription(String description){
    this.description = description;
  }

  public void setCompleted(boolean completed){
    this.completed = completed;
  }
  public boolean isCompleted(){
    return completed;
  }
  public String getTitle(){
    return title;
  }

  public String getDescription(){
    return description;
  }


}
