package lotto

class LottoManager {

    fun buyLotto(money: Int): List<List<Int>> {
        val lottoBundle: MutableList<List<Int>> = mutableListOf()

        val count = money / Lotto.ONE_PRICE
        repeat(count) {
            val lottoNumbers = LottoGenerator().getLottoNumbers()
            val lotto = Lotto(lottoNumbers)
            lottoBundle.add(lotto.numbers.sorted())
        }
        return lottoBundle.toList()
    }
}
