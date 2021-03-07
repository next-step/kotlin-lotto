package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LotteryTicketMakerTest {

    @Test
    fun `로또 넘버를 생성한다`() {
        val lotteryTicket: LotteryTicket = LotteryTicketMaker.createLotteryTicket()
        assertThat(lotteryTicket.numbers).hasSize(6)
        assertThat(lotteryTicket.numbers).isSubsetOf(1..45)

        //겹치는 숫자가 없다.
        for (number in lotteryTicket.numbers) {
            val sameNumberCount = lotteryTicket.numbers.filter { it == number }.count()
            assertThat(sameNumberCount).isEqualTo(1)
        }

        //정렬되어 있다.
        var preNum = 0
        for (number in lotteryTicket.numbers) {
            assertThat(number).isGreaterThan(preNum)
            preNum = number
        }

    }
}
