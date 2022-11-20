package lotto.view

object InputView {
    fun getPurchaseAmount(): Int {
        val amount = readlnOrNull()
        require(!amount.isNullOrEmpty()) { "금액을 입력해주세요." }

        return amount.toInt()
    }
}
