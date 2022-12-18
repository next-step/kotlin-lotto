package step2.ui

import java.lang.IllegalArgumentException

object InputView {

    fun getPurchaseAmount(): Int {
        println(INPUT_PURCHASE_AMOUNT_MESSAGE)
        return readln().toIntOrNull() ?: throw IllegalArgumentException(printIllegalMessage())
    }

    fun getPurchaseCount(purchaseAmount: Int): Int {
        val purchaseCount = purchaseAmount / LOTTO_AMOUNT
        require(purchaseAmount % LOTTO_AMOUNT == DIVISIBLE_NUMBER) { printIllegalMessage() }
        printTotalPurchaseCount(purchaseCount)
        return purchaseCount
    }

    fun answer(): List<Int> {
        println(INPUT_ANSWER_NUMBER)
        return readln().split(SPLIT_DELIMITER).map {
            require(it.toInt() in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) { "$MIN_LOTTO_NUMBER 과 $MAX_LOTTO_NUMBER 사이의 숫자를 입력해주세요." }
            it.toInt()
        }
    }

    private const val INPUT_PURCHASE_AMOUNT_MESSAGE = "구매금액을 입력 해주세요."
    private const val LOTTO_AMOUNT = 1000
    private const val DIVISIBLE_NUMBER = 0
    private const val MIN_LOTTO_NUMBER = 1
    private const val MAX_LOTTO_NUMBER = 45
    private const val INPUT_ANSWER_NUMBER = "지난 주 당첨 번호를 입력해 주세요."
    private const val SPLIT_DELIMITER = ","
    private fun printTotalPurchaseCount(purchaseCount: Int) = "총 구매 개수는 $purchaseCount 입니다."
    private fun printIllegalMessage() = "${LOTTO_AMOUNT}원 단위의 금액을 입력해주세요."
}
