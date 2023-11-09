package lotto.view

import lotto.component.Lotto
import lotto.model.LottoInput
import lotto.model.WinningNumbers

class LottoInputView {
    fun getInput(): LottoInput {
        val purchasePrice: Int = getPurchaseAccount()
        val lottoTicketCount: Int = getLottoTicketCount(purchasePrice)
        val winningNumbers: WinningNumbers = getWinningNumbers()

        return LottoInput(lottoTicketCount, winningNumbers)
    }

    private fun getInput(message: String): String? {
        println(message)

        return readlnOrNull()
    }

    private fun getPurchaseAccount(): Int {
        val purchasePrice = getInput("구입 금액을 입력해주세요.")?.toIntOrNull()

        require(purchasePrice != null && purchasePrice > 0) {
            "구매 금액은 자연수만 가능합니다."
        }

        return purchasePrice
    }

    private fun getLottoTicketCount(purchasePrice: Int, lottoPrice: Int = Lotto.LOTTO_PRICE): Int {
        val lottoTicketCount = purchasePrice / lottoPrice

        require(lottoTicketCount > 0) {
            "로또를 구매할 수 없습니다. (로또 가격: $lottoPrice)"
        }

        return lottoTicketCount
    }

    private fun getWinningNumbers(): WinningNumbers {
        val lottoNumbersString = getInput("지난 주 당첨 번호를 입력해 주세요.")

        require(!lottoNumbersString.isNullOrBlank()) {
            "로또 번호는 6자리입니다. 콤마와 공백으로 구분된 6자리 숫자를 입력해주세요. 예시: 1, 2, 3, 4, 5, 6"
        }

        val lottoNumbers = lottoNumbersString
            .split(LOTTO_NUMBERS_DELIMITER)
            .map { getLottoNumber(it) }

        return WinningNumbers.create(lottoNumbers)
    }

    private fun getLottoNumber(lottoNumberString: String): Int {
        val lottoNumber = lottoNumberString.toIntOrNull()

        require(lottoNumber != null && lottoNumber >= 1 && lottoNumber <= 45) {
            "로또 번호는 1 이상 45 이하의 자연수입니다."
        }

        return lottoNumber
    }

    companion object {
        private const val LOTTO_NUMBERS_DELIMITER = ", "
    }
}
