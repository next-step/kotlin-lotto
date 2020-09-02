package lotto.view

object InputView {
    fun getGameMoney(): String {
        println("구입금액을 입력해 주세요.")
        return readLine()!!
    }

    fun getManualLottoCount(): String {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readLine()!!
    }

    fun getManualLottoNumbers(count: Int): List<String> {
        val manualLottoList = mutableListOf<String>()
        repeat(count) {
            println("수동으로 구매할 번호를 입력해 주세요.")
            manualLottoList.add(readLine()!!)
        }
        return manualLottoList
    }

    fun getWinningLotto(): Pair<String, String> {
        println("\n지난 주 당첨 번호를 입력해 주세요.")
        val prizeNumbers = readLine()!!
        println("\n보너스 볼을 입력해 주세요.")
        val bonusNumber = readLine()!!
        return Pair(prizeNumbers, bonusNumber)
    }
}
