package com.example.roomproject.Entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "student_guruh", foreignKeys = [
        ForeignKey(
            entity = Guruh::class,
            parentColumns = ["guruh_id"],
            childColumns = ["guruh"]
        )]
)
data class StudentGuruh(
    @PrimaryKey(autoGenerate = true)
    var student_id: Int,
    var guruh: Int
)
