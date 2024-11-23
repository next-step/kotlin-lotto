package lotto.domain

class LottoMachine(private val lottoNumberGenerator: LottoNumberGenerator = RandomLottoNumberGenerator()) {
    fun makeLottos(numberOfLottos: Int): List<Lotto> {
        return List(numberOfLottos) { Lotto(lottoNumberGenerator) }
    }
}
