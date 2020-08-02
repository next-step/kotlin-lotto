package view

import model.Lotto

class ResultView {
    fun showLottoList(list: List<Lotto>) {
        for (lotto in list) {
            println(lotto.lottoNumber)
        }
        println()
    }

    fun showPrizeList(prizeList: List<Pair<Int, Int>>) {
        println(
            "당첨 통계\n" +
                "---------"
        )
        for (pair in prizeList) {
            if (pair.first == 3) {
                println("${pair.first}개 일치 (${MATCH_THIRD_PRIZE_MONEY}원)- ${pair.second}개")
            }
            if (pair.first == 4) {
                println("${pair.first}개 일치 (${MATCH_FOURTH_PRIZE_MONEY}원)- ${pair.second}개")
            }
            if (pair.first == 5) {
                println("${pair.first}개 일치 (${MATCH_FIFTH_PRIZE_MONEY}원)- ${pair.second}개")
            }
            if (pair.first == 6) {
                println("${pair.first}개 일치 (${MATCH_SIXTH_PRIZE_MONEY}원)- ${pair.second}개")
            }
        }
    }

    companion object {
        const val MATCH_THIRD_PRIZE_MONEY = 5000
        const val MATCH_FOURTH_PRIZE_MONEY = 50000
        const val MATCH_FIFTH_PRIZE_MONEY = 1500000
        const val MATCH_SIXTH_PRIZE_MONEY = 2000000000
    }
}
