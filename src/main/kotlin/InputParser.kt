object InputParser {
    fun isParsableByDefaultDelimiter(input: String): Boolean {
        val tokens = parse(input)
        if (tokens[0] != input) {
            return true
        }
        return tokens[0] == input && tokens[0].toIntOrNull() != null
    }

    fun parse(input: String): List<String> {
        return input.split("[,:]".toRegex())
    }

    fun parseByCustomDelimiter(input: String): List<String> {
        Regex("//(.)\n(.*)").find(input)?.let { result ->
            val customDelimiter = result.groupValues[1]
            return result.groupValues[2].split(customDelimiter)
        } ?: return listOf()
    }
}
