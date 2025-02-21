/*
Date: 02/21/25 - Vinnie Gamble
 */
package com.pct.teamscorerev5.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.pct.teamscorerev5.database.model.PointsRecord

@Dao
interface PointsDao {
    @Query("Select * FROM PointsTable")
    fun getAllPointRecords(): List<PointsRecord>

    @Upsert
    suspend fun addUpdatePointTableRecord(pointsRecord: PointsRecord)

    @Query("SELECT * FROM PointsTable WHERE mId = :ptRecId")
    fun getPointTableRecord(ptRecId: Int): PointsRecord

    @Query("SELECT (SELECT COUNT(*) FROM PointsTable) == 0")    // check for empty database
    fun isEmpty(): Boolean
}