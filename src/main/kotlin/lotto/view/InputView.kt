package lotto.view

object InputView {

    fun inputAmount(): Int {
        try {
            println("구입금액을 입력해 주세요.")
            return readln().toInt()
        } catch (e: Exception) {
            throw IllegalArgumentException("숫자만 입력해 주세요.")
        }
    }

    fun inputWinningLottoNumbers(): String {
        try {
            println("지난주 당첨 번호를 입력해 주세요.")
            return readln()
        } catch (e: Exception) {
            throw IllegalArgumentException("올바른 당첨번호를 입력해 주세요.")
        }
    }
}
