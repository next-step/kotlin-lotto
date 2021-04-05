package view

import domain.lotto.Lotto
import domain.lotto.Lottos
import domain.lotto.PickType

object BuyingResultView {
    fun print(lottos: Lottos) {
        printLottoCount(lottos)
        printAllLottoNumbers(lottos)
    }

    private fun printLottoCount(lottos: Lottos) {
        println("수동으로 ${lottos.countBy(PickType.MANUAL)}장, 자동으로 ${lottos.countBy(PickType.AUTO)}장 구매했습니다")
    }

    private fun printAllLottoNumbers(lottos: Lottos) {
        lottos.toList().forEach(::printLottoNumbers)
    }

    private fun printLottoNumbers(lotto: Lotto) {
        println("[${lotto.numbers.toList().joinToString { it.value.toString() }}]")
    }
}
