package lotto.auto.view

import lotto.auto.domain.Lotto
import lotto.auto.infra.port.IOSystem

class InputLastWeekLottoView(private val ioSystem: IOSystem) {

    fun getLastWeekLotto(): Lotto {
        printInputLastWeekMessage()
        return inputLastWeekLotto()
    }

    private fun printInputLastWeekMessage() {
        ioSystem.write("지난 주 당첨 번호를 입력해 주세요.\n")
    }

    private fun inputLastWeekLotto() = Lotto(convertToNumbers(ioSystem.read()))

    private fun convertToNumbers(inputLottoNumbers: String): List<Int> =
        inputLottoNumbers
            .split(",")
            .map(String::trim)
            .map(String::toInt)
}
