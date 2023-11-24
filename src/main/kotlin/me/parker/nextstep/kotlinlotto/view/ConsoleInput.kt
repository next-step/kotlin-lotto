package me.parker.nextstep.kotlinlotto.view

object ConsoleInput {
    fun inputAmountOfPurchaseLotto(): Int {
        println("구입금액을 입력해 주세요.")
        return inputNotEmptyString("구입금액은 공백일 수 없습니다. 다시 입력해주세요!").toInt()
    }

    fun inputSizeOfManualLotto(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return inputNotEmptyString("수동으로 구매할 로또는 공백일 수 없습니다. 다시 입력해주세요!").toInt()
    }

    fun inputManualLottoNumbers() {
        println("수동으로 구매할 번호를 입력해 주세요.")
    }

    fun inputLastWonLottoNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")

        return inputLottoNumbers()
    }

    fun inputLottoNumbers(): List<Int> {
        return inputNotEmptyString("로또 번호는 공백일 수 없습니다. 다시 입력해주세요!")
            .replace(" ", "")
            .split(",").map { it.toInt() }
    }

    fun inputBonusLottoNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        return inputNotEmptyString("보너스 볼 번호는 공백일 수 없습니다. 다시 입력해주세요!").toInt()
    }

    private fun inputNotEmptyString(errorMessage: String): String {
        var input: String

        do {
            input = readln()
            if (input.isBlank()) println(errorMessage)
        } while (input.isBlank())

        return input
    }
}
