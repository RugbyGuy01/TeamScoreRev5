package com.pct.teamscorerev5.database.converters
/*
Date: 02/21/25
arrayToString - Converts arrays integers to comma separated strings
stringToArray - Converts comma separated strings to arrays integers

used for the notes in the course file
stringArrayToString - Converts arrays strings to comma separated strings
stringToStringArray - Converts comma separated strings to arrays strings
 */
import androidx.room.TypeConverter


open class DataConverter {
    @TypeConverter
    fun arrayToString(myArray: IntArray): String {
        if (myArray.isEmpty()) {
            return ""
        }
        var str = myArray[0].toString()
        for (i in 1 until myArray.size) {
            str = str + "," + myArray[i].toString()
        }
        return str
    }

    @TypeConverter
    fun stringToArray(arrayString: String): IntArray {
        val holesList: List<String> = arrayString.split(",") // return a list of strings

        val holeInts = IntArray(holesList.size) { holesList[it].toInt() }

        return holeInts
    }

    @TypeConverter      // used for the notes in the course file
    fun stringArrayToString(myArray: Array<String>): String {
        if (myArray.isEmpty()) {
            return ""
        }
        var str = myArray[0]
        for (i in 1 until myArray.size) {
            str = str + "," + myArray[i]
        }
        return str
    }

    @TypeConverter   // used for the notes in the course file
    fun stringToStringArray(mNoteString: String): Array<String> {

        return mNoteString.split(",").toTypedArray<String>()
    }
}