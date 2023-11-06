package calculator

object StringSpliterator : Spliterator<String> {

    private const val DELIMITER = 1
    private const val CONTENT = 2
    private val customizeDelimiter = "^//(.)\\n(.*)".toRegex()
    private val defaultDelimiter = "[,:]".toRegex()
    private val splitCustomizeDelimiter: (String) -> List<String> = { input ->
        customizeDelimiter.matchEntire(input)?.let { match ->
            val delimiter = match.groupValues[DELIMITER]
            match.groupValues[CONTENT].split(delimiter)
        } ?: listOf(input)
    }
    private val splitDefaultDelimiter: (List<String>) -> List<String> = { input ->
        input.flatMap { it.split(defaultDelimiter) }
    }
    override fun split(value: String): List<String> = splitDefaultDelimiter(splitCustomizeDelimiter(value))
}
