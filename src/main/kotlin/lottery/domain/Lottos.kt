package lottery.domain

data class Lottos(val lottos: List<Lotto>) {

    constructor(quantity: Int, numberGenerator: LottoNumberGenerator) : this(
        List(quantity) {
            Lotto.of(numberGenerator.getNumbers())
        }
    )

    fun matchLottos(winningLotto: WinningLotto): List<Rank> {
        return lottos.map { Rank.of(winningLotto.getMatchResult(it), winningLotto.getBonusMatchResult(it)) }
    }
}
