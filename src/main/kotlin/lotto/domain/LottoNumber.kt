package lotto.domain

const val MIN_NUMBER = 1
const val MAX_NUMBER = 45

class LottoNumber(private val number: Int) {
    init {
        require(number in MIN_NUMBER..MAX_NUMBER) { "1~45 숫자만 입력 가능합니다." }
    }

    override fun toString(): String {
        return number.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LottoNumber

        if (number != other.number) return false

        return true
    }

    override fun hashCode(): Int {
        return number
    }
}
