package view.buyinginput

import domain.lotto.Lotto
import view.BuyingInput
import view.BuyingInputParsedResult
import view.InvalidInput

object BuyingInputParser {
    fun parse(input: String): BuyingInputParsedResult {
        val amount = input.toLongOrNull()
            ?: return InvalidInput(input, "숫자가 아닙니다. 다시 입력해 주세요.")

        if (amount < Lotto.PRICE.value) {
            return InvalidInput(input, "액수가 로또 한 장보다 적습니다. 다시 입력해 주세요.")
        }

        return BuyingInput(amount)
    }
}
