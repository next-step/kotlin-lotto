package lotto

import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Lottos
import lotto.domain.Prize
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class LottoResultTest {
    @ParameterizedTest
    @MethodSource("provideLottoTestCases")
    internal fun `로또 결과 테스트`(testCase: TestCase) {
        val winningLotto = Lotto(1, 2, 3, 4, 5, 6)
        val bonusLottoNumber = LottoNumber(7)

        val lottoResult = testCase.lottos.getResult(
            winningLotto = winningLotto,
            bonusLottoNumber = bonusLottoNumber
        )

        lottoResult[testCase.expectedPrize] shouldBe 1
    }

    data class TestCase(
        val lottos: Lottos,
        val expectedPrize: Prize
    )

    companion object {
        @JvmStatic
        fun provideLottoTestCases() = listOf(
            TestCase(
                lottos = Lottos(listOf(Lotto(1, 2, 3, 4, 5, 6))),
                expectedPrize = Prize.FIRST
            ),
            TestCase(
                lottos = Lottos(listOf(Lotto(1, 2, 3, 4, 5, 7))),
                expectedPrize = Prize.SECOND
            ),
            TestCase(
                lottos = Lottos(listOf(Lotto(1, 2, 3, 4, 5, 8))),
                expectedPrize = Prize.THIRD
            ),
            TestCase(
                lottos = Lottos(listOf(Lotto(1, 2, 3, 4, 8, 9))),
                expectedPrize = Prize.FOURTH
            ),
            TestCase(
                lottos = Lottos(listOf(Lotto(1, 2, 3, 8, 9, 10))),
                expectedPrize = Prize.FIFTH
            ),
            TestCase(
                lottos = Lottos(listOf(Lotto(1, 2, 8, 9, 10, 11))),
                expectedPrize = Prize.NONE
            )
        )
    }

}
