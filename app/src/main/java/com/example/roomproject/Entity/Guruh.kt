package com.example.roomproject.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Guruhlar")
data class Guruh(
    @PrimaryKey(autoGenerate = true)
    var guruh_id:Int=0,
    var sinf_name:String
)
