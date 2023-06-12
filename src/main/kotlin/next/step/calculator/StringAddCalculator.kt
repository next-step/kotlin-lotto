package next.step.calculator

object StringAddCalculator {

    private val CUSTOM_COMMAND_PATTERN_REGEX = Regex("//(.)\n(.*)")
    private val DEFAULT_COMMAND_PATTERN_REGEX = "[,:]".toRegex()

    fun add(command: String?): Int {
        return if (command.isNullOrBlank()) 0 else parse(command).sumOf { toNonNegativeInt(it) }
    }

    private fun parse(command: String): List<String> {
        CUSTOM_COMMAND_PATTERN_REGEX.find(command)?.let {
            return it.groupValues[2].split(it.groupValues[1])
        }
        return command.split(DEFAULT_COMMAND_PATTERN_REGEX)
    }

    private fun toNonNegativeInt(token: String): Int {
        val n = token.toInt()
        require(n >= 0) { "음수는 토큰으로 사용될 수 없습니다." }
        return n
    }
}