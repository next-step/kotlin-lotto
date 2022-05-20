package calculator.processor

import calculator.model.PositiveNumber

class InputProcessor {
    fun convertStringToList(text: String?): List<PositiveNumber> {
        val notEmptyText = convertStringToZeroIfNull(text)
        return notEmptyText.split(DEFAULT_DELIMITER_REGEX.toRegex())
            .map { PositiveNumber(it.trim()) }
    }

    private fun convertStringToZeroIfNull(text: String?) =
        if (text.isNullOrBlank()) {
            ZERO_STR
        } else {
            text
        }

    companion object {
        private const val ZERO_STR = "0"
        private const val DEFAULT_DELIMITER_REGEX = ",|:"
    }
}
