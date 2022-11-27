package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.PurchaseAmount
import lotto.domain.WinningLottoNumbers

object InputView {
    private const val INVALID_INPUT_ERROR_MESSAGE = "로또 번호는 숫자만 입력할 수 있습니다."
    fun getPurchaseAmount(): PurchaseAmount {
        println("구입 금액을 입력해 주세요.")
        return PurchaseAmount(readln().toInt())
    }

    fun getWinningLottoNumbers(): WinningLottoNumbers {
        println("\n지난 주 당첨 번호를 입력해 주세요.")
        val inputLottoNumbers = readln()
        val lottoNumbers = validateLottoNumbers(inputLottoNumbers)

        println("보너스 볼을 입력해 주세요.")
        val inputBonusBall = LottoNumber(readln().toInt())

        return WinningLottoNumbers(lottoNumbers = lottoNumbers, bonusLottoNumbers = inputBonusBall)
    }

    private fun validateLottoNumbers(input: String): Lotto {
        val strings = input.replace(" ", "").split(",")
        val lottoNumbers = strings.map { convertStringToLottoNumber(it) }
        return Lotto(lottoNumbers)
    }

    private fun convertStringToLottoNumber(value: String): LottoNumber {
        val number = value.toIntOrNull() ?: throw IllegalArgumentException(INVALID_INPUT_ERROR_MESSAGE)
        return LottoNumber(number)
    }
}
