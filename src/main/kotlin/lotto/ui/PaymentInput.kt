package lotto.ui

class PaymentInput : UI {
    var value: Int = 0
        private set

    override fun draw() {
        println("구입금액을 입력해 주세요.")
        val commandValue = readLine()!!
        this.value = commandValue.toInt()
    }
}
