/*
Date: 02/21/25 - Vinnie Gamble
 */
package com.pct.teamscorerev5.database.dao

import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.pct.teamscorerev5.database.model.PlayerRecord

// Player's record
interface PlayerDao {
    @Query("Select * FROM PlayerRecord")
    fun getAllPlayerRecords(): List<PlayerRecord>

    @Query("DELETE  FROM PlayerRecord")
    fun deleteAllPlayersRecord()

    @Upsert
    suspend fun addUpdatePlayerRecord(playerRecord: PlayerRecord)

    @Delete
    suspend fun deleteDeletePlayerRecord(playerRecord: PlayerRecord)

    @Query("SELECT * FROM PlayerRecord WHERE mScoreCardRecFk = :scoreCardRecId AND mId = :playerID")
    fun getPlayerRecord(playerID: Int, scoreCardRecId: Int): PlayerRecord

    @Query("UPDATE PlayerRecord SET mName = :name, mHandicap = :handicap WHERE mId =:index")
    fun updatePlayer(index: Int, name: String, handicap: Int)

}