package lotto.domain

class LottoGenerator(
    private val lottoNumberGenerator: LottoNumberGenerator
) {
    fun generateLottos(budget: Budget): List<Lotto> {
        return (1..budget.getLottoCount())
            .map { lottoNumberGenerator.generateNumbers() }
            .map { Lotto(it) }
    }
}
