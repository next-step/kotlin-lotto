package lotto.component

import lotto.model.LottoNumber
import lotto.model.LottoNumbers
import lotto.model.WinningNumbers

class LottoInputValidator {
    fun validatePurchasePrice(purchasePrice: String?): String {
        require(!purchasePrice.isNullOrBlank() && purchasePrice.toInt() > 0) {
            "구매 금액은 자연수만 가능합니다."
        }

        return purchasePrice
    }

    fun validateLottoNumbersCount(lottoNumbersCount: Int): Int {
        require(lottoNumbersCount > 0) {
            "로또를 구매할 수 없습니다."
        }

        return lottoNumbersCount
    }

    fun validateLottoNumbers(lottoNumbers: String?): String {
        require(!lottoNumbers.isNullOrBlank()) {
            "콤마와 공백으로 구분된 6자리 숫자를 입력해주세요. 예시: 1, 2, 3, 4, 5, 6"
        }
        return lottoNumbers
    }

    fun validateLottoNumberCount(lottoNumbers: List<Int>): List<Int> {
        require(lottoNumbers.size == LottoNumbers.LOTTO_NUMBERS_LENGTH) {
            "로또 번호는 6자리입니다."
        }
        return lottoNumbers
    }

    fun validateLottoNumber(lottoNumber: String?): String {
        val number = lottoNumber?.toIntOrNull()

        require(number != null && number >= 1 && number <= 45) {
            "로또 번호는 1 이상 45 이하의 자연수입니다."
        }

        return lottoNumber
    }

    fun validateBonusNumber(bonusNumber: LottoNumber, winningNumbers: WinningNumbers): LottoNumber {
        require(!winningNumbers.contain(bonusNumber)) {
            "보너스 번호는 당첨 번호에 포함될 수 없습니다."
        }

        return bonusNumber
    }
}
