package lotto.domain

data class Lottery(private val numbers: Set<LottoNumber>) : LotteryAdaptor(lottoNumbers = numbers) {

    constructor(lotteryText: String) : this(
        numbers = lotteryText.split(DELIMITER)
            .map(::LottoNumber)
            .toSet()
    )

    companion object {
        private const val DELIMITER: Char = ','
    }
}
