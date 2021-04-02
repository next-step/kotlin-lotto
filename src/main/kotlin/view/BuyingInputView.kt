package view

object BuyingInputView {
    fun receiveAmount(): BuyingInput {
        println("구입금액을 입력해 주세요.")

        return readBuyingAmount()
    }

    private fun readBuyingAmount(): BuyingInput {
        val line = readLine()!!

        val result = BuyingInputParser.parse(line)

        when (result) {
            is BuyingInput -> return result
            is InvalidInput -> {
                println(result.warningMessage)
                return readBuyingAmount()
            }
        }
    }
}
