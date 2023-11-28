package lotto.model

data class WinningNumbers(
    val lottoGame: LottoGame,
    val bonusNumber: LottoNumber
) {

    fun toRank(otherGame: LottoGame): Rank {
        return Rank.of(
            this.lottoGame.numbersIntersections(otherGame),
            otherGame.containNumber(this.bonusNumber)
        )
    }
}
