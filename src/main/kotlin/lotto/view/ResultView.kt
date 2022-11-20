package lotto.view

import lotto.domain.Lotto

class ResultView {

    fun printLotto(lottoList: List<Lotto>) {
        println("${lottoList.size}개를 구매했습니다.")
        lottoList.forEach {
            println(it.numbers)
        }
        println()
    }

    fun printLottoStatistics() {
        TODO("로또 당첨 통계 출력")
    }

    companion object {
        const val STATISTICS_GUIDE = "당첨 통계"
    }
}
