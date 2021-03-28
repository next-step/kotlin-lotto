package view

object BuyingInputView {
    fun receiveAmount(): BuyingInput {
        println("구입금액을 입력해 주세요.")
        return BuyingInput(readLine()!!)
    }
}
