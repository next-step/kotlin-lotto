package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoStoreTest {
    @ValueSource(ints = [14000, 23000])
    @ParameterizedTest
    fun `로또가 하나당 1000원으로 맞게 계산되는지 테스트`(money: Int) {
        val lottoStore = LottoStore(UserMoney(money))

        val answer = lottoStore.lottoCount
        val expect = money / 1000

        assertThat(answer).isEqualTo(expect)
    }

    @Test
    fun `로또 각당첨등수 개수가 바른지 테스트`() {
        val lottoAnswer = LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        val bonusBall = LottoNumber(10)
        val myMoney = 3000
        val lottoMaker = object : LottoMaker {
            private val lottoList = listOf(
                listOf(1, 2, 3, 43, 44, 45),
                listOf(1, 2, 3, 4, 5, 6),
                listOf(1, 2, 3, 5, 44, 45)
            )

            private var idx = 0

            override fun makeLottoNumbers(): LottoNumbers {
                return LottoNumbers(lottoList[idx++].map { LottoNumber(it) })
            }
        }

        val lottoStore = LottoStore(UserMoney(myMoney), lottoMaker)
        val lottoResult = lottoStore.getLottoResult(lottoAnswer, bonusBall)

        val answer3prize = lottoResult.first { it.prize == LottoPrizeInfo.WIN3 }.count
        val answer4prize = lottoResult.first { it.prize == LottoPrizeInfo.WIN4 }.count
        val answer5prize = lottoResult.first { it.prize == LottoPrizeInfo.WIN5 }.count
        val answer6prize = lottoResult.first { it.prize == LottoPrizeInfo.WIN6 }.count

        val expect3prize = 1
        val expect4prize = 1
        val expect5prize = 0
        val expect6prize = 1

        assertThat(answer3prize).isEqualTo(expect3prize)
        assertThat(answer4prize).isEqualTo(expect4prize)
        assertThat(answer5prize).isEqualTo(expect5prize)
        assertThat(answer6prize).isEqualTo(expect6prize)
    }

    @Test
    fun `로또 당첨의 수익률이 바른지 테스트`() {
        val lottoAnswer = LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        val bonusBall = LottoNumber(10)
        val myMoney = 3000
        val lottoMaker = object : LottoMaker {
            private val lottoList = listOf(
                listOf(1, 2, 3, 43, 44, 45),
                listOf(1, 2, 3, 4, 5, 6),
                listOf(1, 2, 3, 5, 44, 45)
            )

            private var idx = 0

            override fun makeLottoNumbers(): LottoNumbers {
                return LottoNumbers(lottoList[idx++].map { LottoNumber(it) })
            }
        }

        val lottoStore = LottoStore(UserMoney(myMoney), lottoMaker)

        val lottoResult = lottoStore.getLottoResult(lottoAnswer, bonusBall)

        val prize3 = lottoResult.first { it.prize == LottoPrizeInfo.WIN3 }
        val prize4 = lottoResult.first { it.prize == LottoPrizeInfo.WIN4 }
        val prize5 = lottoResult.first { it.prize == LottoPrizeInfo.WIN5 }
        val prize6 = lottoResult.first { it.prize == LottoPrizeInfo.WIN6 }

        val prize3Money = prize3.prize.money * prize3.count
        val prize4Money = prize4.prize.money * prize4.count
        val prize5Money = prize5.prize.money * prize5.count
        val prize6Money = prize6.prize.money * prize6.count

        val totalMoney = prize3Money + prize4Money + prize5Money + prize6Money
        val answer = lottoStore.totalYieldRatio
        val expect = totalMoney / myMoney.toDouble()

        assertThat(answer).isEqualTo(expect)
    }
}
