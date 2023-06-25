package lotto.view

class ConsoleInputView : InputView {
    override fun getPurchaseAmount(): Int {
        println("구입 금액을 입력해 주세요")
        return readln().toInt()
    }

    override fun getCountOfPurchaseManually(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요")
        return readln().toInt()
    }

    override fun getNumbersOfManuallyLotto(countOfPurchaseManually: Int): List<List<Int>> {
        println("수동으로 구매할 번호를 입력해 주세요")
        return (1..countOfPurchaseManually)
            .map { readln().trim().split(",").map { it.toInt() } }
            .toList()
//        val result = mutableListOf<List<Int>>()
//        for (i in 0 until countOfPurchaseManually) {
//            val line = readln().trim().split(",").map { it.toInt() }
//            result.add(line)
//        }
//        return result.toList()
    }

    override fun getWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln().split(",")?.map { it.trim().toInt() }!!
    }

    override fun getBonusNumber(): Int {
        println("보너스 번호를 입력해 주세요")
        return readln().toInt()
    }
}
