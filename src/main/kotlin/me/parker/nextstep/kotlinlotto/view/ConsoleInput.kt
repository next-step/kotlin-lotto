package me.parker.nextstep.kotlinlotto.view

object ConsoleInput {
    fun inputAmountOfPurchaseLotto(): Int {
        println("구입금액을 입력해 주세요.")

        var input: String

        do {
            input = readln()
            if (input.isBlank()) println("구입금액은 공백일 수 없습니다. 다시 입력해주세요!")
        } while (input.isBlank())

        return input.toInt()
    }

    fun inputLastWonLottoNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")

        var input: String
        do {
            input = readln()
            if (input.isBlank()) println("지난 주 당첨 번호는 공백일 수 없습니다. 다시 입력해주세요!")
        } while (input.isBlank())

        return input.replace(" ", "")
            .split(",").map { it.toInt() }
    }
}