package lotto.domain

data class Lotto(
    private val lottoNumbers: LottoNumbers,
) {
    fun joinToLottoNumbersString(
        separator: CharSequence = LOTTO_NUMBERS_SEPARATOR,
        prefix: CharSequence = LOTTO_NUMBERS_PREFIX,
        postfix: CharSequence = LOTTO_NUMBERS_POSTFIX,
    ): String = lottoNumbers.numbers.joinToString(separator, prefix, postfix)

    fun matchLotto(
        winnerNumbers: LottoNumbers,
        bonusNumber: LottoNumber,
    ): LottoRank {
        val matchingNumbers = lottoNumbers.countMatches(winnerNumbers)
        val matchingBonus = lottoNumbers.contains(bonusNumber)
        return LottoRank.from(matchingNumbers, matchingBonus)
    }

    companion object {
        const val LOTTO_PRICE = 1000
        private const val LOTTO_NUMBERS_SEPARATOR = ", "
        private const val LOTTO_NUMBERS_PREFIX = ""
        private const val LOTTO_NUMBERS_POSTFIX = ""
    }
}
