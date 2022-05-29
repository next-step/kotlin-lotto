package lotto.domain

class LottoNumber(val number: Int) {
    init {
        require(Lotto.LOTTO_NUMBER_RANGE.contains(number)) {
            "로또 번호는 ${Lotto.LOTTO_NUMBER_RANGE} 에 있어야 합니다."
        }
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

    override fun toString(): String {
        return number.toString()
    }
}
