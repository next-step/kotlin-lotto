package stringcalculator.domain

class StringTokenizer {

    companion object {
        fun tokenize(numbersString: String): List<Int> {
            return numbersString.split(",", ":").map { it.toInt() }
        }
    }

}