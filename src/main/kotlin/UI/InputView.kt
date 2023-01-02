package UI

import domain.LottoInput

object InputView {

    fun purchaseInputView(): LottoInput {
        println("구입금액을 입력해 주세요.")
        val inputPrice = readln().trim()
        return LottoInput(
            purchaseAmount = inputPrice.toInt(),
            purchaseCount = inputPrice.toInt() / 1000
        )
    }

    fun winningLottoInputView(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val input = readln().trim()
        return input.split(",").map { it.toInt() }
    }
}