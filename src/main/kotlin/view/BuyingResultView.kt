package view

import domain.lotto.Lotto
import domain.lotto.Lottos

object BuyingResultView {
    fun print(lottos: Lottos) {
        printLottoCount(lottos)
        printAllLottoNumbers(lottos)
    }

    private fun printLottoCount(lottos: Lottos) {
        println("수동으로 ${lottos.countManualPick()}장, 자동으로 ${lottos.countAutoPick()}장 구매했습니다")
    }

    private fun printAllLottoNumbers(lottos: Lottos) {
        lottos.toList().forEach(::printLottoNumbers)
    }

    private fun printLottoNumbers(lotto: Lotto) {
        println("[${lotto.numbers.toList().joinToString { it.value.toString() }}]")
    }
}
