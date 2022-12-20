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

    fun getBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readln().toInt()
    }
}
