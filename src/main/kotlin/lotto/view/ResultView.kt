package lotto.view

import lotto.domain.LottoList
import lotto.domain.LottoNumber
import lotto.domain.LottoRank
import lotto.domain.LottoResultList
import lotto.domain.Money

object ResultView {
    fun printLottoList(lottoList: LottoList) {
        println("${lottoList.size}개를 구매했습니다.")
        for (lotto in lottoList.lottoList) {
            printLottoNumbers(lotto.lottoNumbers.numbers)
        }
    }

    private fun printLottoNumbers(numbers: List<LottoNumber>) {
        print("[")
        numbers.forEachIndexed { index, number ->
            print(number.number)
            printComma(index == numbers.size - 1)
        }
        println("]")
    }

    private fun printComma(isLast: Boolean) {
        if (!isLast) print(", ")
    }

    fun printResult(result: LottoResultList, purchaseAmount: Money) {
        println("당첨 통계")
        println("------------")
        val ranks = LottoRank.values().filter { it != LottoRank.NONE }.reversed()
        for (rank in ranks) {
            printRankResult(rank, result.count(rank))
        }
        println("총 수익률은 ${result.getProfitRate(purchaseAmount.amount)}입니다.")
    }

    private fun printRankResult(rank: LottoRank, count: Int) {
        println("${rank.containCount}개 일치 (${rank.money}원)- ${count}개")
    }
}
