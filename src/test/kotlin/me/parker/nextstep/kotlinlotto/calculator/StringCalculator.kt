package me.parker.nextstep.kotlinlotto.calculator

object StringCalculator {
    fun add(input: String): Int {
        val matchedResult = Regex("//(.)\n(.*)").find(input)
        val customSeparator = matchedResult?.groupValues?.get(1)
        val textAfterNewline = matchedResult?.groupValues?.get(2)
        println("customSeparator = $customSeparator")
        println("textAfterNewline = $textAfterNewline")

        if (!customSeparator.isNullOrEmpty() && !textAfterNewline.isNullOrEmpty()) {
            return textAfterNewline.split(",", ":", customSeparator).sumOf { it.toInt() }
        }

        return input.split(",", ":").sumOf { it.toInt() }
    }
}
