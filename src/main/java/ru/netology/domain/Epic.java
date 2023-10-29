package ru.netology.domain;

import java.util.Arrays;

public class Epic extends Task {
    private String[] subtask;


    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtask = subtasks;
    }

    @Override
    public boolean matches(String query) {
        if (Arrays.toString(subtask).contains(query)) {
            return true;
        }
        return false;
    }
}