package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoBundle
import lotto.domain.LottoRecord
import lotto.enums.Rank

object OutputView {

    fun printPurchaseQuantity(quantity: Int) {
        println("${quantity}개를 구매했습니다.")
    }

    fun printPurchaseLottoBundle(lottoBundle: LottoBundle) {
        lottoBundle.bundle.forEach { lotto ->
            println(sortByLottoNumbersASC(lotto))
        }
    }

    private fun sortByLottoNumbersASC(lotto: Lotto) = lotto.lottoNumbers.map { lottoNumber ->
        lottoNumber.lottoNumber
    }.sortedBy {
        it
    }

    fun printWinningStatistics(calculateRecords: Set<LottoRecord>) {
        println("당첨 통계")
        println("--------")
        calculateRecords.filter {
            it.rank != Rank.NONE_RANK
        }.forEach { record ->
            println(messageByCondition(record))
        }
    }

    private fun messageByCondition(record: LottoRecord): String {
        if (record.rank == Rank.SECOND_BONUS_RANK) {
            return "${record.matchCount()}개 일치, 보너스 볼 일치(${record.reward()}원)- ${record.quantity}개"
        }
        return "${record.matchCount()}개 일치 (${record.reward()}원)- ${record.quantity}개"
    }

    fun printRate(rate: Double) {
        println(
            "총 수익률은 ${rate}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
        )
    }
}
