package com.example.roomproject.Entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Marks", foreignKeys = [
        ForeignKey(
            entity = TeacherSubject::class,
            parentColumns = ["teacher_id"],
            childColumns = ["teacherSubject"]
        ),
        ForeignKey(
            entity = StudentGuruh::class,
            parentColumns = ["studentGuruh_id"],
            childColumns = ["studentGuruh"]
        )
    ]
)

data class Marks(
    @PrimaryKey(autoGenerate = true)
    var marks_id: Int = 0,
    var teacherSubject: Int,
    var studentGuruh: Int
)
