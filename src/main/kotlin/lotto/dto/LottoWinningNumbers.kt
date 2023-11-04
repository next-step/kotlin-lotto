package lotto.dto

data class LottoWinningNumbers(
    val lottoNumbers: LottoNumbers,
    val bonusNumber: Int
) {
    init {
        require(bonusNumber in LottoNumbers.LOTTO_NUMBER_RANGE) { "보너스 번호 범위는 1 ~ 45여야 합니다." }
        require(bonusNumber !in lottoNumbers.numbers) { "보너스 번호는 당첨 번호와 중복되지 않아야 합니다." }
    }

    fun compareLottoNumbers(lottoNumbers: LottoNumbers): LottoPrice {
        val count = lottoNumbers.compareLottoNumbers(this.lottoNumbers)
        val bonus = lottoNumbers.numbers.contains(bonusNumber)
        return when (count) {
            5 -> if (bonus) LottoPrice.FIVE_MATCHED_WITH_BONUS else LottoPrice.FIVE_MATCHED
            else -> LottoPrice.from(count)
        }
    }
}
