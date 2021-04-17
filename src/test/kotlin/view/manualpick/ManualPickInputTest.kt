package view.manualpick

import domain.lotto.LottoNumbers
import domain.lotto.lottoNumberOf
import domain.store.ManualPicks
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import view.ParsedLottoNumbers

internal class ManualPickInputTest {
    @Test
    internal fun `수동선택입력값은 수동선택으로 변환할 수 있다`() {
        // given

        val parsedNumbersList = listOf(
            ParsedLottoNumbers(listOf(1, 2, 3, 4, 5, 6)),
            ParsedLottoNumbers(listOf(2, 3, 4, 5, 6, 7))
        )

        val expectedList: List<LottoNumbers> = listOf(
            lottoNumberOf(1, 2, 3, 4, 5, 6),
            lottoNumberOf(2, 3, 4, 5, 6, 7)
        )

        // when
        val actual: ManualPicks = ManualPickInput(parsedNumbersList).toManualPicks()

        // then
        assertThat(actual.list).containsExactlyElementsOf(expectedList)
    }
}
