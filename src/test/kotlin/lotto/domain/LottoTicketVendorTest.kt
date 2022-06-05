package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTicketVendorTest {
    @Test
    fun `입력한 로또 수 만큼의 Lotto 객체가 생성되어야 한다`() {
        val sut = LottoVendor
        val result = sut.generate(lottoCount = 3)
        assertThat(result.size).isEqualTo(3)
    }
}
