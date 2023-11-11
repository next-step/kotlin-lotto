package lotto.model

data class WinningNumbers(
    val lottoNumbers: LottoNumbers,
    val bonusNumber: LottoNumber
) {

    fun countOfMatchAndHasBonus(game: Game): Pair<Int, Boolean> {
        val hasBonusNumber = game
            .lottoNumbers
            .containNumber(bonusNumber)
        return lottoNumbers
            .countOfMatchNumbers(game.lottoNumbers) to hasBonusNumber
    }
}
