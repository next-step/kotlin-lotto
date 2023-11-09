package lotto.model

data class WinningNumbers(
    val lottoNumbers: LottoNumbers,
    val bonusNumber: LottoNumber
) {

    fun countOfMatch(game: Game): Int {
        return lottoNumbers.countOfMatchNumbers(game.lottoNumbers)
    }
}
