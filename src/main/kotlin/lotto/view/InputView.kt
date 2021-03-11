package lotto.view

class InputView {

    fun inputPayment(): Int {
        println("구입금액을 입력해 주세요.")
        return readLine()?.toInt() ?: throw IllegalArgumentException("빈 값을 입력하셨습니다.")
    }

    fun inputWinnerNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readLine()?.split(",")?.map { it.trim().toInt() } ?: throw IllegalArgumentException("빈 값을 입력하셨습니다.")
    }
}
