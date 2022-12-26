package lotto.view

object InputView {
    fun readMoney(): String {
        println("구입금액을 입력해 주세요.")
        return readln()
    }

    fun readWinningLotto(): String {
        println("지난 주 당첨 번호를 입력해주세요.")
        return readln()
    }

    fun readBonusNumber(): String {
        println("보너스 볼을 입력해 주세요.")
        return readln()
    }
}
