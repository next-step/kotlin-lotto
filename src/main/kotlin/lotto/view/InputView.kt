package lotto.view

import lotto.domain.Lotto

class InputView {

    fun inputPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        var inputAmount = readNumber()
        while (!isValid(inputAmount)) {
            println("구입금액은 0보다 크고 100만보다 작거나 같아야 합니다. 다시 입력해주세요.")
            inputAmount = readNumber()
        }
        return inputAmount
    }

    fun inputWinningNums(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val input = readLine()?.trim()
        val numbers = input?.split(",", " ")?.map { it.trim().toInt() }
        return numbers?.take(Lotto.COUNT_OF_LOTTO_NUMBER) ?: emptyList()
    }

    fun inputBunusNum(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readNumber()
    }

    private fun readNumber(): Int {
        return readLine()?.toIntOrNull() ?: 0
    }

    private fun isValid(number: Int): Boolean {
        if (number in PURCHASABLE_RANGE) return true
        return false
    }

    companion object {
        private val PURCHASABLE_RANGE = 1..1000000
    }
}
