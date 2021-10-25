package calculator

import calculator.utils.StringUtil

@JvmInline
value class StringAddCalculator(private val text: String) {

    fun add() = when (text.isNotBlank()) {
        true -> StringUtil.convertTextToList(text).sumOf { it.toInt() }
        false -> 0
    }
}
