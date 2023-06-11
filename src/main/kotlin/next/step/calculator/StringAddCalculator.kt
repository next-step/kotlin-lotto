package next.step.calculator

object StringAddCalculator {
    fun add(command: String?): Int {
        if (command.isNullOrBlank()) {
            return 0
        }
        return parse(command).sumOf { toPositiveInt(it) }
    }

    private fun parse(command: String): List<String> {
        Regex("//(.)\n(.*)").find(command)?.let {
            return it.groupValues[2].split(it.groupValues[1])
        }
        return command.split("[,:]".toRegex())
    }

    private fun toPositiveInt(s: String): Int {
        val n = s.toInt()
        if (n < 0) {
            throw RuntimeException()
        }
        return n
    }
}