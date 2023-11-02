package calculator.component

object Sanitizer {
    fun sanitize(input: String?): String {
        if (input == null) {
            return ""
        }
        return input
    }
}
