package com.example.roomproject.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.roomproject.Entity.TeacherSubject

@Dao
interface TeacherSubjectDAO {
    @Insert
    fun addTeacherSubjec(teacherSubject: TeacherSubject)

    @Delete
    fun deleteTeacherSubject(teacherSubject: TeacherSubject)


    @Query("select * from teacher_subjects where teacher_id = :id")
    fun getTeacherSubjectById(id:Int): TeacherSubject

}