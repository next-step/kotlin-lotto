package lotto.business

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoNumbersSorterTest {

    @Test
    fun `로또 번호를 오름차순으로 정렬한다`() {
        // given
        val lottoNumbers = listOf(5, 3, 2, 1, 4, 6).map { LottoNumber(it) }
        val lottoNumbersSorter = LottoNumbersSorter()
        val expected = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }

        // when
        val result = lottoNumbersSorter.sort(lottoNumbers)

        // then
        assertThat(result).isEqualTo(expected)
    }
}
