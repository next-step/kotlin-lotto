package lotto.ui

import lotto.domain.LottoNumbers

object InputUI {

    fun receivePurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return requireNotNull(readLine()).toInt()
    }

    fun receiveWinningNumbers(): LottoNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val input = requireNotNull(readLine())
        return LottoNumbers(input.replace(" ", "").split(",").map(String::toInt))
    }
}
