package com.example.taskmanager.entity;
import java.util.Date;



public class TaskEntity {
        private int Id;
        private String title;
        private String description;
        private Date deadline;
        private boolean completed;

        public TaskEntity(){}



        public int getId() {
                return Id;
        }

        public void setId(int id) {
                Id = id;
        }

        public String getTitle(){
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }
        public String getDescription(){
                return description;
        }

        public void setDescription(String description){
                this.description = description;
        }

        public Date getDeadline(){
                return deadline;
        }

        public void setDeadline(Date deadline){
                this.deadline = deadline;
        }

        public void setCompleted(boolean b){
                this.completed = b;
        }






}
