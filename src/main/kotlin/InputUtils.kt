private const val DELIMITER_1 = ","
private const val DELIMITER_2 = ";"

object InputUtils {
    fun splitByDefault(input: String): List<String> {
        return input.split(DELIMITER_1)
            .flatMap { it.split(DELIMITER_2) }
    }
}
