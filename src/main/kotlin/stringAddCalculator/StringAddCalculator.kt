package stringAddCalculator

import java.lang.RuntimeException

class StringAddCalculator {
    fun add(text: String): Int {
        if (text.isBlank()) return 0
        if (text.length == 1) return text.toInt()
        val texts = text.split(",", ":").map {
            val number = it.toInt()
            if (number < 0) throw RuntimeException("sdf")
            number
        }
        return texts.reduce { total, number -> total + number }
    }
}
