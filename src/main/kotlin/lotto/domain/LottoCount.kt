package lotto.domain

class LottoCount private constructor(
    val value: Int
) : Comparable<LottoCount> {
    init {
        require(value >= ZERO_VALUE) {
            "로또 카운트는 ${ZERO_VALUE}를 포함한 양수만 허용됩니다"
        }
    }

    fun isEmpty(): Boolean {
        return value == ZERO_VALUE
    }

    override fun compareTo(other: LottoCount): Int {
        return value - other.value
    }

    companion object {
        private const val ZERO_VALUE = 0

        fun from(value: Int): LottoCount {
            return LottoCount(value)
        }
    }
}
