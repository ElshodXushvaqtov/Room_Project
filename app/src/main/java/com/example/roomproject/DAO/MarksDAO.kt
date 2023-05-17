package com.example.roomproject.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import com.example.roomproject.Entity.Marks


@Dao
interface MarksDAO {

    @Insert
    fun addMarks(marks: Marks)

    @Delete
    fun deleteMarks(marks: Marks)

}