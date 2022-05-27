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
        assertThat(LottoCompany(source).winningTicket).isNotNull
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
    internal fun `로또와 당첨번호가 일치하는 갯수를 찾고 몇등인지 잘 반환한다`(source: String) {
        val ticket = LottoTicket(listOf(1, 2, 3, 4, 5, 6))
        assertThat(LottoCompany(source).convertTicketsToLottoResults(listOf(ticket)).last().count).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(strings = ["0, 2, 3, 4, 5, 6", "1, 2, 3, 4, 5, 46"])
    internal fun `지난 주 당첨 번호가 1보다 작거나 45보다 크다면 IllegalArgumentException을 던진다`(source: String) {
        assertThrows<IllegalArgumentException> {
            LottoCompany(source)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["2, 2, 3, 4, 5, 6"])
    internal fun `당첨번호는 중복이 되면 IllegalArgumentException을 던진다`(source: String) {
        assertThrows<IllegalArgumentException> {
            LottoCompany(source)
        }
    }
}
