package lotto

class StringNumbers(stringNumbers: String) {
    val numbers: List<String>

    init {
        numbers = stringNumbers.split(",")
        require(stringNumbers.isNotEmpty()) { "input string delimiter" }
    }
}