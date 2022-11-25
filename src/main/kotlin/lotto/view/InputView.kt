package lotto.view

class InputView {

    fun getPurchaseFee(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun getWinNumbers(): String {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln()
    }
}
