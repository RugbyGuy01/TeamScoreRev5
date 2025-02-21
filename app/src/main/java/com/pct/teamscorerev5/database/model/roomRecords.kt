/*
Date: 02/21/2025 - Vinnie Gamble
This file contains all of the room records used by application.
Table names
CourseTable - The record contains the all course information
PlayerRecord - The record contain all of the player's information for the current round.
ScoreCardRecord - The record contains all of the information about the current round, course and players.
ScoreCardWithPlayers - The query returns all players assigned to the course being played.
PointsTable - The record holds points used for Point Quota and stableford.
JunkRecord - The record the game junk records
PlayerJunkTable - The record contains player index, hole number and junk id won for that hole.
EmailRecord - The record name contains the player's email address and name.
 */
package com.pct.teamscorerev5.database.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.pct.teamscorerev5.utils.HOLE_ARRAY_SIZE
import com.pct.teamscorerev5.utils.SCORE_CARD_REC_ID


@Entity(tableName = "CourseTable")
data class CourseRecord(
    val mCoursename: String = "",   // this is the database key for this course in the CourseListRecord class
    val mUsstate: String? = "NC",
    val mPar: IntArray = IntArray(HOLE_ARRAY_SIZE),
    val mHandicap: IntArray = IntArray(HOLE_ARRAY_SIZE),   // gross scores,
    val mNotes: Array<String> = Array(HOLE_ARRAY_SIZE) { "" },   // gross scores,
    @PrimaryKey(autoGenerate = true)    // default is false
    val mId: Int = 0,
)


@Entity(tableName = "PlayerRecord")
data class PlayerRecord(
    val mName: String = "",   // this is the database key for this course in the CourseListRecord class
    var mHandicap: String = "",
    val mScore: IntArray = IntArray(HOLE_ARRAY_SIZE),
    val mTeamHole: IntArray = IntArray(HOLE_ARRAY_SIZE),
    val mScoreCardRecFk: Int = SCORE_CARD_REC_ID,    // score card record ID
    @PrimaryKey(autoGenerate = false)    // default is false
    val mId: Int = 0,
)


@Entity(tableName = "ScoreCardRecord")
data class ScoreCardRecord(
    val mCourseName: String,    // current course name from the course list database
    val mTee: String,           // the tee's played or the course yardage
    val mDatePlayed: String,    // the day we play the game
    val mCurrentHole: Int = 0,   // the current hole being played in the game
    val mCourseId: Int = 0,      // the current course we are using for the score card
    val mPar: IntArray = IntArray(HOLE_ARRAY_SIZE),         // the current course Par
    val mHandicap: IntArray = IntArray(HOLE_ARRAY_SIZE),       // current course handicap
    @PrimaryKey
    val mScoreCardRecId: Int?,    // score card record ID
)

data class ScoreCardWithPlayers(
    @Embedded
    val scoreCardRecord: ScoreCardRecord,

    @Relation(
        parentColumn = "mScoreCardRecId",   // ties the score card record
        entityColumn = "mScoreCardRecFk"    //Link to score card
    )
    val playerRecords: List<PlayerRecord>,   // returns
)

@Entity(tableName = "PointsTable")
data class PointsRecord(
    @PrimaryKey(autoGenerate = true)    // default is false
    val mId: Int = 0,
    var mPoints: Int = 0,
    val label: String = "",
)

@Entity(tableName = "JunkTable")
data class JunkRecord(
    var mJunkName: String = "",
    @PrimaryKey(autoGenerate = true)    // autoGenerate is false
    var mId: Long = 1,
)


@Entity(tableName = "PlayerJunkTable")
data class PlayerJunkRecord(
    val mPlayerIdx: Int = 0,
    val mHoleNumber: Int = 0,
    val mJunkId: Long = 0,
    @PrimaryKey(autoGenerate = true)    // autoGenerate is false
    val mId: Long = 0,
)

@Entity(tableName = "EmailTable")
data class EmailRecord(
    var mEmailName: String = "",
    var mEmailAddress: String = "",
    @PrimaryKey(autoGenerate = true)    // autoGenerate is false
    val mId: Int = 0,
)
