data class StringCalculator(val totalNumber: Int) {

constructor(inputString: String) : this(
    splitString(inputString)
    )

    companion object {
        private fun splitString(inputString: String): Int {
              return inputString.split(Regex("[,:]")).map(String::toInt)
                  .sum()
        }
    }

}
