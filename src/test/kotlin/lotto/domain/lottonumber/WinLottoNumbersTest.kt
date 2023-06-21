package lotto.domain.lottonumber

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec

class WinLottoNumbersTest : BehaviorSpec({

    Given("보너스 번호가") {
        val bonusNumber = LottoNumber(1)
        When("다른 번호들에 이미 존재하는 번호라면") {
            val lottoNumbers = lottoNumbers(1, 2, 3, 4, 5, 6)
            Then("RuntimeException 예외 처리를 한다") {
                shouldThrow<RuntimeException> { WinLottoNumbers(lottoNumbers, bonusNumber) }
            }
        }

        When("다른 번호들에는 없는 번호라면") {
            val lottoNumbers = lottoNumbers(2, 3, 4, 5, 6, 7)
            Then("당첨 번호를 만들 수 있다") {
                shouldNotThrow<Throwable> { WinLottoNumbers(lottoNumbers, bonusNumber) }
            }
        }
    }
})
