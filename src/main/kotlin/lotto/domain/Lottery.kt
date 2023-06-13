package lotto.domain

import lotto.model.LottoErrorCode

@JvmInline
value class Lottery(private val numbers: Set<LottoNumber>) : Set<LottoNumber> by numbers {

    init {
        require(value = size == ALLOW_LOTTO_NUMBER_COUNT) {
            LottoErrorCode.INVALID_LOTTERY_NUMBER.message("$size $ALLOW_LOTTO_NUMBER_COUNT")
        }
    }

    fun correctNumberCount(otherLottery: Lottery): Int = this.count { it in otherLottery }

    override fun toString(): String = numbers.toString()

    companion object {
        private const val DELIMITER: Char = ','

        internal const val ALLOW_LOTTO_NUMBER_COUNT: Int = 6
        internal const val LOTTERY_PRICE: Double = 1000.0
    }
}
