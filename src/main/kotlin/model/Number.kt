package model

class Number(val number: Int) {
    constructor(numberString: String) : this(numberString.toInt())

    init {
        if (!NUMBER_REGEX.matches(number.toString())) {
            throw IllegalArgumentException("only input number")
        }
        if (number < 0) {
            throw IllegalArgumentException("only input positive number")
        }
    }

    companion object {
        val NUMBER_REGEX = Regex(pattern = "^-?[0-9]\\d*(\\.\\d+)?\$")
    }
}
