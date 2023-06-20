package lotto.view

import lotto.LottoNumbers
import lotto.WinningNumbers

object InputView {
    fun receivePurchaseAmount(): Int {
        println("구입 금액을 입력해 주세요.")

        var value: Int?

        do {
            val input = receiveString()
            value = input.toIntOrNull()
        } while (value == null || value < 1000)

        return value
    }

    fun receiveWinningNumbers(): WinningNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")

        var lottoNumbers: LottoNumbers?

        do {
            val input = receiveString()
            val numbers = input.splitToIntList()

            lottoNumbers = runCatching {
                LottoNumbers.from(numbers)
            }.getOrNull()
        } while (lottoNumbers == null)

        return WinningNumbers(lottoNumbers)
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
}
