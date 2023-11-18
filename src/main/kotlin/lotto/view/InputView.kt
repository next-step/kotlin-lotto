package lotto.view

object InputView {
    fun readCash(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toIntOrNull() ?: throw IllegalArgumentException("숫자 이외의 값일 수 없습니다.")
    }

    fun readLastWeekMatchNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln().split(",")
            .map {
                it.trim()
            }.map {
                it.toIntOrNull() ?: throw IllegalArgumentException("숫자 이외의 값일 수 없습니다.")
            }
    }
}
