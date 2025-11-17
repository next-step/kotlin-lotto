package com.example.mylotto.view

class InputView {
    fun readPurchaseAmount(): Long {
        println("구입금액을 입력해 주세요.")
        val amount = readlnOrNull()?.toLongOrNull()
        require(amount != null)
        return amount
    }

    fun readWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val numbers =
            readlnOrNull()
                ?.split(",")
                ?.mapNotNull { it.trim().toIntOrNull() }
        require(numbers != null)
        return numbers
    }
}
