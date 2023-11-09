package lotto.component

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.model.*

class LottoTest : FunSpec({
    val lotto = Lotto()

    test("1장의 로또 입력 시 1개의 당첨 결과 성공 테스트") {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lottoTickets = listOf(LottoTicket(LottoNumbers(numbers)))
        val winningNumbers = WinningNumbers.create(numbers)

        val result: LottoResult = lotto.draw(lottoTickets, winningNumbers)

        result.lottoPrizes.size shouldBe 1
    }
})
