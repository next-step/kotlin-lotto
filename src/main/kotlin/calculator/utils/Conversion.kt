package calculator.utils

object Conversion {

    fun stringArrayToIntArray(strings: List<String>) =
        strings.map { it.toInt() }
}
