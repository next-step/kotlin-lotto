package lotto

object LottoStore {
    fun buy(money: Int): List<Lotto> {
        val lottos = mutableListOf<Lotto>()
        repeat(money / Lotto.PRICE) {
            lottos.add(Lotto())
        }
        return lottos
    }
}
