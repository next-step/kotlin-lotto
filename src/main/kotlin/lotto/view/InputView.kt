package lotto.view

class InputView {

    fun queryPrice(): Int {
        println("구입급액을 입력해주세요.")
        return readLine()!!.toInt()
    }

    fun queryWinNums(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readLine()!!.split(", ").map(String::toInt)
    }
}
