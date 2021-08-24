package com.hihasan.music.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "test")
public class TestEntity {
    @PrimaryKey(autoGenerate = true)
    public int sl_no;
}
