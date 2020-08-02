package lotto.view

object InputView {
    fun getAmountOfMoney(): Int {
        print("구입금액을 입력해 주세요.")

        return readLine()!!.toInt()
    }
}
