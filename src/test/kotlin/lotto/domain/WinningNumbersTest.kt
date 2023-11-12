package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.lang.RuntimeException

class WinningNumbersTest : FunSpec({
    test("당첨번호는 6자리 번호와 보너스 번호를 갖는다.") {
        val lottoNumbers = LottoNumbers(setOf(1, 2, 3, 4, 5, 10))
        val bonusNumber = BonusNumber(11)
        val winningNumbers = WinningNumbers(lottoNumbers, bonusNumber)

        winningNumbers.numbers shouldBe lottoNumbers
        winningNumbers.bonusNumber shouldBe bonusNumber
    }

    test("당첨번호의 6자리 번호와 보너스번호가 중복되면 예외가 발생한다.") {
        val lottoNumbers = LottoNumbers(setOf(1, 2, 3, 4, 5, 10))
        val bonusNumber = BonusNumber(10)
        shouldThrow<RuntimeException> { WinningNumbers(lottoNumbers, bonusNumber) }
    }
})
