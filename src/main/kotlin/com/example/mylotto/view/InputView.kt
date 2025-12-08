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

    fun readBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        val number = readlnOrNull()?.toIntOrNull()
        require(number != null)
        return number
    }

    fun readManualCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val manualCount = readlnOrNull()?.toIntOrNull()
        require(manualCount != null)
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
                require(numbers != null)
                numbers
            }

        return numbersList
    }
}
