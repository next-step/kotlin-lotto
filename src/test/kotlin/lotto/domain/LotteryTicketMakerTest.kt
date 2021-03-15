package lotto.domain

import lotto.data.LottoNumber
import lotto.data.LottoNumbers
import lotto.domain.maker.DefaultLotteryTicketMaker
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LotteryTicketMakerTest {

    @Test
    fun `로또 넘버를 생성한다`() {
        val lotteryTicketMaker = DefaultLotteryTicketMaker()
        val lotteryTicket: LotteryTicket = lotteryTicketMaker.createAutoLotteryTicket()

        val numberList: List<Int> = lotteryTicket.lottoNumbers.toIntList()
        assertThat(numberList).hasSize(6)
        assertThat(numberList).isSubsetOf((1..45))

        // 겹치는 숫자가 없다.
        for (number in numberList) {
            val sameNumberCount = numberList.filter { it == number }.count()
            assertThat(sameNumberCount).isEqualTo(1)
        }

        // 정렬되어 있다.
        var preNum = 0
        for (number in numberList) {
            assertThat(number).isGreaterThan(preNum)
            preNum = number
        }
    }

    @Test
    fun `수동 넘버를 생성한다`() {
        val lotteryTicketMaker = DefaultLotteryTicketMaker()
        val lottoNumbers = LottoNumbers(listOf(11, 12, 13, 14, 15, 16))
        val lotteryTicket: LotteryTicket = lotteryTicketMaker.createManualLotteryTicket(lottoNumbers)

        val numbers = lotteryTicket.lottoNumbers.toIntList()
        assertThat(numbers).containsExactly(11, 12, 13, 14, 15, 16)
    }
}
