package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class LottoResultAnalyzerTest {

    private val lottoResultAnalyzer: LottoResultAnalyzer = LottoResultAnalyzer

    @Test
    fun `3개가 당첨되면 4등이다`() {
        // given
        val lottoList = listOf(
            listOf(1, 2, 3, 4, 5, 6),
        )

        val winningLotto = listOf(1, 2, 3, 7, 8, 9)

        // when
        val result = lottoResultAnalyzer.analyze(lottoList, winningLotto)

        // then
        assertThat(result.fourthCount).isEqualTo(1)
    }

    @Test
    fun `4개가 당첨되면 3등이다`() {
        // given
        val lottoList = listOf(
            listOf(1, 2, 3, 4, 5, 6),
        )

        val winningLotto = listOf(1, 2, 3, 4, 8, 9)

        // when
        val result = lottoResultAnalyzer.analyze(lottoList, winningLotto)

        // then
        assertThat(result.thirdCount).isEqualTo(1)
    }

    @Test
    fun `5개가 당첨되면 2등이다`() {
        // given
        val lottoList = listOf(
            listOf(1, 2, 3, 4, 5, 6),
        )

        val winningLotto = listOf(1, 2, 3, 4, 5, 9)

        // when
        val result = lottoResultAnalyzer.analyze(lottoList, winningLotto)

        // then
        assertThat(result.secondCount).isEqualTo(1)
    }

    @Test
    fun `6개가 당첨되면 1등이다`() {
        // given
        val lottoList = listOf(
            listOf(1, 2, 3, 4, 5, 6),
        )

        val winningLotto = listOf(1, 2, 3, 4, 5, 6)

        // when
        val result = lottoResultAnalyzer.analyze(lottoList, winningLotto)

        // then
        assertThat(result.firstCount).isEqualTo(1)
    }

    @Test
    fun `맞은 번호가 3개 미만이면 꽝이다`() {
        // given
        val lottoList = listOf(
            listOf(1, 2, 3, 4, 5, 6),
        )

        val winningLotto = listOf(7, 8, 9, 10, 11, 12)

        // when
        val result = lottoResultAnalyzer.analyze(lottoList, winningLotto)

        // then
        assertThat(result.noneCount).isEqualTo(1)
    }

    @Test
    fun `꽝 3개, 2등 2개, 1등 1개 케이스`() {
        // given
        val lottoList = listOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(1, 2, 3, 4, 5, 7),
            listOf(1, 2, 3, 4, 5, 8),
            listOf(6, 11, 22, 33, 44, 45),
            listOf(1, 2, 30, 31, 32, 33),
            listOf(11, 22, 33, 34, 44, 45),
        )

        val winningLotto = listOf(1, 2, 3, 4, 5, 6)

        // when
        val result = lottoResultAnalyzer.analyze(lottoList, winningLotto)

        // then
        assertThat(result.noneCount).isEqualTo(3)
        assertThat(result.secondCount).isEqualTo(2)
        assertThat(result.firstCount).isEqualTo(1)
    }
}
