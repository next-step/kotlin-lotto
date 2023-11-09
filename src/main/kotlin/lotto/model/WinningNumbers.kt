package lotto.model

data class WinningNumbers(
    val lottoNumbers: LottoNumbers,
    val bonusNumber: LottoNumber
) {

    fun countOfMatchAndHasBonus(game: Game): Pair<Int, Boolean> {
        val hasBunusNumber = game.lottoNumbers.hasBonusNumber(bonusNumber)
        return lottoNumbers.countOfMatchNumbers(game.lottoNumbers) to hasBunusNumber
    }
}
