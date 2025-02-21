package com.pct.teamscorerev5.database.dao
/*
Date: 02/21/25 - Vinnie Gamble
 */
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.pct.teamscorerev5.database.model.ScoreCardRecord
import com.pct.teamscorerev5.database.model.ScoreCardWithPlayers

@Dao
interface ScoreCardDao {
    /* Score Card DAO interfaces */
    @Upsert
    suspend fun addUpdateScoreCardRecord(scoreCardRecord: ScoreCardRecord)

    @Query("Select * FROM ScoreCardRecord WHERE mScoreCardRecId = :scoreCardId ")
    fun getScoreCardRecord(scoreCardId: Int): ScoreCardRecord

    @Transaction
    @Query("Select * FROM ScoreCardRecord WHERE mScoreCardRecId = :scoreCardId ")
    fun getScoreRecordWithPlayers(scoreCardId: Int?): ScoreCardWithPlayers

    @Query("SELECT EXISTS(SELECT * FROM ScoreCardRecord WHERE mScoreCardRecId = :scoreCardId)")
    fun isRowIsExist(scoreCardId : Int) : Boolean
}