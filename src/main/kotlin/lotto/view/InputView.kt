package lotto.view

import lotto.domain.PurchaseAmount

object InputView {
    private const val INVALID_INPUT_ERROR_MESSAGE = "로또 번호는 숫자만 입력할 수 있습니다."
    fun getPurchaseAmount(): PurchaseAmount {
        println("구입 금액을 입력해 주세요. (1장 당 가격: 1000원)")

        return PurchaseAmount(readln().toInt())
    }

    fun getManualNumberOfLotto(): Int {
        println("\n수동으로 구매할 로또 수를 입력해 주세요.")
        val numberOfLottoByManual = readln().toInt()

        return if (numberOfLottoByManual < 0) 0 else numberOfLottoByManual
    }

    fun getManualLottos(numberOfLottoByManual: Int): List<List<Int>> {
        println("\n수동으로 구매할 번호를 입력해 주세요.")

        val inputList: MutableList<List<Int>> = mutableListOf()
        repeat(numberOfLottoByManual) {
            val inputNumbers = validateNumbers(readln())
            inputList.add(inputNumbers)
        }
        return inputList
    }

    fun getWinningNumbers(): List<Int> {
        println("\n지난 주 당첨 번호를 입력해 주세요.")
        val inputLottoNumbers = readln()
        return validateNumbers(inputLottoNumbers)
    }

    fun getBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readln().toInt()
    }

    private fun validateNumbers(input: String): List<Int> {
        val strings = input.replace(" ", "").split(",")
        return strings.map { convertStringToInt(it) }
    }

    private fun convertStringToInt(value: String): Int {
        return value.toIntOrNull() ?: throw IllegalArgumentException(INVALID_INPUT_ERROR_MESSAGE)
    }
}
