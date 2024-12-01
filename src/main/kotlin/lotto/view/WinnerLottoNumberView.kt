package lotto.view

object WinnerLottoNumberView {
    fun view(): String? {
        println("\n지난 주 당첨 번호를 입력해 주세요.")
        return readlnOrNull()
    }
}
