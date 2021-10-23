package lotto.domain

class LottoGenerator(
    private val lottoNumberGenerator: LottoNumberGenerator = RandomNumberGenerator()
) {
    fun generateLottos(money: Money): List<Lotto> {
        return (1..money.getLottoCount())
            .map { lottoNumberGenerator.generateNumbers() }
            .map { Lotto(it) }
    }
}
