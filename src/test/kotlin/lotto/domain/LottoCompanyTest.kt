package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

/**
 * Created by Jaesungchi on 2022.05.25..
 */
class LottoCompanyTest {
    @ParameterizedTest
    @CsvSource("'1, 2, 3, 4, 5, 6', 8")
    internal fun `지난 주 당첨 번호 입력 받은걸 ','로 나눈다`(winningNumbers: String, bonusNumber: Int) {
        assertThat(LottoCompany.of({ winningNumbers }, { bonusNumber }).winningTicket).isNotNull
    }

    @ParameterizedTest
    @CsvSource("'1, 2, 3, 4, 5', 8")
    internal fun `지난 주 당첨 번호는 6개가 아니라면 IllegalArgumentException을 던진다`(winningNumbers: String, bonusNumber: Int) {
        assertThrows<IllegalArgumentException> {
            LottoCompany.of({ winningNumbers }, { bonusNumber })
        }
    }

    @ParameterizedTest
    @CsvSource("'1, 2, 3, 4, 5, 6', 8")
    internal fun `로또번호와 당첨번호가 모두 일치하는 1등을 반환한다`(winningNumbers: String, bonusNumber: Int) {
        val ticket = LottoTicket.of(winningNumbers.split(", ").map { it.toInt() })
        assertThat(
            LottoCompany.of({ winningNumbers }, { bonusNumber })
                .convertTicketsToLottoResults(LottoTickets(listOf(ticket))).getPrizeCount(Prize.FIRST)
        ).isEqualTo(1)
    }

    @ParameterizedTest
    @CsvSource("'0, 2, 3, 4, 5, 6', 8", "'1, 2, 3, 4, 5, 46', 8")
    internal fun `지난 주 당첨 번호가 1보다 작거나 45보다 크다면 IllegalArgumentException을 던진다`(
        winningNumbers: String,
        bonusNumber: Int
    ) {
        assertThrows<IllegalArgumentException> {
            LottoCompany.of({ winningNumbers }, { bonusNumber })
        }
    }

    @ParameterizedTest
    @CsvSource("'1, 2, 3, 4, 5, 5', 8")
    internal fun `당첨번호는 중복이 되면 IllegalArgumentException을 던진다`(winningNumbers: String, bonusNumber: Int) {
        assertThrows<IllegalArgumentException> {
            LottoCompany.of({ winningNumbers }, { bonusNumber })
        }
    }

    @ParameterizedTest
    @CsvSource("'1, 2, 3, 4, 5, 6', 0", "'1, 2, 3, 4, 5, 6', 46")
    internal fun `보너스번호가 1보다 작거나 45보다 크다면 IllegalArgumentException을 던진다`(winningNumbers: String, bonusNumber: Int) {
        assertThrows<IllegalArgumentException> {
            LottoCompany.of({ winningNumbers }, { bonusNumber })
        }
    }

    @ParameterizedTest
    @CsvSource("'1, 2, 3, 4, 5, 6', 8")
    internal fun `로또티켓들을 당첨 결과로 잘 변경한다`(winningNumbers: String, bonusNumber: Int) {
        val company = LottoCompany.of({ winningNumbers }, { bonusNumber })
        val tickets =
            LottoTickets(listOf(LottoTicket.of(listOf(1, 2, 3, 4, 5, 6)), LottoTicket.of(listOf(1, 2, 3, 4, 5, 7))))
        assertThat(company.convertTicketsToLottoResults(tickets).results.size).isEqualTo(2)
    }

    @ParameterizedTest
    @CsvSource("'1, 2, 3, 4, 5, 6', 6")
    internal fun `보너스 번호와 당첨번호는 중복될 수 없다`(winningNumbers: String, bonusNumber: Int) {
        assertThrows<IllegalArgumentException> {
            LottoCompany.of({ winningNumbers }, { bonusNumber })
        }
    }

    @ParameterizedTest
    @CsvSource("'1, 2, 3, 4, 5, 6, 7', 6")
    internal fun `보너스 번호는 6개가 아닐 경우 IllegalArgumentException을 던진다`(winningNumbers: String, bonusNumber: Int) {
        assertThrows<IllegalArgumentException> {
            LottoCompany.of({ winningNumbers }, { bonusNumber })
        }
    }
}
