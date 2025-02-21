/*
Date: 02/21/25 - Vinnie Gamble
 */
package com.pct.teamscorerev5.database.dao

import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.pct.teamscorerev5.database.model.JunkRecord

interface JunkDao {
    @Query("Select * FROM JunkTable ORDER BY mJunkName ASC")
    fun getAllJunkRecords(): List<JunkRecord>

    @Insert
    suspend fun insertJunkTableRecord(junkRecord: JunkRecord):Long   // return the rec Id

    @Update
    suspend fun updateJunkTableRecord(junkRecord: JunkRecord)   //

    @Query("DELETE FROM JunkTable WHERE mId = :junkId")
    fun deleteRecordById(junkId: Long)

    @Query("SELECT * FROM JunkTable WHERE mId = :ptRecId")
    fun getJunkTableRecord(ptRecId: Int): JunkRecord

    @Query("SELECT (SELECT COUNT(*) FROM JunkTable) == 0")    // check for empty database
    fun isEmpty(): Boolean
}