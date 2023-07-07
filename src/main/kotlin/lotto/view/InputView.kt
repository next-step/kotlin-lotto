package lotto.view

import lotto.LottoGame.Companion.GAME_COST
import lotto.LottoNumber
import lotto.LottoNumbers
import lotto.LottoNumbersGenerator
import lotto.ManualStrategy
import lotto.WinningNumbers

object InputView {
    fun receivePurchaseAmount(): Int {
        println("구입 금액을 입력해 주세요.")

        var value: Int?

        do {
            val input = receiveString()
            value = input.toIntOrNull()
        } while (value == null || value < GAME_COST)

        return value
    }

    fun receiveWinningNumbers(): WinningNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")

        val lottoNumbers: LottoNumbers = receiveLottoNumbers()
        val bonusNumber: LottoNumber = receiveBonusNumber()

        return WinningNumbers(lottoNumbers, bonusNumber)
    }

    fun receiveManualLottoNumbers(manualGameCount: Int): List<LottoNumbers> {
        println("수동으로 구매할 번호를 입력해 주세요.")

        return List(manualGameCount) { receiveLottoNumbers() }
    }

    private fun receiveLottoNumbers(): LottoNumbers {
        var lottoNumbers: LottoNumbers?

        do {
            val input = receiveString()
            val numbers = input.splitToIntList()
            val lottoNumbersGenerator = LottoNumbersGenerator(ManualStrategy(numbers.map { LottoNumber.from(it) }))

            lottoNumbers = runCatching {
                lottoNumbersGenerator.generate()
            }.getOrNull()
        } while (lottoNumbers == null)

        return lottoNumbers
    }

    fun receiveManualGameCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")

        return receiveInt()
    }

    private fun receiveBonusNumber(): LottoNumber {
        println("보너스 볼을 입력해 주세요.")

        val input = receiveInt()

        return LottoNumber.from(input)
    }

    fun String.splitToIntList(): List<Int> {
        return this.split(",")
            .map { it.trim() }
            .map { it.toInt() }
    }

    private fun receiveString(): String {
        var input: String? = null

        do {
            input = readlnOrNull()
        } while (input.isNullOrBlank())

        return input
    }

    private fun receiveInt(): Int {
        var int: Int? = receiveString().toIntOrNull()

        while (int == null) {
            int = receiveString().toIntOrNull()
        }

        return int
    }
}
