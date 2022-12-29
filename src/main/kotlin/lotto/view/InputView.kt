package lotto.view

class InputView {
    fun getAmountOfMoney(): String {
        println("구입금액을 입력해 주세요.")
        return readln()
    }

    fun getWinnerNumber(): String {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln()
    }

    fun getBonusNumber(): String {
        println("보너스 볼을 입력해 주세요.")
        return readln()
    }

    fun getManualQuantity(): String {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readln()
    }

    fun getManualNumber(): String {
        return readln()
    }
}
