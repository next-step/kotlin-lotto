package lotto.model

import lotto.model.number.LottoNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoTicketTest {
    @Test
    fun `LottoTicket 은 생성될때 주어진 generator 가 생성해준 숫자를 따라 로또 후보 번호가 생성된다`() {
        val testNumberGenerator = object : NumbersGenerator {
            override fun getNumbers(candidateSize: Int, resultSize: Int): List<Int> {
                return listOf(1, 2, 3, 4, 5, 6)
            }
        }

        val lottoTicket = LottoTicket(testNumberGenerator)

        assertThat(lottoTicket.lottoNumbers.size).isEqualTo(6)
        assertThat(lottoTicket.lottoNumbers.first()).isEqualTo(LottoNumber.get(1))
    }
}
