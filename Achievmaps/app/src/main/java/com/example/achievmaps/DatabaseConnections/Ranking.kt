package com.example.achievmaps.DatabaseConnections

import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

object Ranking {
    fun getByUser(personid: Int, type: String): String {
        var data = "-3"
        val url =
            URL("https://justsomephp.000webhostapp.com/getRanking.php?personid=" + personid.toString() + "&type=" + type)
        var urlConnection: HttpURLConnection? = null
        try {
            urlConnection = url.openConnection() as HttpURLConnection
            data = urlConnection.inputStream.bufferedReader().readText()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect()
            }
        }
        return data
    }
}