package lotto

class LottoResult(
    private val winningLotto: WinningLottoNumbers,
    private val boughtLottos: List<LottoNumbers>
) {
    fun getRanks(): Ranks {
        return Ranks(
            boughtLottos.map {
                Rank.from(
                    matchCount = it.countMatchNumber(winningLotto.getAllNumbers()),
                    isBonus = it.isContainNumber(winningLotto.bonusNumber)
                )
            }
        )
    }
}
