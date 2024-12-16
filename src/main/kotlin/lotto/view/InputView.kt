package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.WinningLottoNumber

object InputView {
    private const val MIN_LOTTO_MANUAL_COUNT = 1

    fun getLottoPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readlnOrNull()?.toIntOrNull() ?: throw RuntimeException("숫자를 입력해주세요")
    }

    fun getWinningNumber(): WinningLottoNumber {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val input: String = readlnOrNull() ?: throw RuntimeException("당첨 번호를 입력해주세요")
        println("보너스 번호를 입력해 주세요.")
        val bonusNumber: Int =
            readlnOrNull()?.toIntOrNull() ?: throw RuntimeException("보너스 번호는 숫자를 입력해주세요")
        return WinningLottoNumber(LottoNumber(splitWinningNumbers(input)), bonusNumber)
    }

    private fun splitWinningNumbers(input: String): Set<Int> {
        return input.split(",").map { e -> e.trim().toInt() }.toSet()
    }

    fun getLottoManualCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readlnOrNull()?.toIntOrNull() ?: throw RuntimeException("숫자를 입력해주세요")
    }

    fun getLottoManualNumbers(manualCount: Int): MutableList<LottoNumber> {
        val lottoNumbersList = mutableListOf<LottoNumber>()
        if (manualCount < MIN_LOTTO_MANUAL_COUNT) {
            return lottoNumbersList
        }
        println("수동으로 구매할 번호를 입력해 주세요.")
        repeat(manualCount) {
            val input: String = readlnOrNull() ?: throw RuntimeException("구매할 로또 번호를 입력해주세요")
            val numbers = splitWinningNumbers(input)
            val lottoNumber = LottoNumber(numbers)
            lottoNumbersList.add(lottoNumber)
        }
        return lottoNumbersList
    }
}
