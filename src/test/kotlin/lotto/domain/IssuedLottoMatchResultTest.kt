package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class IssuedLottoMatchResultTest {
    @ParameterizedTest
    @CsvSource(
        "1, 0, 0, 0, 0, 10000, 0.5",
        "1, 1, 0, 0, 0, 10000, 5.5",
        "0, 0, 1, 0, 0, 10000, 150.0",
        "0, 0, 0, 1, 0, 10000, 3000.0",
        "0, 0, 0, 0, 1, 10000, 200000.0",
    )
    internal fun `발급받은 로또의 번호 일치 결과와 구입 금액을 통해 로또의 수익률을 구할 수 있어야한다`(
        countOfFifth: Int,
        countOfFourth: Int,
        countOfThird: Int,
        countOfSecond: Int,
        countOfFirst: Int,
        seedMoney: Int,
        expectedEarningsRate: Double,
    ) {
        val sut = IssuedLottoMatchResult(
            lottoMatchResults = buildList {
                addAll(List(countOfFifth) { LottoMatchResult(3) })
                addAll(List(countOfFourth) { LottoMatchResult(4) })
                addAll(List(countOfThird) { LottoMatchResult(5) })
                addAll(List(countOfSecond) { LottoMatchResult(5, true) })
                addAll(List(countOfFirst) { LottoMatchResult(6) })
            }
        )
        val actualEarningsRate = sut.calculateEarningsRate(seedMoney)
        actualEarningsRate shouldBe expectedEarningsRate
    }
}
