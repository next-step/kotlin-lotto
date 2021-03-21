package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ManualNumbersTest {
    @Test
    fun `수동번호를 로또리스트로 변환한다`() {
        val manualNumbers = ManualNumbers(listOf("1,2,3,4,5,6", "11,12,13,14,15,16"))
        val lottos = manualNumbers.toLottos()
        assertThat(lottos.size).isEqualTo(2)
        (1..6).forEach {
            assertThat(lottos[0].contains(LottoNumber.from(it))).isTrue()
        }
        (11..16).forEach {
            assertThat(lottos[1].contains(LottoNumber.from(it))).isTrue()
        }
    }
}
