package lotto.ui

object InputView {
    fun inputMoney(): Int {
        println("구입금액을 입력해 주세요.")

        return readln().toInt()
    }

    fun inputManualLottoCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")

        return readln().toInt()
    }

    fun inputManualLottoNumber(): List<Int> {
        println("수동으로 구매할 번호를 입력해 주세요.")

        return readln()
            .split(",")
            .map { it.toInt() }
            .sorted()
    }

    fun inputWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")

        return readln()
            .split(",")
            .map { it.toInt() }
            .sorted()
    }

    fun inputBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")

        return readln().toInt()
    }
}
