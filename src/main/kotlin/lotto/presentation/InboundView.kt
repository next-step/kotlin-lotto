package lotto.presentation

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.LottoTickets
import lotto.domain.LottoWinningNumber

class InboundView {

    fun inputPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")

        val purchaseAmount: String = readln()
        require(purchaseAmount.isNotBlank()) { "공백을 입력하셨습니다." }

        return runCatching { purchaseAmount.toInt() }
            .getOrElse { throw IllegalArgumentException("숫자를 입력해주세요.") }
    }

    fun inputManualPurchaseCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")

        val manualPurchaseCount: String = readln()
        require(manualPurchaseCount.isNotBlank()) { "공백을 입력하셨습니다." }

        return runCatching { manualPurchaseCount.toInt() }
            .getOrElse { throw IllegalArgumentException("숫자를 입력해주세요.") }
    }

    fun inputManualLottoNumber(manualPurchaseCount: Int): LottoTickets {
        println("수동으로 구매할 번호를 입력해 주세요.")

        var inputCount = 0
        val inputNumbers: MutableList<Set<LottoNumber>> = mutableListOf()

        while (inputCount < manualPurchaseCount) {
            val inputManualNumber: String = readln()
            require(inputManualNumber.isNotBlank()) { "공백을 입력하셨습니다." }

            val manualNumber = inputManualNumber.toTokenize()
                .checkUniqueToken()
                .toMapInt()
                .toLottoNumber()
                .toSet()

            inputNumbers.add(manualNumber)
            inputCount ++
        }

        return LottoTickets(
            inputNumbers.map { LottoTicket(it) }
                .toList()
        )
    }

    fun inputWinningNumber(): LottoWinningNumber {
        println("\n지난 주 당첨 번호를 입력해 주세요.")

        val inputWinningNumber: String = readln()
        require(inputWinningNumber.isNotBlank()) { "공백을 입력하셨습니다." }

        val winningNumbers = inputWinningNumber.toTokenize()
            .checkUniqueToken()
            .toMapInt()
            .toLottoNumber()
            .toSet()

        val bonusNumber: LottoNumber = LottoNumber.of(inputBonusLottoNumber())

        return LottoWinningNumber(winningNumbers, bonusNumber)
    }

    private fun inputBonusLottoNumber(): Int {
        println("보너스 볼을 입력해 주세요.")

        val inputBonusNumber: String = readln()
        require(inputBonusNumber.isNotBlank()) { "공백을 입력하셨습니다." }

        return runCatching { inputBonusNumber.toInt() }
            .getOrElse { throw IllegalArgumentException("숫자를 입력해주세요.") }
    }

    private fun String.toTokenize(): List<String> {
        return this.split(',')
            .map { it.trim() }
            .filter { it.isNotBlank() }
    }

    private fun List<String>.checkUniqueToken(): List<String> {
        val originalSize = this.size
        val distinctSize = this.toSet().size

        require(originalSize == distinctSize) {
            "중복 되는 숫자는 입력할 수 없습니다."
        }

        return this
    }

    private fun List<String>.toMapInt(): List<Int> {
        return runCatching { map { it.toInt() } }
            .getOrElse { throw IllegalArgumentException("숫자를 입력해주세요.") }
    }

    private fun List<Int>.toLottoNumber(): List<LottoNumber> {
        return runCatching { map { LottoNumber.of(it) } }
            .getOrElse { e -> throw IllegalArgumentException(e.message) }
    }
}
