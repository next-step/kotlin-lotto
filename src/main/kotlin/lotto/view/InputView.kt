package lotto.view

import lotto.domain.Lotto
import lotto.domain.WinningLotto

object InputView {
    private const val INPUT_PURCHASE_PRICE_STRING = "구입금액을 입력해 주세요."
    private const val PRICE_ONLY_NUMBER_ALERT = "로또 가격은 숫자만 가능합니다."
    private const val INPUT_PREVIOUS_LOTTO_NUMBER_STRING = "지난 주 당첨 번호를 입력해 주세요."

    fun inputPurchasePrice(): Int {
        println(INPUT_PURCHASE_PRICE_STRING)
        val lottoPrice = readln()

        return lottoPrice.toIntOrNull()
            ?: run {
                println(PRICE_ONLY_NUMBER_ALERT)
                inputPurchasePrice()
            }
    }

    fun inputWinningLotto(): WinningLotto {
        println(INPUT_PREVIOUS_LOTTO_NUMBER_STRING)
        val inputNumbers = readln()

        return WinningLotto(Lotto.of(inputNumbers))
    }
}
