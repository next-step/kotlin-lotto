package lotto.domain

import lotto.model.LottoErrorCode

data class WinningLottery(
    private val numbers: Set<LottoNumber>,
    val bonusBall: LottoNumber,
) : LotteryAdaptor(lottoNumbers = numbers) {

    init {
        check(value = bonusBall !in numbers) {
            LottoErrorCode.MUST_NOT_BE_INCLUDE_WINNING_NUMBER.message("$bonusBall $numbers")
        }
    }

    constructor(lotteryText: String, bonusBall: LottoNumber) : this(
        numbers = lotteryText.split(DELIMITER)
            .map(::LottoNumber)
            .toSet(),

        bonusBall = bonusBall,
    )

    companion object {
        private const val DELIMITER: Char = ','
    }
}
