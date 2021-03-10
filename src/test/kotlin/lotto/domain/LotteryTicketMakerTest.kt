package lotto.domain

import lotto.domain.maker.DefaultLotteryTicketMaker
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LotteryTicketMakerTest {

    @Test
    fun `로또 넘버를 생성한다`() {
        val lotteryTicketMaker = DefaultLotteryTicketMaker()
        val lotteryTicket: LotteryTicket = lotteryTicketMaker.createLotteryTicket()

        assertThat(lotteryTicket.lottoNumbers).hasSize(6)
        assertThat(lotteryTicket.lottoNumbers).isSubsetOf(1..45)

        // 겹치는 숫자가 없다.
        for (number in lotteryTicket.lottoNumbers) {
            val sameNumberCount = lotteryTicket.lottoNumbers.filter { it == number }.count()
            assertThat(sameNumberCount).isEqualTo(1)
        }

        // 정렬되어 있다.
        var preNum = 0
        for (number in lotteryTicket.lottoNumbers) {
            assertThat(number).isGreaterThan(preNum)
            preNum = number
        }
    }
}
