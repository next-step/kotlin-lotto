package lottery.domain

data class Lottos(
    val lottos: List<Lotto>
) {
    fun matchLottos(winningLotto: Lotto): List<Rank> {
        return lottos.map { Rank.of(it.getMatchResult(winningLotto).size) }
    }

    companion object {
        fun of(quantity: Int, numberGenerator: LottoNumberGenerator): Lottos {
            return Lottos(
                List(quantity) {
                    Lotto(numberGenerator.getNumbers())
                }
            )
        }
    }
}
