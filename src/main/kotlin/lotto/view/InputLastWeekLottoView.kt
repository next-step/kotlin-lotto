package lotto.view

import lotto.domain.NormalLottery
import lotto.infra.port.IOSystem

class InputLastWeekLottoView(private val ioSystem: IOSystem) {

    fun getLastWeekLotto(): NormalLottery {
        printInputLastWeekMessage()
        return inputLastWeekLotto()
    }

    private fun printInputLastWeekMessage() {
        ioSystem.write("지난 주 당첨 번호를 입력해 주세요.\n")
    }

    private fun inputLastWeekLotto() = NormalLottery(convertToNumbers(ioSystem.read()))

    private fun convertToNumbers(inputLottoNumbers: String): List<Int> =
        inputLottoNumbers
            .split(",")
            .map(String::trim)
            .map(String::toInt)
}
