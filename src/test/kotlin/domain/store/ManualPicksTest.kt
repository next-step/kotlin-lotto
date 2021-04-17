package domain.store

import domain.lotto.Lotto
import domain.lotto.LottoNumbers
import domain.lotto.PickType
import domain.lotto.lottoNumberOf
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

internal class ManualPicksTest {
    @Test
    fun `수동선택은 로또숫자열 리스트로 생성된다`() {
        assertDoesNotThrow { ManualPicks(listOf<LottoNumbers>()) }
    }

    @Test
    fun `수동선택은 주어진 숫자열 순서대로 로또로 반환한다`() {
        // given
        val manualPicks = ManualPicks(
            listOf(
                lottoNumberOf(1, 2, 3, 4, 5, 6),
                lottoNumberOf(2, 3, 4, 5, 6, 7),
                lottoNumberOf(3, 4, 5, 6, 7, 8)
            )
        )

        val expected: List<LottoNumbers> = listOf(
            Lotto(lottoNumberOf(1, 2, 3, 4, 5, 6)),
            Lotto(lottoNumberOf(2, 3, 4, 5, 6, 7)),
            Lotto(lottoNumberOf(3, 4, 5, 6, 7, 8))
        ).map { it.numbers }

        // when
        val actual: List<LottoNumbers> = manualPicks.toLottos()
            .toList()
            .map { it.numbers }

        // then
        assertThat(actual).containsExactlyElementsOf(expected)
    }

    @Test
    fun `수동선택이 만든 로또는 모두 수동선택이다`() {
        // given
        val manualPicks = ManualPicks(
            listOf(
                lottoNumberOf(1, 2, 3, 4, 5, 6),
                lottoNumberOf(2, 3, 4, 5, 6, 7),
                lottoNumberOf(3, 4, 5, 6, 7, 8)
            )
        )

        // when
        val actual: List<Lotto> = manualPicks.toLottos().toList()

        // then
        assertThat(actual).allMatch { it.pickType == PickType.MANUAL }
    }
}
