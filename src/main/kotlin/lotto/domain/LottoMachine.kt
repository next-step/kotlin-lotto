package lotto.domain

class LottoMachine(private val lottoNumberGenerator: LottoNumberGenerator = RandomLottoNumberGenerator()) {
    fun makeLottosAuto(numberOfLottos: Int): Lottos {
        return Lottos(List(numberOfLottos) { Lotto(lottoNumberGenerator) })
    }

    fun makeLottosSelected(selectedlottoNumbersList: List<LottoNumbers> = listOf()): Lottos {
        return Lottos(selectedlottoNumbersList.map { Lotto.of(it) })
    }
}
