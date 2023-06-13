package lotto.domain

import lotto.model.LottoErrorCode

@JvmInline
value class Lottery(private val numbers: Set<LottoNumber>) : Set<LottoNumber> by numbers {

    init {
        require(value = size == ALLOW_LOTTO_NUMBER_COUNT) {
            LottoErrorCode.INVALID_LOTTERY_NUMBER.message("$size $ALLOW_LOTTO_NUMBER_COUNT")
        }
    }

    constructor(lotteryText: String) : this(
        numbers = lotteryText.split(DELIMITER)
            .map(::LottoNumber)
            .toSet()
    )

    fun correctNumberCount(otherLottery: Lottery): LottoMatchResult = LottoMatchResult(
        countOfMatch = this.count { it in otherLottery },
    )

    override fun toString(): String = numbers.toString()

    companion object {
        private const val DELIMITER: Char = ','

        internal const val ALLOW_LOTTO_NUMBER_COUNT: Int = 6
        internal const val LOTTERY_PRICE: Double = 1000.0
    }
}
