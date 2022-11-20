package lotto.application

import lotto.view.InputView

class Application {

    private val inputView = InputView()

    fun run() {
        val inputPayment = inputView.inputPayment()
        println(inputPayment)
        // todo 로또 생성
        // todo 로또 출력

        val inputLuckyNumbers = inputView.inputLuckyNumbers()
        println(inputLuckyNumbers)
        // todo 당첨 집계
        // todo 통계 출력
    }
}
