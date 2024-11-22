package lotto.domain

class LottoGenerator(private val setGenerator: SetGenerator = RandomSetGenerator()) {
    fun getLottos(numberOfLottos: Int): List<Lotto> {
        return List(numberOfLottos) { Lotto(setGenerator) }
    }
}
