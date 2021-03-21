package view

import domain.lotto.Lotto

class BuyingResultView {
    fun print(lottos: List<Lotto>) {
        printLottoCount(lottos)
        printAllLottoNumbers(lottos)
    }

    private fun printLottoCount(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다")
    }

    private fun printAllLottoNumbers(lottos: List<Lotto>) {
        lottos.forEach(::printLottoNumbers)
    }

    private fun printLottoNumbers(lotto: Lotto) {
        println("[${lotto.numbers.numbers.joinToString { it.value.toString() }}]")
    }
}
