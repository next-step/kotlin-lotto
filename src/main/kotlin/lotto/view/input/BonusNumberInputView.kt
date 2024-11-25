package lotto.view.input

object BonusNumberInputView {
    fun print(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readln().toInt()
    }
}
