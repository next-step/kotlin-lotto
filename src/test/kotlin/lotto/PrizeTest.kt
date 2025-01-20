package lotto

import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Prize
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class PrizeTest {
    @Test
    internal fun `로또 당첨 금액`() {
        Prize.FIRST.money shouldBe 2_000_000_000
        Prize.SECOND.money shouldBe 30_000_000
        Prize.THIRD.money shouldBe 1_500_000
        Prize.FOURTH.money shouldBe 50_000
        Prize.FIFTH.money shouldBe 5_000
        Prize.NONE.money shouldBe 0
    }

    @Test
    fun `당첨 개수`() {
        Prize.FIRST.count shouldBe 6
        Prize.SECOND.count shouldBe 5
        Prize.THIRD.count shouldBe 5
        Prize.FOURTH.count shouldBe 4
        Prize.FIFTH.count shouldBe 3
        Prize.NONE.count shouldBe 0
    }

    @ParameterizedTest
    @MethodSource("providePrizeTestCase")
    fun `Prize 케이스`(testCase: TestCase) {
        val prize = Prize.of(
            matchCount = testCase.matchCount,
            bonusLottoNumber = testCase.bonusLottoNumber,
            lotto = Lotto(1, 2, 3, 4, 5, 6)
        )
        prize shouldBe testCase.expectedPrize
    }

    data class TestCase(
        val matchCount: Int,
        val bonusLottoNumber: LottoNumber,
        val expectedPrize: Prize
    )

    companion object {
        @JvmStatic
        fun providePrizeTestCase() = listOf(
            TestCase(
                matchCount = 6,
                bonusLottoNumber = LottoNumber(10),
                expectedPrize = Prize.FIRST
            ),
            TestCase(
                matchCount = 5,
                bonusLottoNumber = LottoNumber(1),
                expectedPrize = Prize.SECOND
            ),
            TestCase(
                matchCount = 5,
                bonusLottoNumber = LottoNumber(10),
                expectedPrize = Prize.THIRD
            ),
            TestCase(
                matchCount = 4,
                bonusLottoNumber = LottoNumber(10),
                expectedPrize = Prize.FOURTH
            ),
            TestCase(
                matchCount = 3,
                bonusLottoNumber = LottoNumber(10),
                expectedPrize = Prize.FIFTH
            ),
            TestCase(
                matchCount = 0,
                bonusLottoNumber = LottoNumber(10),
                expectedPrize = Prize.NONE
            )
        )
    }

}
