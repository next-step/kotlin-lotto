package calculator

fun main() {
    val text = readln()

    val pattern = """(?:\/\/(.)\\n)*(.*)""".toRegex()
    require(pattern.matches(text)) { "invalid input detected." }

    val result = pattern.find(text)
    val tokens = result?.let { matchResult ->
        val customDelimiter = matchResult.groupValues[1]
        val tokens = matchResult.groupValues[2].split("[,:$customDelimiter]".toRegex())
        tokens
    } ?: listOf()

    val sum = tokens.sumOf { it.toInt() }
    println(sum)
}
