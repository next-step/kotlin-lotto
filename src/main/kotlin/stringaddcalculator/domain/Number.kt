package stringaddcalculator.domain

class Number {
    val value: Int

    constructor(number: String) {
        try {
            this.value = number.toInt()
        } catch (e: Exception) {
            throw IllegalArgumentException("$number 는 숫자가 아닙니다.")
        }
    }

    constructor(number: Int) {
        this.value = number
    }

    operator fun plus(number: Number): Number {
        return Number(number.value + this.value)
    }

    override fun toString(): String {
        return "$value"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Number

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value
    }

    companion object {
        val ZERO = Number(0)
    }
}
