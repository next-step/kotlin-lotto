package lotto.business

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoTicketTest {
    @Test
    fun `서로 다른 로또 번호 6개로 티켓을 생성할 수 있다`() {
        // given
        val lottoNumber = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }.toSet()

        // when, then
        LottoTicket(lottoNumber)
    }

    @Test
    fun `서로 다른 로또 번호 6개가 아니면 예외를 던진다`() {
        // given
        val lottoNumber = listOf(1, 2, 3, 4, 5, 5).map { LottoNumber(it) }.toSet()

        // when, then
        assertThatThrownBy { LottoTicket(lottoNumber) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .message().isEqualTo("서로 다른 6개 로또 번호 이여야 합니다.")
    }

    @ParameterizedTest
    @CsvSource(
        value = ["1,2,3,4,5,6:6", "1,2,3,4,5,7:5", "1,2,3,4,7,8:4", "1,2,3,7,8,9:3", "1,2,7,8,9,10:2", "1,7,8,9,10,11:1", "7,8,9,10,11,12:0"],
        delimiter = ':'
    )
    fun `로또번호 리스트를 비교하여 일치하는 갯수를 반환한다`(input: String, expected: Int) {
        // given
        val lottoNumber = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }.toSet()
        val lottoTicket = LottoTicket(lottoNumber)
        val targetLottoNumbers = input.split(",").map { LottoNumber(it.toInt()) }.toSet()

        // when
        val matchCount = lottoTicket.matchCount(targetLottoNumbers)

        // then
        assertThat(matchCount).isEqualTo(expected)
    }
}
