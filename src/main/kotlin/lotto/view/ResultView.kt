package lotto.view

import lotto.domain.Lotto

class ResultView {
    fun showLottoNums(lottoNums: MutableList<Lotto>) {
        println(LOTTO_COUNT_MSG.format(lottoNums.size))
        lottoNums.forEach { println(it.nums) }
        println()
    }

    companion object {
        private const val LOTTO_COUNT_MSG = "%d개를 구매했습니다."
    }
}
