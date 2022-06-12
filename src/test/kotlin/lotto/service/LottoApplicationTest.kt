package lotto.service

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContain
import lotto.util.InputModule
import lotto.util.OutPutModule
import lotto.util.RandomGenerate

class LottoApplicationTest : DescribeSpec({

    it("로또를 구매하고 당첨 금액을 통계로 알 수 있다") {
        // given
        val buyLottoNumbers = listOf<List<Int>>(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(1, 2, 3, 4, 5, 7),
            listOf(1, 2, 3, 4, 5, 8),
            listOf(1, 2, 3, 4, 15, 8),
            listOf(1, 2, 3, 14, 15, 8),
            listOf(1, 2, 13, 14, 15, 8),
            listOf(1, 12, 13, 14, 15, 8),
            listOf(11, 12, 13, 14, 15, 8),
        )

        val stubInputModule: InputModule = object : InputModule {
            val MONEY_STRING = (buyLottoNumbers.size * 1000).toString()
            val WINNING_NUMBER_STRING = "1, 2, 3, 4, 5, 6"
            val PASSIVE_TICKETS = listOf(
                "1, 2, 3 ,4 ,5, 6",
                "1, 2, 3 ,4 ,5, 10",
                "15, 14, 13 ,12 ,11, 10",
            )
            val BONUS_NUMBER_STRING = "7"
            val inputStore = mutableListOf(
                MONEY_STRING,
                PASSIVE_TICKETS.size.toString(),
                PASSIVE_TICKETS[0],
                PASSIVE_TICKETS[1],
                PASSIVE_TICKETS[2],
                WINNING_NUMBER_STRING,
                BONUS_NUMBER_STRING
            )
            override fun read(): String {
                return inputStore.removeFirst()
            }
        }
        val stubOutPutModule = object : OutPutModule {
            val writeStore = mutableListOf<String>()
            override fun write(outputValue: String) {
                writeStore.add(outputValue)
            }
        }
        val stubRandomGenerate = object : RandomGenerate {
            var index = 0
            override fun makeRandomUniqueIntList(listSize: Int, randomRange: IntRange): List<Int> {
                return buyLottoNumbers[index++]
            }
        }
        val lottoApplication = LottoApplication(stubInputModule, stubOutPutModule, stubRandomGenerate)

        // when
        lottoApplication.run()

        // then
        stubOutPutModule.writeStore shouldContain "8를 구매했습니다\n" +
            "[1, 2, 3, 4, 5, 6]\n" +
            "[1, 2, 3, 4, 5, 7]\n" +
            "[1, 2, 3, 4, 5, 8]\n" +
            "[1, 2, 3, 4, 8, 15]\n" +
            "[1, 2, 3, 8, 14, 15]\n" +
            "[1, 2, 8, 13, 14, 15]\n" +
            "[1, 8, 12, 13, 14, 15]\n" +
            "[8, 11, 12, 13, 14, 15]\n"
        stubOutPutModule.writeStore shouldContain "6개 일치 (2000000000원)- 1개\n5개 일치, 보너스 볼 일치 (30000000원)- 1개\n5개 일치 (1500000원)- 1개\n4개 일치 (50000원)- 1개\n5개 일치 (1500000원)- 1개\n3개 일치 (5000원)- 1개"
        stubOutPutModule.writeStore shouldContain "총 수익률은 254131.87입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
    }
})
