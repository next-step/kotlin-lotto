package lotto.view

class Input {
    fun getPurchaseAmount(): String {
        println("구입금액을 입력해 주세요.")
        return readln()
    }

    fun getManualCount(): String {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readln()
    }

    fun getManualNumbers(amount: Int): List<String> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        return (1..amount).map { readln() }
    }

    fun getWinningNumbers(): String {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln()
    }

    fun getBonusNumber(): String {
        println("보너스 볼을 입력해 주세요.")
        return readln()
    }
}
