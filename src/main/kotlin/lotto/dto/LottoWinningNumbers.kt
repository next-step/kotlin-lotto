package lotto.dto

data class LottoWinningNumbers(
    val lottoNumbers: LottoNumbers,
    val bonusNumber: LottoNumber
) {
    init {
        require(bonusNumber !in lottoNumbers.numbers) { "보너스 번호는 당첨 번호와 중복되지 않아야 합니다." }
    }

    constructor(lottoNumbers: LottoNumbers, bonusNumber: Int) : this(lottoNumbers, LottoNumber(bonusNumber))

    fun compareLottoNumbers(lottoNumbers: LottoNumbers): LottoPrice {
        val count = lottoNumbers.matchedLottoNumberCount(this.lottoNumbers)
        val bonus = bonusNumber in lottoNumbers
        return when (count) {
            5 -> if (bonus) LottoPrice.FIVE_MATCHED_WITH_BONUS else LottoPrice.FIVE_MATCHED
            else -> LottoPrice.from(count)
        }
    }
}
