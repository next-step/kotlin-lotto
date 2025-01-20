package lotto

import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Lottos
import lotto.domain.Prize
import org.junit.jupiter.api.Test

class LottoResultTest {

    @Test
    internal fun `6개가 일치하면 1등`() {
        val winningLotto = Lotto(1, 2, 3, 4, 5, 6)
        val bonusLottoNumber = LottoNumber(7)

        val lottos = Lottos(
            listOf(Lotto(1, 2, 3, 4, 5, 6))
        )

        val lottoResult = lottos.getResult(
            winningLotto = winningLotto,
            bonusLottoNumber = bonusLottoNumber
        )

        lottoResult[Prize.FIRST] shouldBe 1
    }

    @Test
    internal fun `5개가 일치하고 보너스번호가 일치하면 2등`() {
        val winningLotto = Lotto(1, 2, 3, 4, 5, 6)
        val bonusLottoNumber = LottoNumber(7)

        val lottos = Lottos(
            listOf(Lotto(1, 2, 3, 4, 5, 7))
        )

        val lottoResult = lottos.getResult(
            winningLotto = winningLotto,
            bonusLottoNumber = bonusLottoNumber
        )

        lottoResult[Prize.SECOND] shouldBe 1
    }

    @Test
    internal fun `5개가 일치하면 3등`() {
        val winningLotto = Lotto(1, 2, 3, 4, 5, 6)
        val bonusLottoNumber = LottoNumber(7)

        val lottos = Lottos(
            listOf(Lotto(1, 2, 3, 4, 5, 8))
        )

        val lottoResult = lottos.getResult(
            winningLotto = winningLotto,
            bonusLottoNumber = bonusLottoNumber
        )

        lottoResult[Prize.THIRD] shouldBe 1
    }

    @Test
    internal fun `4개가 일치하면 4등`() {
        val winningLotto = Lotto(1, 2, 3, 4, 5, 6)
        val bonusLottoNumber = LottoNumber(7)

        val lottos = Lottos(
            listOf(Lotto(1, 2, 3, 4, 8, 9))
        )

        val lottoResult = lottos.getResult(
            winningLotto = winningLotto,
            bonusLottoNumber = bonusLottoNumber
        )

        lottoResult[Prize.FOURTH] shouldBe 1
    }

    @Test
    internal fun `3개가 일치하면 5등`() {
        val winningLotto = Lotto(1, 2, 3, 4, 5, 6)
        val bonusLottoNumber = LottoNumber(7)

        val lottos = Lottos(
            listOf(Lotto(1, 2, 3, 8, 9, 10))
        )

        val lottoResult = lottos.getResult(
            winningLotto = winningLotto,
            bonusLottoNumber = bonusLottoNumber
        )

        lottoResult[Prize.FIFTH] shouldBe 1
    }

    @Test
    internal fun `2개 이하로 일치하면 당첨 없음`() {
        val winningLotto = Lotto(1, 2, 3, 4, 5, 6)
        val bonusLottoNumber = LottoNumber(7)

        val lottos = Lottos(
            listOf(Lotto(1, 2, 8, 9, 10, 11))
        )

        val lottoResult = lottos.getResult(
            winningLotto = winningLotto,
            bonusLottoNumber = bonusLottoNumber
        )

        lottoResult[Prize.NONE] shouldBe 1
    }

}
