package com.example.mylotto.view

class InputView {
    fun readPurchaseAmount(): Long {
        println("구입금액을 입력해 주세요.")
        val amount = readlnOrNull()?.toLongOrNull()
        require(amount != null) { "올바른 구입금액이 입력되지 않았습니다." }
        return amount
    }

    fun readWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val numbers =
            readlnOrNull()
                ?.split(",")
                ?.mapNotNull { it.trim().toIntOrNull() }
        require(numbers != null) { "올바른 지난주 당첨 번호가 입력되지 않았습니다." }
        return numbers
    }

    fun readBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        val number = readlnOrNull()?.toIntOrNull()
        require(number != null) { "올바른 보너스볼이 입력되지 않았습니다." }
        return number
    }

    fun readManualCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val manualCount = readlnOrNull()?.toIntOrNull()
        require(manualCount != null) { "올바른 수동 구매 로또 수가 입력되지 않았습니다." }
        return manualCount
    }

    fun readManualLottoTickets(manualCount: Int): List<List<Int>> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        val numbersList =
            List(manualCount) {
                val numbers =
                    readlnOrNull()
                        ?.split(",")
                        ?.mapNotNull { it.trim().toIntOrNull() }
                require(numbers != null && numbers.size == 6) { "올바른 수동 구매 번호가 입력되지 않았습니다." }
                numbers
            }

        return numbersList
    }
}
