package calculator

class DefaultDelimiterStrategy : DelimiterStrategy {
    override fun supports(text: String): Boolean {
        return text.contains(",") || text.contains(":")
    }

    override fun parse(text: String): List<Int> {
        return text.split("[,:]".toRegex())
            .map { it.trim() }
            .filter { it.isNotEmpty() }
            .map { it.toInt() }
    }
}
