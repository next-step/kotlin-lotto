package lotto.view.input

object ManualLottoAmountInputView {
    fun print(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readln().toInt()
    }
}
