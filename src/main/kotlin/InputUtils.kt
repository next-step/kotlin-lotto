private const val DELIMITER_1 = ","
private const val DELIMITER_2 = ";"
private const val ZERO = "0"

object InputUtils {
    fun splitByDefault(input: String): List<String> {
        if (input.isBlank()) {
            return listOf(ZERO)
        }

        return input.split(DELIMITER_1)
            .flatMap { it.split(DELIMITER_2) }
    }
}
