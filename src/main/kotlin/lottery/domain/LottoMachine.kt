package lottery.domain

class LottoMachine(private val lottoNumberGenerator: LottoNumberGenerator) {
    fun createLottos(lottoCount: Int): List<Lotto> {
        return (1..lottoCount).map { Lotto.of(lottoNumberGenerator.getNumbers()) }
    }
}
