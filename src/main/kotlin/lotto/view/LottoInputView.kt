package lotto.view

import lotto.component.Lotto
import lotto.model.LottoInput

class LottoInputView {
    fun getInput(): LottoInput {
        val purchaseAccount: Int = getPurchaseAccount()
        val lottoTicketCount: Int = getLottoTicketCount(purchaseAccount)

        return LottoInput(lottoTicketCount)
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

    private fun getLottoTicketCount(purchaseAccount: Int, lottoPrice: Int = Lotto.LOTTO_PRICE): Int {
        val lottoTicketCount = purchaseAccount / lottoPrice

        require(lottoTicketCount > 0) {
            "로또를 구매할 수 없습니다. (로또 가격: $lottoPrice)"
        }

        return lottoTicketCount
    }
}
