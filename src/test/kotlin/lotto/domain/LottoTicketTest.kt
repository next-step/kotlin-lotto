package lotto.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName

internal class LottoTicketTest {

    @Test
    @DisplayName("숫자를 입력해 한장의 로또 티켓을 만든다")
    fun createLottoTicket() {
        val lottoTicket = LottoTicket.of(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lottoTicket).isNotNull
    }

    @Test
    @DisplayName("로또 티켓에 입력된 수가 6개가 아니면 에러를 발생한다")
    fun invalidLottoTicketsSize() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { LottoTicket.of(listOf(1, 2, 3, 4, 5, 6, 7)) }

        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { LottoTicket.of(listOf(1, 2, 3)) }
    }

    @Test
    @DisplayName("로또 티켓에 입력된 수의 중복을 자동으로 제거하여 제거한 수의 개수가 6개가 아니면 에러가 발생한다")
    fun invalidLottoTicketsSizeWithDuplication() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { LottoTicket.of(listOf(1, 2, 3, 4, 5, 5)) }
    }

    @Test
    @DisplayName("로또 티켓에 입력된 수의 중복을 자동으로 제거하여 제거한 수의 개수가 6개이면 올바르게 티켓이 생성된다.")
    fun duplicationEasterEgg() {
        val lottoTicket = LottoTicket.of(listOf(1, 2, 3, 4, 5, 5, 6))
        assertThat(lottoTicket).isNotNull
    }

    @Test
    @DisplayName("티켓에 입력된 숫자 중 범위에 벗어난 값이 있으면 에러가 발생한다")
    fun invalidLottoNumber() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { LottoTicket.of(listOf(1, 2, 3, 4, 5, 0)) }
    }

    @Test
    @DisplayName("toString() 출력 확인")
    fun printLottoNumber() {
        val lottoTicket = LottoTicket.of(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lottoTicket.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]")
    }

    @Test
    @DisplayName("갖고잇는 두 로또 티켓을 비교하여 겹치는 숫자의 개수를 반환한다.")
    fun winLottoTicketCount() {
        val winLottoTicket = LottoTicket.of(listOf(1, 2, 3, 4, 5, 6))
        val userLottoTicket = LottoTicket.of(listOf(5, 6, 7, 8, 9, 10))
        assertThat(userLottoTicket.getMatchCount(winLottoTicket)).isEqualTo(2)
    }
}
