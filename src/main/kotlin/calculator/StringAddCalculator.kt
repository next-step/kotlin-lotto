package calculator

import calculator.utils.StringUtil

@JvmInline
value class StringAddCalculator(private val text: String) {

    fun add(): Int = when (text.isNotBlank()) {
        true -> toInts(StringUtil.convertTextToList(text)).sumOf { it }.toInt()
        false -> ZERO
    }

    private fun toInts(convertTextToList: List<String>): List<UInt> = convertTextToList.map {
        it.toUInt()
    }

    companion object {
        private const val ZERO = 0
    }
}
