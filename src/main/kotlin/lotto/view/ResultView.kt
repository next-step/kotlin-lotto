package lotto.view

import lotto.domain.Lotto

class ResultView {

    fun showLottoCount(count: Int) {
        println(LOTTO_COUNT_MSG.format(count))
    }

    fun showLottoNums(lottoNums: MutableList<Lotto>) {
        lottoNums.forEach { println(it.nums) }
    }

    companion object {
        private const val LOTTO_COUNT_MSG = "%d개를 구매했습니다."
    }
}
