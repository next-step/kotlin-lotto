package lotto

import lotto.domain.Lotto
import lotto.utils.LottoGenerator

class LottoManager {

    fun buyLotto(money: Int): List<Lotto> {
        val lottoBundle: MutableList<Lotto> = mutableListOf()

        val count = money / Lotto.ONE_PRICE
        repeat(count) {
            val lottoNumbers = LottoGenerator().getLottoNumbers().sorted()
            val lotto = Lotto(lottoNumbers)
            lottoBundle.add(lotto)
        }
        return lottoBundle.toList()
    }
}
