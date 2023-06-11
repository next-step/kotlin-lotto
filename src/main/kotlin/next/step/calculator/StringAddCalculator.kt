package next.step.calculator

object StringAddCalculator {

    private val CUSTOM_COMMAND_PATTERN_REGEX = Regex("//(.)\n(.*)")
    private val DEFAULT_COMMAND_PATTERN_REGEX = "[,:]".toRegex()

    fun add(command: String?): Int {
        if (command.isNullOrBlank()) {
            return 0
        }
        return parse(command).sumOf { toPositiveInt(it) }
    }

    private fun parse(command: String): List<String> {
        CUSTOM_COMMAND_PATTERN_REGEX.find(command)?.let {
            return it.groupValues[2].split(it.groupValues[1])
        }
        return command.split(DEFAULT_COMMAND_PATTERN_REGEX)
    }

    private fun toPositiveInt(token: String): Int {
        val n = token.toInt()
        if (n < 0) {
            throw RuntimeException()
        }
        return n
    }
}