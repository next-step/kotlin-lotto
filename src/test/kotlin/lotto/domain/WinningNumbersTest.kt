package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class WinningNumbersTest : FunSpec({
    test("당첨번호는 6자리 번호와 보너스 번호를 갖는다.") {
        val lottoNumbers = LottoNumbers(setOf(1, 2, 3, 4, 5, 10))
        val bonusNumber = BonusNumber(11)
        val winningNumbers = WinningNumbers(lottoNumbers, bonusNumber)

        winningNumbers.numbers shouldBe lottoNumbers
        winningNumbers.bonusNumber shouldBe bonusNumber
    }
})
