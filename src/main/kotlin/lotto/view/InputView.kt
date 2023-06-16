package lotto.view

import lotto.LottoNumbers

object InputView {
    private const val GAME_COST = 1000

    fun receiveGameCount(): Int {
        val purchaseAmount = receivePurchaseAmount()
        val gameCount = purchaseAmount % GAME_COST

        println("${gameCount}개를 구매했습니다.")

        return gameCount
    }

    private fun receivePurchaseAmount(): Int {
        println("구입 금액을 입력해 주세요.")

        var value: Int?

        do {
            val input = receiveString()
            value = input.toIntOrNull()
        } while (value == null || value < 1000)

        return value
    }

    fun receiveWinningNumbers(): LottoNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")

        var lottoNumbers: LottoNumbers?

        do {
            val input = receiveString()

            lottoNumbers = try {
                LottoNumbers.from(input)
            } catch (e: Exception) {
                null
            }
        } while (lottoNumbers == null)

        return lottoNumbers
    }

    private fun receiveString(): String {
        var input: String? = null

        do {
            input = readlnOrNull()
        } while (input.isNullOrBlank())

        return input
    }
}
