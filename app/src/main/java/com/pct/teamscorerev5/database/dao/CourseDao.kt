/*
Date: 02/21/25 - Vinnie Gamble
 */
package com.pct.teamscorerev5.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.pct.teamscorerev5.database.model.CourseRecord

interface CourseDao {
    @Query("SELECT * FROM CourseTable WHERE mId = :courseId ")
    fun getCourseRecord(courseId: Int?): CourseRecord

    @Query("Select * FROM CourseTable ORDER BY mCoursename ASC")
    fun getAllCoursesRecordAsc(): LiveData<List<CourseRecord>>

    @Delete
    fun deleteCourseRecord(courseRecord: CourseRecord)

    @Upsert
    fun addUpdateCourseRecord(courseRecord: CourseRecord)      // Add and update

    @Query("SELECT (SELECT COUNT(*) FROM CourseTable) == 0")    // check for empty database
    fun isEmpty(): Boolean
}