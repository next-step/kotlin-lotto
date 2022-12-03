package lotto.ui

import lotto.domain.model.Lotto
import lotto.domain.LottoDispenser
import lotto.domain.MINIMUM_PRICE

class InputView {

    var lottoList: List<Lotto> = emptyList()
        private set
    var amount: Int = 0
        private set

    fun inputPurchasingAmount(): Int {
        println("구입금액을 입력해 주세요.")
        amount = readLine()?.toIntOrNull() ?: 0
        return if (amount < MINIMUM_PRICE) {
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
