package lotto.ui

import lotto.domain.Lotto

class InputView {

    fun inputAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readLine()?.toIntOrNull() ?: 0
    }

    fun showPurchaseResult(lottoList: List<Lotto>) {
        println("${lottoList.size}개를 구매했습니다.")
        lottoList.forEach { println(it) }
    }
}
