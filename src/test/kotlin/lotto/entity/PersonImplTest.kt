package lotto.entity

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class PersonImplTest {
    @Test
    fun `사람은 지갑을 가지고 있다`() {
        // given
        val testWallet = Wallet(10000)
        val person = PersonImpl(testWallet)

        // then
        Assertions.assertThat(person.wallet).isEqualTo(testWallet)
    }

    @Test
    fun `10500원으로 10장의 로또 티켓을 구매한다`() {
        // given
        val wallet = Wallet(10500)
        val player = PersonImpl(wallet)

        // when
        val tickets = player.purchase().tickets

        // then
        Assertions.assertThat(tickets.size).isEqualTo(10)
    }

    @Test
    fun `3700원으로 3장의 로또 티켓을 구매한다`() {
        // given
        val wallet = Wallet(3700)
        val player = PersonImpl(wallet)

        // when
        val tickets = player.purchase().tickets

        // then
        Assertions.assertThat(tickets.size).isEqualTo(3)
    }

    @Test
    fun `3700원으로 4장의 로또 티켓을 구매할 수 없다`() {
        // given
        val wallet = Wallet(3700)
        val player = PersonImpl(wallet)

        // when
        val tickets = player.purchase().tickets

        // then
        Assertions.assertThat(tickets.size).isNotEqualTo(4)
    }

    @Test
    fun `3700원으로 2장의 로또 티켓을 수동으로 입력한 경우 1장의 티켓을 구매한다`() {
        // given
        val wallet = Wallet(3700)
        val player = PersonImpl(wallet)

        val markedTicket1 = LottoTicket(listOf(1, 2, 3, 4, 5, 6))
        val markedTicket2 = LottoTicket(listOf(7, 8, 9, 10, 11, 12))
        val markedList = listOf<LottoTicket>(markedTicket1, markedTicket2)
        val markedWallet = player.markLottoTicket(2, markedList)
        val makredPlayer = PersonImpl(markedWallet)

        // when
        val tickets = makredPlayer.purchase().tickets

        // then
        Assertions.assertThat(tickets.size).isNotEqualTo(1)
    }

    @Test
    fun `3400원이 든 지갑을 가진 사람은 3400원을 꺼낼 수 있다`() {
        // given
        val wallet = Wallet(3400)
        val player = PersonImpl(wallet)

        // when
        val playerMoney = player.money()

        // then
        Assertions.assertThat(playerMoney).isEqualTo(wallet.money)
    }
}
