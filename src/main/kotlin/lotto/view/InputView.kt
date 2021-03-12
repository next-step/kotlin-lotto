package lotto.view

class InputView {

    fun requestPrice(): Int {
        println("구입급액을 입력해주세요.")
        return readLine()!!.toInt()
    }

    fun requestSelfLottosNums(): List<List<Int>> {
        val selfLottoCount = requestSelfLottoCount()

        println("\n수동으로 구매할 번호를 입력해 주세요.")
        return (1..selfLottoCount).map { readNums() }
    }

    fun requestWinNums(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readNums()
    }

    fun requestBonusNum(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readLine()!!.toInt()
    }

    private fun requestSelfLottoCount(): Int {
        println("\n수동으로 구매할 로또 수를 입력해 주세요.")
        return readLine()!!.toInt()
    }

    private fun readNums(): List<Int> {
        return readLine()!!.split(DELIMITER).map { it.trim().toInt() }
    }

    companion object {
        private const val DELIMITER = ","
    }
}
