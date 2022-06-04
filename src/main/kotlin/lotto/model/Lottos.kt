package lotto.model

class Lottos(
    val lottos: List<Lotto>
) {
    val size = lottos.size

    fun findRanks(winningNumbers: Lotto, bonusNumber: LottoNumber) =
        lottos.map { it.findRank(winningNumbers, bonusNumber) }
}
