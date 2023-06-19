package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class WinningNumbersTest : BehaviorSpec({
    given("당첨 번호 생성 시") {
        `when`("번호가 6개보다 작으면") {
            then("에러가 발생 한다.") {
                shouldThrow<RuntimeException> { WinningNumbers.of(listOf(1, 2, 3, 4, 5)) }
            }
        }
        `when`("번호가 6개보다 많으면") {
            then("에러가 발생 한다.") {
                shouldThrow<RuntimeException> { WinningNumbers.of(listOf(1, 2, 3, 4, 5, 6, 7)) }
            }
        }
        `when`("번호가 6개 이지만 중복이 존재 하면") {
            then("에러가 발생 한다.") {
                shouldThrow<RuntimeException> { WinningNumbers.of(listOf(1, 2, 3, 4, 6, 6)) }
            }
        }
    }
})

class WinningNumbersCountMatchingNumbersTest : ShouldSpec({
    context("당첨 번호 [1, 2, 3, 4, 5, 6]") {
        val winningNumbers = WinningNumbers.of(listOf(1, 2, 3, 4, 5, 6))
        context("로또 번호 [1, 2, 3, 4, 5, 6]") {
            val lottoNumbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }
            val lotto = Lotto(lottoNumbers)
            should("일치 숫자 수 = 6") {
                winningNumbers.countMatchingNumbers(lotto) shouldBe 6
            }
        }
        context("로또 번호 [1, 2, 3, 4, 5, 7]") {
            val lottoNumbers = listOf(1, 2, 3, 4, 5, 7).map { LottoNumber(it) }
            val lotto = Lotto(lottoNumbers)
            should("일치 숫자 수 = 5") {
                winningNumbers.countMatchingNumbers(lotto) shouldBe 5
            }
        }
    }
})
