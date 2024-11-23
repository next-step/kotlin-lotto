package lottery.view

object InputView {
    fun inputPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readlnOrNull()?.toIntOrNull()
            ?: throw IllegalArgumentException("잘못된 입력입니다")
    }
}
