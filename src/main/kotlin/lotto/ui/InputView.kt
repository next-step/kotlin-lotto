package lotto.ui

import lotto.model.LottoNumber
import lotto.model.LottoNumbers
import lotto.model.PurchaseAmount

object InputView {

    fun inputLottoAmount(): PurchaseAmount {
        println("구입금액을 입력해 주세요.")
        val amount: String = readLine() ?: throw IllegalArgumentException("구매금액을 숫자를 입력해야 합니다")

        return PurchaseAmount(amount.toIntOrNull() ?: throw IllegalArgumentException("숫자만 입력 가능합니다"))
    }

    fun inputWinningNumber(): LottoNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningNumber: String = readLine() ?: throw IllegalArgumentException("당첨 번호는 필수 입력해야 합니다")

        return lottoNumbers(winningNumber)
    }

    fun inputPlusWinningNumber(): LottoNumber {
        println("보너스 볼을 입력해 주세요.")
        val plusNumber: String = readLine() ?: throw IllegalArgumentException("보너스 번호는 숫자를 입력해야 합니다")

        return LottoNumber.valueOf(plusNumber.toIntOrNull() ?: throw IllegalArgumentException("숫자만 입력 가능합니다"))
    }

    fun inputDirectCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val directCount: String = readLine() ?: throw IllegalArgumentException("수동 로또 구매 수는 숫자를 입력해야 합니다")

        return directCount.toIntOrNull() ?: throw IllegalArgumentException("숫자만 입력 가능합니다")
    }

    fun inputDirectNumber(directCount: Int): List<LottoNumbers> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        val totalDirectNumber = mutableListOf<LottoNumbers>()
        repeat(directCount) {
            val directNumber: String = readLine() ?: throw IllegalArgumentException("수동 로또 번는 를 입력해야 합니다")
            val lootNumbers = lottoNumbers(directNumber)
            totalDirectNumber.add(lootNumbers)
        }
        return totalDirectNumber.toList()
    }

    private fun lottoNumbers(directNumber: String): LottoNumbers {
        val result = directNumber.split(",")
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("숫자만 입력 가능합니다") }
            .map { LottoNumber.valueOf(it) }
            .toList()
        return LottoNumbers(result)
    }
}
