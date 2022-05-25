package lotto.domain

import lotto.model.LottoTicket
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

/**
 * Created by Jaesungchi on 2022.05.25..
 */
class LottoCompanyTest {
    @ParameterizedTest
    @ValueSource(strings = ["1, 2, 3, 4, 5, 6"])
    internal fun `지난 주 당첨 번호 입력 받은걸 ','로 나눈다`(source: String) {
        assertThat(LottoCompany(source).winningNumber.size).isEqualTo(6)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1, 2, 3, 4, 5"])
    internal fun `지난 주 당첨 번호는 6개가 아니라면 IllegalArgumentException을 던진다`(source: String) {
        assertThrows<IllegalArgumentException> {
            LottoCompany(source)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1, 2, 3, 4, 5, 6"])
    internal fun `로또와 당첨번호가 일치하는 갯수를 찾는다`(source: String) {
        val ticket = LottoTicket(listOf(1, 2, 3, 4, 5, 7))
        assertThat(LottoCompany(source).findCorrectLotto(ticket)?.matchCount).isEqualTo(5)
    }
}
