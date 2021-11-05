package lotto.view

class InputView {
    fun inputBudget(): Int {
        println("구입금액을 입력해 주세요.")
        return readLine()!!.toInt()
    }

    fun inputManualLotto(): List<String> {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val lottoSize = readLine()!!.toInt()
        println("수동으로 구매할 번호를 입력해 주세요.")
        val stringList = mutableListOf<String>()
        repeat(lottoSize) { stringList.add(readLine()!!) }
        return stringList.toList()
    }

    fun inputWinningNumber(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readLine()!!.split(",").map { it.toInt() }
    }

    fun inputBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readLine()!!.toInt()
    }
}
