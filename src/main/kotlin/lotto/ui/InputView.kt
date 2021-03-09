package lotto.ui

class InputView {

    fun inputMoney(): Int {
        println("구입금액을 입력해 주세요.")
        return readLine()!!.toInt()
    }

    fun inputPrizeNumber(): List<Int> {
        println("\n지난 주 당첨 번호를 입력해 주세요")
        return readLine()!!.split(", ")
            .map {
                it.toInt()
            }
    }

    fun inputBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readLine()!!.toInt()
    }
}
