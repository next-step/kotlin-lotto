package lotto.view.input.parser

import lotto.model.data.Policy

class PurchaseAmountInputParser(private val policy: Policy) :
    IntInputParser(policy.priceOfLotto..policy.limitAmountToPurchase) {

    override fun parseValue(inputString: String?): Int {
        val parsedAmountValue = super.parseValue(inputString)
        require(parsedAmountValue % policy.priceOfLotto == 0) {
            "잔돈이 남지 않게 ${policy.priceOfLotto}의 배수로 입력해 주세요."
        }
        return parsedAmountValue
    }
}
