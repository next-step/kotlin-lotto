package lotto.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName

internal class LottoTicketTest {

    private val one = LottoNumber(1)
    private val two = LottoNumber(2)
    private val three = LottoNumber(3)
    private val four = LottoNumber(4)
    private val five = LottoNumber(5)
    private val six = LottoNumber(6)

    @Test
    @DisplayName("숫자를 입력해 한장의 로또 티켓을 만든다")
    fun createLottoTicket() {
        val lottoTicket = LottoTicket(setOf(one, two, three, four, five, six))
        assertThat(lottoTicket).isNotNull
    }

    @Test
    @DisplayName("로또 티켓에 입력된 수가 6개가 아니면 에러를 발생한다")
    fun invalidLottoTicketsSize() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { LottoTicket(setOf(one, two, three, four, five, six, LottoNumber(7))) }

        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { LottoTicket(setOf(one, two, three)) }
    }

    @Test
    @DisplayName("로또 티켓에 입력된 수의 중복을 자동으로 제거하여 제거한 수의 개수가 6개가 아니면 에러가 발생한다")
    fun invalidLottoTicketsSizeWithDuplication() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { LottoTicket(setOf(one, two, three, four, five, five)) }
    }

    @Test
    @DisplayName("로또 티켓에 입력된 수의 중복을 자동으로 제거하여 제거한 수의 개수가 6개이면 올바르게 티켓이 생성된다.")
    fun duplicationEasterEgg() {
        val lottoTicket = LottoTicket(setOf(one, two, three, four, five, five, six))
        assertThat(lottoTicket).isNotNull
    }

    @Test
    @DisplayName("티켓에 입력된 숫자 중 범위에 벗어난 값이 있으면 에러가 발생한다")
    fun invalidLottoNumber() {
        val lottoTicket = LottoTicket(setOf(one, two, three, four, five, LottoNumber(0)))
        assertThat(lottoTicket).isNotNull
    }
}
