package lotto.domain

object LottoFactory {
    fun createLottos(count: Int): List<Lotto> {
        return List(count) { Lotto() }
    }
}
