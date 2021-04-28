package Goldberg

import java.lang.Exception

enum class MyBool {
    TRUE,
    FALSE
}

object ValidateData {
    private const val errorName = "NotNumber"
    private var arr = arrayOf<String>()

    fun checkData(listData: List<String?>) : MyBool {
        for (element in listData) {
            val temp = element ?: errorName
            arr = appendArray(arr, temp)
        }
        if (arr.contains(errorName) || arr.size != 2) {
            return MyBool.FALSE
        }

        val pairData = arr[0] to arr[1]

        if(isDigit(pairData.first) == MyBool.TRUE && pairData.second.matches(Regex("[-+]?\\d+"))) {
            return MyBool.TRUE
        }
        return MyBool.FALSE
    }

    private fun appendArray(arr: Array<String>, element: String): Array<String> {
        val list: MutableList<String> = arr.toMutableList()
        list.add(element)
        return list.toTypedArray()
    }

    private fun isDigit(data: String): MyBool {
        return try {
            Integer.parseInt(data)
            MyBool.TRUE
        } catch (e: Exception) {
            MyBool.FALSE
        }
    }
}