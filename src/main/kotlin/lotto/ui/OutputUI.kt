package lotto.ui

import lotto.domain.LottoNumbers

object OutputUI {

    fun drawPurchaseMessage(count: Int) {
        println("${count}개를 구매했습니다.")
    }

    fun drawLotto(lotto: List<LottoNumbers>) {
        lotto.forEach {
            println(
                "[${it.numbers.joinToString(", ") { it.number.toString() }}]"
            )
        }
    }
}
