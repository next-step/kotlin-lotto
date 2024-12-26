package lotto

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoResultTest {

    @Test
    internal fun `구매한 로또와 결과가 일치`() {
        val winningLotto = Lotto(1, 2, 3, 4, 5, 6)

        val lottos = mutableListOf<Lotto>().apply {
            add(Lotto(8, 21, 23, 41, 42, 43))
            add(Lotto(3, 5, 11, 16, 32, 38))
            add(Lotto(7, 11, 16, 35, 36, 44))
            add(Lotto(1, 8, 11, 31, 41, 42))
            add(Lotto(13, 14, 16, 38, 42, 45))
            add(Lotto(7, 11, 30, 40, 42, 43))
            add(Lotto(2, 13, 22, 32, 38, 45))
            add(Lotto(23, 25, 33, 36, 39, 41))
            add(Lotto(1, 3, 5, 14, 22, 45))
            add(Lotto(5, 9, 38, 41, 43, 44))
            add(Lotto(2, 8, 9, 18, 19, 21))
            add(Lotto(13, 14, 18, 21, 23, 35))
            add(Lotto(17, 21, 29, 37, 42, 45))
            add(Lotto(3, 8, 27, 30, 35, 44))
        }

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
