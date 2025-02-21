/*
Date: 02/21/25 - Vinnie Gamble
 */
package com.pct.teamscorerev5.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.pct.teamscorerev5.database.model.PlayerJunkRecord


@Dao
interface PlayerJunkDao {
    @Query("Select * FROM PlayerJunkTable")
    fun getAllPlayerJunkRecords(): List<PlayerJunkRecord>

    @Upsert
    suspend fun addUpdatePlayerJunkTableRecord(playerJunkRecord: PlayerJunkRecord)

    @Query("SELECT * FROM PlayerJunkTable WHERE mPlayerIdx = :playerIdx AND mHoleNumber = :currentHole")
    fun getPlayerJunkTableRecords(playerIdx: Int, currentHole:Int): List<PlayerJunkRecord>

    @Query("SELECT COUNT(*) FROM PlayerJunkTable WHERE mPlayerIdx = :playerIdx AND mHoleNumber = :currentHole")
    fun getPlayerJunkRecordsCnt(playerIdx: Int, currentHole:Int): Int

    @Query("SELECT * FROM PlayerJunkTable WHERE mPlayerIdx = :playerIdx")
    fun getAllPlayerJunkPayoutRecords(playerIdx: Int): List<PlayerJunkRecord>

    @Insert
    suspend fun insertJunkTableRecord(playerJunkRecord: PlayerJunkRecord):Long   // return the rec Id

    @Query("DELETE  FROM PlayerJunkTable")
    fun  deleteAllPlayersJunkTableRecord()

    @Delete
    fun deleteJunkTableRecord(playerJunkRecord: PlayerJunkRecord)

    @Query("SELECT (SELECT COUNT(*) FROM PlayerJunkTable) == 0")    // check for empty database
    fun isEmpty(): Boolean
}