package lotto.view

class InputView {
    fun readPurchaseAmount(): Int {
        println("구입 금액을 입력해 주세요.")
        val amount =
            readLine()?.toIntOrNull()
                ?: throw IllegalArgumentException("유효하지 않은 금액입니다. 숫자를 입력해 주세요.")
        return amount
    }
}
