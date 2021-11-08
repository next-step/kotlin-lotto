package lotto.view

/**
 * 로또 실행시, 입력받는 뷰
 * */
class InputView {
    fun takePurchasedPrice(): Int? {
        println("구입금액을 입력해 주세요.")
        return readLine()?.toIntOrNull()
    }

    fun inputLastLottoWinNumber(): String? {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readLine()
    }

    fun inputBonusNumber(): Int? {
        println("보너스 볼을 입력해 주세요.")
        return readLine()?.toIntOrNull()
    }
}
