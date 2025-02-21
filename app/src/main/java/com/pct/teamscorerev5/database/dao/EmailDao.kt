/*
Date: 02/21/25 - Vinnie Gamble
 */
package com.pct.teamscorerev5.database.dao

import androidx.room.Query
import androidx.room.Upsert
import com.pct.teamscorerev5.database.model.EmailRecord

interface EmailDao {
    @Query("Select * FROM EmailTable")
    fun getAllEmailRecords(): List<EmailRecord>

    @Upsert
    suspend fun addUpdateEmailTableRecord(emailRecord: EmailRecord)

    @Query("SELECT * FROM EmailTable WHERE mId = :ptRecId")
    fun getEmailTableRecord(ptRecId: Int): EmailRecord

    @Query("SELECT (SELECT COUNT(*) FROM EmailTable) == 0")    // check for empty database
    fun isEmpty(): Boolean
}