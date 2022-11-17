package nextstep.mission.calculator

private val DEFAULT_SPLITTER = "[,:]".toRegex()

object InputParser {
    fun parse(input: String): List<Int> {
        return input.split(DEFAULT_SPLITTER).map { it.toInt() }
    }
}
