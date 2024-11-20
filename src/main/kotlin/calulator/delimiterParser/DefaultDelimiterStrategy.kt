package calulator.delimiterParser

class DefaultDelimiterStrategy : DelimiterStrategy {
    override fun support(text: String): Boolean {
        return true
    }

    override fun parse(text: String): List<Int> {
        return text.split(DEFAULT_DELIMITER.toRegex()).map { it.toInt() }
    }

    companion object {
        const val DEFAULT_DELIMITER = "[,:]"
    }
}
