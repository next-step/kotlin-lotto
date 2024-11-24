package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.doubles.shouldBeGreaterThan
import io.kotest.matchers.shouldBe
import lotto.fixture.FixedLottoNumberGenerator
import lotto.fixture.lottoFixture
import lotto.fixture.lottosFixture

class LottoServiceTest : StringSpec({
    val numbers = listOf(1, 2, 3, 4, 5, 6)
    val numberGenerator = FixedLottoNumberGenerator(numbers)
    val lottoStore = LottoStore(LottoFactory(numberGenerator))
    val incomeCalculator = LottoIncomeCalculator()
    val sut = LottoService(lottoStore, incomeCalculator)

    "로또를 입력받은 금액만큼 발행한다" {
        val money = Money(14_000)

        val actual = sut.issue(money)

        actual.quantity shouldBe 14
    }

    "로또와 당첨 번호를 입력받으면 로또 결과를 반환한다" {
        val lotto = lottosFixture(1, 2, 3, 4, 5, 6)
        val winningLotto = lottoFixture(1, 2, 3, 4, 5, 6)

        val actual = sut.getResult(lotto, winningLotto)

        actual.first shouldBe 1
        actual.prize shouldBe Money(2_000_000_000)
        actual.incomeRateValue shouldBeGreaterThan 0.0
    }
})
