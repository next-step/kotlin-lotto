package lotto.ui

class InputView {
    fun getPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readLine()!!.toInt()
    }

    fun getWinningNumbers(): List<Int> {
        println("\n지난 주 당첨 번호를 입력해 주세요.")
        return readLine()!!.split(',').map { str -> str.trim().toInt() }
    }

    fun getBonusNumber(): Int {
        println("\n보너스 볼을 입력해 주세요.")
        return readLine()!!.toInt()
    }
}
