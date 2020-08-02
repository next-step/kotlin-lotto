package lotto.domain

import lotto.domain.value.LottoNumber
import lotto.view.ResultLotto

class LottoItems(count: Int) {
    private val lottos: List<Lotto> = List(count) { Lotto() }

    fun getLottoItems() = lottos

    fun getWinLottos(winningNumbers: List<LottoNumber>): List<ResultLotto> {
        lottos.forEach {
            val a = it.getWinCount(winningNumbers)
            ResultLotto.plusCount(a)
        }
        return ResultLotto.resultList()
    }
}
