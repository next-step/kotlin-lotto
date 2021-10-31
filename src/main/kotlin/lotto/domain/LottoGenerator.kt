package lotto.domain

class LottoGenerator(
    private val lottoNumberGenerator: LottoNumberGenerator
) {
    fun generateLottos(budget: Budget): List<Lotto> {
        return (1..budget.getTotalLottoCount())
            .map { lottoNumberGenerator.generateNumbers() }
            .map { Lotto(it) }
    }
}
