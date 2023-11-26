package lotto

class LottoStore {

    fun sell(money: Int): List<Lotto> {
        val count = money / Lotto.PRICE
        val lottos = mutableListOf<Lotto>()
        for (i in 1..count) {
            lottos.add(Lotto())
        }
        return lottos
    }
}
