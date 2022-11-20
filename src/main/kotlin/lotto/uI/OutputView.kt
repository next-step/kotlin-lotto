package lotto.uI

import lotto.domain.Lotto

object OutputView {
    fun outputLottoList(lottoList: List<Lotto>) {
        println("${lottoList.count()}${MessageCode.PURCHASE_COUNT_RESULT.message}")
        lottoList.forEach { lotto ->
            println(lotto.numbers)
        }
    }
}
