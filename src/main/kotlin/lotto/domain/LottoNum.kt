package lotto.domain

data class LottoNum private constructor(val value: Int): Comparable<LottoNum> {

    init {
        verifyLottoNum(value)
    }

    private fun verifyLottoNum(value: Int) {
        require(value in 1..45) { "로또 숫자는 ${LOTTO_START_NUM}에서 $LOTTO_END_NUM 사이에 존재해야합니다." }
    }

    override fun compareTo(other: LottoNum): Int {
        return value - other.value
    }

    override fun toString(): String {
        return value.toString()
    }

    companion object {
        private const val LOTTO_START_NUM = 1
        private const val LOTTO_END_NUM = 45

        private val NUMBERS: Map<Int, LottoNum> = (LOTTO_START_NUM..LOTTO_END_NUM).associateWith(::LottoNum)

        fun of(value: Int): LottoNum {
            return NUMBERS[value] ?: throw IllegalArgumentException()
        }
    }

}