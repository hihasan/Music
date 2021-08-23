package com.hihasan.music.utils;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.hihasan.music.constants.DatabaseConstants;

@Database(entities = {}, version = DatabaseConstants.DATABASE_VERSION, exportSchema = false)
public abstract class BaseDatabase extends RoomDatabase {
}
