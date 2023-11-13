package lotto.model

data class WinningNumbers(
    val lottoNumbers: LottoNumbers,
    val bonusNumber: LottoNumber
) {

    fun toRank(game: Game): Rank {
        return Rank.of(
            lottoNumbers.numbersIntersections(game.lottoNumbers),
            game.lottoNumbers.containNumber(bonusNumber)
        )
    }
}
