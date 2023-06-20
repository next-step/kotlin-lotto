package lotto.view

class InputView {

    fun readMoney(): Int {
        println("구입 금액을 입력해주세요.")
        return readLine()?.toIntOrNull() ?: throw NumberFormatException("숫자만 입력 가능합니다.")
    }

    fun readBonusNumber(): Int {
        println("보너스 볼을 입력해주세요.")
        return readLine()?.toIntOrNull() ?: throw NumberFormatException("숫자만 입력 가능합니다.")
    }
    fun readWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해주세요.")
        return readLine()?.split(", ")?.map { it.toInt() } ?: throw NumberFormatException("숫자만 입력 가능합니다.")
    }
}
