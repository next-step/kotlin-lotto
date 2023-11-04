package lotto.view

object LottoInputHandler {
    fun inputPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readlnOrNull().let { require(it != null && it.toIntOrNull() != null) { "구입 금액은 숫자여야 합니다." };return it.toInt() }
    }

    fun inputWinningNumbers(): String {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readlnOrNull().let { require(it != null) { "지난 주 당첨 번호는 숫자여야 합니다." };return it }
    }
}
