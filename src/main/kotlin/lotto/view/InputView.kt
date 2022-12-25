package view

class InputView {
    fun start(): String? {
        val startMsg = "구입금액을 입력해주세요"
        println(startMsg)
        return readln()
    }

    fun winLottery(): String? {
        var winLotteryMsg = "지난 주 당첨 번호를 입력해주세요."
        println(winLotteryMsg)
        return readln()
    }
}
