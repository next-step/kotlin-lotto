package com.example.mylotto.view

class InputView {
    fun readPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        val amount = readlnOrNull()?.toIntOrNull()
        require(amount != null)
        return amount
    }

    fun readWinningNumbers(): Set<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val numbers =
            readlnOrNull()
                ?.split(",")
                ?.mapNotNull { it.trim().toIntOrNull() }
                ?.toSet()
        require(numbers != null)
        return numbers
    }
}
