package lotto

class StringNumbers(val numbers: List<String>) {
    init {
        require(numbers.isNotEmpty()) { "input string delimiter" }
    }
}
