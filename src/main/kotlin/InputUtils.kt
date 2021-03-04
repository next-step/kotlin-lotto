private const val DELIMITER_1 = ","
private const val DELIMITER_2 = ";"
private const val ZERO = "0"

object InputUtils {
    fun split(input: String): List<String> {
        if (input.startsWith("//")) {
            if (input.substring(3).startsWith("\\n")){
                val customDelimiter = input.elementAt(2)
                val sub = input.substring(5)
                val ret = sub.split(customDelimiter)
                return ret
            }
        }

        if (input.isBlank()) {
            return listOf(ZERO)
        }

        return input.split(DELIMITER_1)
            .flatMap { it.split(DELIMITER_2) }
    }
}
