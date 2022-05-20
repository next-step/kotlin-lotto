package calculator.processor

class InputProcessor {
    fun convertStringToZeroIfNull(text: String?) =
        if (text.isNullOrBlank()) {
            ZERO_STR
        } else {
            text
        }

    companion object {
        private const val ZERO_STR = "0"
    }
}
