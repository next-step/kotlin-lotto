data class StringCalculator(val totalNumber: Int) {
    /*constructor(inputString: String){
        totalNumber = splitString(inputString)
    }*/

    companion object {
        fun calculate(input: String): StringCalculator {
            val result = Regex("//(.)\\n(.*)").find(input)
            result?.let {
                val customDelimiter = it.groupValues[1]
                val customInput = it.groupValues[2]
                return StringCalculator(splitString(customInput, customDelimiter))
            }
            return StringCalculator(splitString(input, "[,:]"))
        }

        private fun splitString(
            inputString: String,
            delimiter: String,
        ) = inputString.split(Regex(delimiter)).map(String::toInt)
            .sum()
    }
}
