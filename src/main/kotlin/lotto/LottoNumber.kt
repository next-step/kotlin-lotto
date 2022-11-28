package lotto

data class LottoNumber(private var value: Int = 0) : Comparable<LottoNumber> {
    init {
        if (value == 0) {
            value = (LOTTO_MIN_VALUE..LOTTO_MAX_VALUE).random()
        }
        if (value > LOTTO_MAX_VALUE || value < LOTTO_MIN_VALUE) {
            throw IllegalArgumentException("로또 숫자는 $LOTTO_MIN_VALUE~${LOTTO_MAX_VALUE}를 넘을 수 없습니다.")
        }
    }

    override fun toString(): String {
        return "$value"
    }

    override fun compareTo(other: LottoNumber): Int {
        return this.value.compareTo(other.value)
    }

    companion object {
        private const val LOTTO_MIN_VALUE = 1
        private const val LOTTO_MAX_VALUE = 45
    }
}
