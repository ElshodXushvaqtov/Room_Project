package com.example.roomproject.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import com.example.roomproject.Entity.StudentGuruh

@Dao
interface StudentGuruhDAO {
    @Insert
    fun addStudentGuruh(studentGuruh: StudentGuruh)

    @Delete
    fun deleteStudentGuruh(studentGuruh: StudentGuruh)
}