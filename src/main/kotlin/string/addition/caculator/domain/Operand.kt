package string.addition.caculator.domain

data class Operand(private val inputStr: String) {
    var number: Int
        private set

    init {
        require(inputStr.toIntOrNull() != null) {
            throw RuntimeException("An operand from the input string should be a Number")
        }
        number = inputStr.toInt()

        require(number > 0) {
            throw RuntimeException("An operand from the input string should be greater than zero")
        }
    }
}
