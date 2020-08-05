package lotto.view

object InputView {

    fun requestPrice(): Int {
        println("구입 금액을 입력해주세요.")
        return readLine()?.toInt() ?: 0
    }

    fun requestLastWeekLottoNumber(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val lastWeekLottoNumber = readLine()?.split(",")?.map { it.toIntOrNull() ?: 0 } ?: emptyList()
        require(lastWeekLottoNumber.size == 6) {
            "로또 번호는 6개까지 입력 가능합니다."
        }
        return lastWeekLottoNumber
    }

    fun requestBonusBall(): Int {
        println("보너스 볼을 입력해주세요.")
        return readLine()?.toInt() ?: 0
    }
}
