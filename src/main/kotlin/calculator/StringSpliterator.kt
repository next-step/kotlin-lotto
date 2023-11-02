package calculator

class StringSpliterator: Spliterator<String> {

    private val commaParser: (List<String>) -> List<String> = { input -> input.flatMap { it.split(",") } }
    private val slashParser: (List<String>) -> List<String> = { input -> input.flatMap { it.split("/") } }

    private val parsers : List<(List<String>) -> List<String>> = listOf(
        commaParser,
        slashParser
    )

    override fun split(value: String): List<String> = parse(listOf(value), 0)

    private tailrec fun parse(strings: List<String>, index: Int) : List<String> {
        return if (index + 1 < parsers.size) parse(parsers[index].invoke(strings), index + 1)
            else strings
    }

}
