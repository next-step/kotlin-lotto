package lotto.view

import lotto.domain.Lotto

class OutputView {
    companion object {
        private const val PURCHASE_RESULT_MESSAGE = "개를 구매했습니다."

        fun printPurchaseResult(purchasedLottos: List<Lotto>) {
            println("${purchasedLottos.size} $PURCHASE_RESULT_MESSAGE")
            printLottoNumbers(purchasedLottos)
        }

        private fun printLottoNumbers(purchasedLottos: List<Lotto>) {
            purchasedLottos.forEach {
                println(it.lottoNumbers)
            }
            println()
        }

//        fun printLottoStatistics(lottoStatistics: Map<RankType, Int>) {
//            println("당첨통계")
//            println("---------")
//            RankType.entries
//                .filter { it != RankType.NO_RANK }
//                .sortedBy { it.matchCount }
//                .forEach { rankType ->
//                    val count = lottoStatistics[rankType] ?: 0
//                    printLottoResult(rankType, count)
//                }
//        }
//
//        private fun printLottoResult(rankType: RankType, count: Int) {
//            println("${rankType.matchCount}개 일치 (${rankType.price}원) - ${count}개")
//        }
    }
}
