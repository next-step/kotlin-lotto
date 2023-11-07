package lotto.view

import lotto.model.LottoInput

class LottoInputView {
    fun getInput(): LottoInput {
        val purchaseAccount = getPurchaseAccount()

        return LottoInput(purchaseAccount)
    }

    private fun getInput(message: String): String? {
        println(message)

        return readlnOrNull()
    }

    private fun getPurchaseAccount(): Int {
        val purchaseAccount = getInput("구입 금액을 입력해주세요.")?.toIntOrNull()

        require(purchaseAccount != null && purchaseAccount > 0) {
            "구매 금액은 자연수만 가능합니다."
        }

        return purchaseAccount
    }
}
