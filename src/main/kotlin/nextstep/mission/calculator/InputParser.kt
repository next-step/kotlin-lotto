package nextstep.mission.calculator

private val DEFAULT_SPLITTER = "[,:]".toRegex()

object InputParser {
    fun parse(input: String?): List<Int> {
        if (input == null) return emptyList()

        val result = Regex("//(.)\n(.*)").find(input)
        result?.let {
            val customDelimiter = it.groupValues[1]
            return it.groupValues[2].split(customDelimiter).map { s -> s.toInt() }
        }

        return input.split(DEFAULT_SPLITTER).map { it.toInt() }
    }
}
