package lotto.view

/**
 * 로또 실행시, 입력받는 뷰
 * */
class InputView {
    fun inputLottoPrice(): Int? {
        println("구입금액을 입력해 주세요.")
        return readLine()?.toIntOrNull()
    }
}
