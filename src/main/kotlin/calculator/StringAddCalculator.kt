package calculator

import math.sum

class StringAddCalculator {

    fun add(text: String?): Int {
        return if (text.isNullOrBlank()) {
            0
        } else {
            StringParser.parse(text).sum()
        }
    }
}
