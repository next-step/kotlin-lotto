package lotto.views

object InputView {
    fun insertMoney(): String {
        println("구입금액을 입력해 주세요.")
        val input = readLine()
        require(!input.isNullOrBlank())
        return input
    }

    fun getWinningLotto(): Pair<String, String> {
        println("지난 주 당첨번호를 입력해 주세요.")
        val winningNumbers = readLine()
        require(!winningNumbers.isNullOrBlank())
        println("보너스 볼을 입력해 주세요.")
        val bonusNumber = readLine()
        require(!bonusNumber.isNullOrBlank())
        return Pair(winningNumbers, bonusNumber)
    }
}
