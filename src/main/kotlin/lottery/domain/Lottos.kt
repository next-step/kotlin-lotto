package lottery.domain

data class Lottos(val lottos: List<Lotto>) {

    constructor(quantity: Int, numberGenerator: LottoNumberGenerator) : this(
        List(quantity) {
            Lotto(numberGenerator.getNumbers())
        }
    )

    fun matchLottos(winningLotto: Lotto): List<Rank> {
        return lottos.map { Rank.of(it.getMatchResult(winningLotto)) }
    }
}
