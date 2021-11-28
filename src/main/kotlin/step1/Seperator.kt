package step1

/**
 *
 * @author Leo
 */
class Seperator {

    fun getNumbers(expression: String?): List<Int> {
        if (expression == null || expression == EMPTY) {
            return listOf(0)
        }

        val result = REGEX.find(expression)

        // custom seperator
        if (result != null) {
            val customSeperator = result.groupValues[1]
            return result.groupValues[2]
                .split(customSeperator)
                .map { it.toInt() }
        }

        return expression.split(COLON, COMMA).map { it.toInt() }
    }

    companion object {
        const val COLON = ":"
        const val COMMA = ","
        const val EMPTY = ""
        val REGEX = Regex("//(.)\n(.*)")
    }
}