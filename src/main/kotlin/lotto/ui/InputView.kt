package lotto.ui

import lotto.domain.Lotto
import lotto.domain.LottoDispenser

class InputView {

    var lottoList: List<Lotto> = emptyList()
        private set
    var amount: Int = 0
        private set

    fun inputPurchasingAmount(): Int {
        println("구입금액을 입력해 주세요.")
        amount = readLine()?.toIntOrNull() ?: 0
        return if (amount < 1000) {
            inputPurchasingAmount()
        } else {
            amount
        }
    }

    fun showPurchaseResult() {
        lottoList = LottoDispenser(amount).list
        println("${lottoList.size}개를 구매했습니다.")
        lottoList.forEach { println(it) }
    }
}
