object StringAddCalculator {
    fun add(command: String?): Int {
        if (command.isNullOrEmpty() || command.isBlank()) {
            return 0
        }
        val result = Regex("//(.)\n(.*)").find(command)
        result?.let {
            val customDelimiter = it.groupValues[1]
            val tokens = it.groupValues[2].split(customDelimiter)
            return tokens.sumOf { token -> token.toInt() }
        }
        return command.split("[,:]".toRegex()).sumOf { it.toInt() }
    }
}