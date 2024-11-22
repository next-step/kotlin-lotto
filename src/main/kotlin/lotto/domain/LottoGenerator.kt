package lotto.domain

class LottoGenerator {
    fun getLottos(numberOfLottos: Int): List<Lotto> {
        return List(numberOfLottos) { Lotto() }
    }
}
