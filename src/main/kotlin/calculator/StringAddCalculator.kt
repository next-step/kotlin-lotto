package calculator

class StringAddCalculator (
    private val spliterator: Spliterator<String>
) {

    fun add(input: String?): Int = runCatching {
        require(input != null)
        spliterator.split(input).sumOf { it.toInt() }
    }.getOrDefault(0)

}
