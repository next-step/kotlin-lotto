package lotto.domain

class LottoMachine(private val lottoNumberGenerator: LottoNumberGenerator = RandomLottoNumberGenerator()) {
    fun makeLottos(numberOfLottos: Int): Lottos {
        return Lottos(List(numberOfLottos) { Lotto(lottoNumberGenerator) })
    }
}
