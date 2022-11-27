package lotto.views

class InputView {
    fun insertMoney(): String {
        println("구입금액을 입력해 주세요.")
        val input = readLine()
        require(!input.isNullOrBlank())
        return input
    }

    fun getWinningLotto(): String {
        println("지난 주 당첨번호를 입력해 주세요.")
        val input = readLine()
        require(!input.isNullOrBlank())
        return input
    }
}
