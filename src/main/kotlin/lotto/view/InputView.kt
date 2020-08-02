package lotto.view

object InputView {

    fun requestPrice(): Int {
        println("구입 금액을 입력해주세요.")
        return readLine()?.toInt() ?: 0
    }

    fun requestLastWeekLottoNumber(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readLine()?.split(",")?.map { it.toInt() } ?: emptyList()
    }
}
