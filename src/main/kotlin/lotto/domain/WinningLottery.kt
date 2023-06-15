package lotto.domain

data class WinningLottery(
    private val numbers: Set<LottoNumber>,
    val bonusBall: LottoNumber,
) : LotteryAdaptor(lottoNumbers = numbers) {

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
