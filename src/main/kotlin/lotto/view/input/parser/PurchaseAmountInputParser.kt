package lotto.view.input.parser

import lotto.model.data.ParseResult
import lotto.model.data.Policy

class PurchaseAmountInputParser(private val policy: Policy) :
    IntInputParser(policy.priceOfLotto..policy.limitAmountToPurchase) {

    override fun parseValue(inputString: String?): ParseResult<Int> =
        when (val parsedAmountValue = super.parseValue(inputString)) {
            is ParseResult.Error -> parsedAmountValue
            is ParseResult.Value -> parseValue(parsedAmountValue)
        }

    private fun parseValue(parsedAmountValue: ParseResult.Value<Int>): ParseResult<Int> =
        if (parsedAmountValue.value % policy.priceOfLotto != 0) ParseResult.Error(
            "잔돈이 남지 않게 ${policy.priceOfLotto}의 배수로 입력해 주세요."
        ) else {
            parsedAmountValue
        }
}
