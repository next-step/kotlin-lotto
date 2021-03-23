package lotto.view

object InputView {
    fun inputPrice(): Int {
        println("구입금액을 입력해 주세요.")
        return readLine()?.toInt() ?: 0
    }

    fun inputBonusNumber(): Int {
        println("보너스 볼을 입력해주세요.")
        val inputValue = readLine()?.toIntOrNull()
        return inputValue ?: throw IllegalArgumentException("$inputValue 는 숫자가 아닙니다")
    }

    fun inputWinnerLottoNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readLine()
            ?.split(",")
            ?.map {
                it.toIntOrNull() ?: throw IllegalArgumentException("$it 는 숫자가 아닙니다")
            } ?: throw IllegalStateException("잘못된 당첨 번호를 입력했습니다.")
    }
}
