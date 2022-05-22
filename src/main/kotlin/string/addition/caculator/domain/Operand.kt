package string.addition.caculator.domain

@JvmInline
value class Operand(val number: Int?) {

    init {
        number ?: run {
            throw RuntimeException("An operand from the input string should be a Number")
        }
        if (number < 0) {
            throw RuntimeException("An operand from the input string should be greater than zero")
        }
    }

    constructor(inputStr: String) : this(inputStr.toIntOrNull())

    companion object {
        val zero = Operand(0)
    }
}
