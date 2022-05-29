package lotto.presentation

import lotto.domain.LottoWinningNumber

class InboundView {

    fun inputPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")

        val purchaseAmount: String? = readLine()

        if (purchaseAmount.isNullOrBlank()) {
            throw IllegalArgumentException("입력 값을 확인해주세요.")
        }

        return runCatching { purchaseAmount.toInt() }
            .getOrElse { throw IllegalArgumentException("숫자를 입력해주세요.") }
    }

    fun inputWinningNumber(): LottoWinningNumber {
        println("\n지난 주 당첨 번호를 입력해 주세요.")

        val winningNumber: String? = readLine()

        if (winningNumber.isNullOrBlank()) {
            throw IllegalArgumentException("입력 값을 확인해주세요.")
        }

        return LottoWinningNumber(
            winningNumber.toTokenize()
                .checkUniqueToken()
                .toMapInt()
                .toSet()
        )
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
}
