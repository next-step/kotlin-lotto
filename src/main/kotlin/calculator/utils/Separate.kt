package calculator.utils

object Separate {

    fun findSeparator(str: String) =
        Regex("(?<=//)(.*?)(?=\n)").find(str)?.value ?: ""

    fun divideBySeparator(separator: String?, text: String): List<String> {
        if (separator.isNullOrBlank()) return text.split(Regex("[,:]"))
        return text.substringAfter("\n").split(separator)
    }
}
