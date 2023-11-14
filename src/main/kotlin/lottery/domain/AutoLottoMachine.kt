package lottery.domain

class AutoLottoMachine(private val lottoNumberGenerator: LottoNumberGenerator) {
    fun createLottos(lottoCount: Int): List<Lotto> {
        return List(lottoCount) {
            Lotto.of(lottoNumberGenerator.getNumbers())
        }
    }
}
