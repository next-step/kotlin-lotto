package stringcalculator.core

data class Number(val number: Int) {
    constructor(str: String) : this(str.toIntOrNull() ?: throw RuntimeException("잘못된 값이 입력되었습니다."))

    init {
        if (number < 0) {
            throw RuntimeException("입력된 값이 음수 입니다.")
        }
    }

    operator fun plus(other: Number): Number {
        return Number((number + other.number).toString())
    }

    companion object {
        val ZERO = Number("0")
    }
}
