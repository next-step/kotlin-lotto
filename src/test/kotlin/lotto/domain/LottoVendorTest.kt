package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LottoVendorTest {
    @Test
    fun `입력한 로또 수 만큼의 Lotto 객체가 생성되어야 한다`() {
        val sut = LottoVendor
        val result = sut.generate(lottoCount = 3)
        assertThat(result.size).isEqualTo(3)
        assertTrue(result is List<Lotto>)
    }
}
