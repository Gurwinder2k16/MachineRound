package com.phonepee.machineround.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import java.io.InputStream


object CommonUtils {

    /*
     *  Parse to String and then Parse To Model POJO
     *
     * */
    private fun parseInputStreamToString(inputStream: InputStream): String? {
        return try {
            val bytes = ByteArray(inputStream.available())
            inputStream.read(bytes, 0, bytes.size)
            String(bytes)
        } catch (e: IOException) {
            null
        }
    }
}