package lotto.view

import lotto.model.LottoTicket

object InputView {
    fun getPurchasePrice(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun getWinningNumbers(): Pair<List<Int>, Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")

        val numbers = readln().split(",").map { it.trim().toInt() }

        require(numbers.size == LottoTicket.NUMBER_COUNT) { "당첨 번호는 ${LottoTicket.NUMBER_COUNT}개 여야 합니다" }

        println("보너스 볼을 입력해 주세요.")

        val bonusNumber = readln().toInt()

        return Pair(numbers, bonusNumber)
    }
}
