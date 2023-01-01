package lotto

class LottoResult(
    private val winningLotto: LottoNumbers,
    private val boughtLottos: List<LottoNumbers>
) {
    fun getRanks(): Ranks {
        return Ranks(
            boughtLottos.map { boughtLotto ->
                Rank.of(boughtLotto.numbers.count { winningLotto.numbers.contains(it) })
            }
        )
    }
}
