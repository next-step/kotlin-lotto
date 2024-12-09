package calculator

data class StringCalculator(val totalNumber: Int) {

    companion object {
        fun calculate(input: String?): Int {
            if (input.isNullOrBlank()) {
                return 0
            }

            if (input.length == 1 && input.all { it.isDigit() }) {
                return input.toInt()
            }

            val (delimiter, text) = parseDelimiterAndText(input)
            validate(text, delimiter)
            return splitString(text, delimiter)
        }

        private fun parseDelimiterAndText(input: String?): Pair<String, String?> {
            var delimiter = "[,:]"
            var text = input
            val result = text?.let { Regex("//(.)\n(.*)").find(it) }
            result?.let {
                delimiter = it.groupValues[1]
                text = it.groupValues[2]
            }
            return Pair(delimiter, text)
        }

        private fun validate(input: String?, delimiter: String) {
            if (
                Regex("[^\\d\n$delimiter//]").containsMatchIn(input.toString())) {
                throw RuntimeException()
            }
        }

        private fun splitString(
            inputString: String?,
            delimiter: String,
        ): Int {
            return inputString?.split(Regex(delimiter))?.map(String::toInt)
                ?.sum() ?: 0
        }
    }
}
