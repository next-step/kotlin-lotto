data class StringCalculator(val totalNumber: Int) {
    /*constructor(inputString: String){
        totalNumber = splitString(inputString)
    }*/

    companion object {
        fun calculate(input: String): StringCalculator {
            var delimiter = "[,:]"
            var text = input
            val result = Regex("//(.)\\n(.*)").find(input)
            result?.let {
                delimiter = it.groupValues[1]
                text = it.groupValues[2]
            }
            validate(text, delimiter)
            return StringCalculator(splitString(text, delimiter))
        }

        private fun validate(input: String, delimiter: String) {
            if (Regex("[^:,\\d\\n$delimiter//]").containsMatchIn(input)) {
                throw RuntimeException()
            }
        }

        private fun splitString(
            inputString: String,
            delimiter: String,
        ) = inputString.split(Regex(delimiter)).map(String::toInt)
            .sum()
    }
}
