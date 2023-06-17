package lotto

class LottoManager(
    val lotto: Lotto
) {

    fun buyLotto(money: Int): List<List<Int>> {
        val lottoBundle: MutableList<List<Int>> = mutableListOf()

        val count = money / Lotto.ONE_PRICE
        repeat(count) {
            lottoBundle.add(lotto.generateNumbers())
        }
        return lottoBundle.toList()
    }
}
