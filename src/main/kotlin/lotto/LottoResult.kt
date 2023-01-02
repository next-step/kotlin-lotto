package lotto

class LottoResult(
    private val winningLotto: LottoNumbers,
    private val boughtLottos: List<LottoNumbers>
) {
    fun getRanks(): Ranks {
        return Ranks(boughtLottos.map { Rank.of(it.countMatchNumber(winningLotto.numbers)) })
    }
}
