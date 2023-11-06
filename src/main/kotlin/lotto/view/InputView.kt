package lotto.view

object InputView {
    fun readPrice(): Int {
        println("구입금액을 입력해 주세요.")
        return readlnOrNull()?.toInt() ?: throw IllegalArgumentException("정확한 구입금액을 입력해 주세요.")
    }

    fun readNumbers(): String {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readlnOrNull() ?: throw IllegalArgumentException("입력값이 없습니다.")
    }
}
