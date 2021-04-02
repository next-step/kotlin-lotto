package view

object BuyingInputView {
    fun receiveAmount(): BuyingInput {
        println("구입금액을 입력해 주세요.")

        return readBuyingAmount()
    }

    private tailrec fun readBuyingAmount(): BuyingInput {
        val line = readLine()!!

        return when (val result = BuyingInputParser.parse(line)) {
            is BuyingInput -> result
            is InvalidInput -> {
                println(result.warningMessage)
                readBuyingAmount()
            }
        }
    }
}
