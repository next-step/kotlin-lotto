package lotto.domain

class Number private constructor(val number: Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Number

        if (number != other.number) return false

        return true
    }

    override fun hashCode(): Int {
        return number
    }

    companion object {
        private const val MINIMUM = 1
        private const val MAXIMUM = 45
        private val numbers = (MINIMUM..MAXIMUM).map { it to Number(it) }.toMap()

        fun getNumber(number: Int): Number {
            return numbers[number] ?: throw IllegalArgumentException("${number}는 로또 번호안에 있지 않습니다.")
        }
    }
}
