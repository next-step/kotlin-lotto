package lotto.domain

import lotto.data.LottoNumber
import lotto.domain.maker.DefaultLotteryTicketMaker
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LotteryTicketMakerTest {

    @Test
    fun `로또 넘버를 생성한다`() {
        val lotteryTicketMaker = DefaultLotteryTicketMaker()
        val lotteryTicket: LotteryTicket = lotteryTicketMaker.createAutoLotteryTicket()

        val lottoNumberList: List<LottoNumber> = lotteryTicket.lottoNumbers.lottoNumbers
        assertThat(lottoNumberList).hasSize(6)
        assertThat(lottoNumberList).isSubsetOf((1..45).map { LottoNumber.from(it) })

        // 겹치는 숫자가 없다.
        for (number in lottoNumberList) {
            val sameNumberCount = lottoNumberList.filter { it == number }.count()
            assertThat(sameNumberCount).isEqualTo(1)
        }

        // 정렬되어 있다.
        var preNum = 0
        for (lottoNumber in lottoNumberList) {
            assertThat(lottoNumber.lottoNumber).isGreaterThan(preNum)
            preNum = lottoNumber.lottoNumber
        }
    }

    @Test
    fun `수동 넘버를 생성한다`() {
        val lotteryTicketMaker = DefaultLotteryTicketMaker()
        val lotteryTicket: LotteryTicket = lotteryTicketMaker.createManualLotteryTicket(listOf(11, 12, 13, 14, 15, 16))

        val numbers = lotteryTicket.lottoNumbers.lottoNumbers
        assertThat(numbers).containsExactly(
            LottoNumber.from(11),
            LottoNumber.from(12),
            LottoNumber.from(13),
            LottoNumber.from(14),
            LottoNumber.from(15),
            LottoNumber.from(16)
        )
    }
}
