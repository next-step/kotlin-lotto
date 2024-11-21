package lotto.view

import lotto.domain.LottoTicket

object InputView {
    fun askPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readlnOrNull()?.toIntOrNull() ?: throw IllegalArgumentException("유효한 금액을 입력해 주세요.")
    }

    fun askWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val numbers =
            readlnOrNull()?.split(",")?.map { it.trim().toInt() }
                ?: throw IllegalArgumentException("1부터 45 사이의 숫자를 쉼표로 구분하여 입력해 주세요.")

        LottoTicket.validateNumbers(numbers) // 검증 로직 호출
        return numbers
    }
}
