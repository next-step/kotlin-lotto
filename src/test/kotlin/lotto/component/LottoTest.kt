package lotto.component

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.model.LottoInput
import lotto.model.LottoResult
import lotto.model.WinningNumbers

class LottoTest : FunSpec({
    val lottoNumbersGenerator = LottoNumbersGenerator()
    val lotto = Lotto(lottoNumbersGenerator)

    test("N장의 로또 입력 시 N개의 당첨 결과 테스트") {
        val ticketCount = 10
        val lottoInput = LottoInput(ticketCount)
        val winningNumbers = WinningNumbers.create(listOf(1, 1, 1, 1, 1, 1))

        val result: LottoResult = lotto.draw(lottoInput, winningNumbers)

        result.lottoPrizes.size shouldBe ticketCount
    }
})
