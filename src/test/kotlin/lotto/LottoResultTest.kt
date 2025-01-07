package lotto

import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoResult
import lotto.domain.Lottos
import lotto.domain.Prize
import org.junit.jupiter.api.Test

class LottoResultTest {

    @Test
    internal fun `구매한 로또와 결과가 일치`() {
        val winningLotto = Lotto(1, 2, 3, 4, 5, 6)

        val lottos = Lottos(
            listOf(
                Lotto(8, 21, 23, 41, 42, 43),
                Lotto(3, 5, 11, 16, 32, 38),
                Lotto(7, 11, 16, 35, 36, 44),
                Lotto(1, 8, 11, 31, 41, 42),
                Lotto(13, 14, 16, 38, 42, 45),
                Lotto(7, 11, 30, 40, 42, 43),
                Lotto(2, 13, 22, 32, 38, 45),
                Lotto(23, 25, 33, 36, 39, 41),
                Lotto(1, 3, 5, 14, 22, 45),
                Lotto(5, 9, 38, 41, 43, 44),
                Lotto(2, 8, 9, 18, 19, 21),
                Lotto(13, 14, 18, 21, 23, 35),
                Lotto(17, 21, 29, 37, 42, 45),
                Lotto(3, 8, 27, 30, 35, 44),
            )
        )


        val lottoResult = LottoResult.makeLottoResult(
            winningLotto = winningLotto,
            lottos = lottos
        )

        lottoResult[Prize.FIRST] shouldBe 0
        lottoResult[Prize.SECOND] shouldBe 0
        lottoResult[Prize.THIRD] shouldBe 0
        lottoResult[Prize.FOURTH] shouldBe 1
        lottoResult[Prize.NONE] shouldBe 13
    }
}
