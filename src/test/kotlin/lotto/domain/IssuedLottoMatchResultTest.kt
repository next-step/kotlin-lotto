package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class IssuedLottoMatchResultTest {
    @ParameterizedTest
    @CsvSource(
        "1, 0, 0, 0, 10000, 0.5",
        "1, 1, 0, 0, 10000, 5.5",
        "0, 0, 1, 0, 10000, 150.0",
        "0, 0, 0, 1, 10000, 200000.0",
    )
    internal fun `발급받은 로또의 번호 일치 결과와 구입 금액을 통해 로또의 수익률을 구할 수 있어야한다`(
        countOfThreeMatch: Int,
        countOfFourMatch: Int,
        countOfFiveMatch: Int,
        countOfSixMatch: Int,
        seedMoney: Int,
        expectedEarningsRate: Double,
    ) {
        val sut = IssuedLottoMatchResult(
            lottoMatchResults = buildList {
                addAll(List(countOfThreeMatch) { LottoMatchResult(3) })
                addAll(List(countOfFourMatch) { LottoMatchResult(4) })
                addAll(List(countOfFiveMatch) { LottoMatchResult(5) })
                addAll(List(countOfSixMatch) { LottoMatchResult(6) })
            }
        )
        val actualEarningsRate = sut.calculateEarningsRate(seedMoney)
        actualEarningsRate shouldBe expectedEarningsRate
    }
}
