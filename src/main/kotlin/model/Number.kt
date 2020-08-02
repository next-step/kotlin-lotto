package model

class Number(val number: Int) {
    init {
        if (!NUMBER_REGEX.matches(number.toString())) {
            throw IllegalArgumentException("only input number")
        }
    }

    companion object {
        val NUMBER_REGEX = Regex(pattern = "^-?[0-9]\\d*(\\.\\d+)?\$")
    }
}
