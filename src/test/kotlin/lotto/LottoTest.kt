package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.WithDataTestName
import io.kotest.datatest.withData
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe

class LottoTest : FunSpec({

    context("로또 정상 생성") {
        test("기본 생성자 사용") {
            val lottoNumbers = setOf(1, 2, 3, 4, 5, 6)
            val lotto = Lotto(lottoNumbers = lottoNumbers)

            lotto.lottoNumbers shouldBe lottoNumbers
        }

        test("자동 발급") {
            val lotto = Lotto.issueByAuto()
            lotto.lottoNumbers.forEach {
                it shouldBeInRange Lotto.MIN_LOTTO_NUMBER..Lotto.MAX_LOTTO_NUMBER
            }
            lotto.lottoNumbers.size shouldBe Lotto.LOTTO_NUMBER_SIZE
        }
    }

    context("로또 숫자 6개 아닌 경우 IllegalArgumentException throw") {
        withData(
            nameFn = { "lottNumbers : $it" },
            setOf(1, 2, 3, 4, 5),
            setOf(1, 2, 3, 4, 5, 6, 7),
        ) { lottoNumbers ->
            shouldThrow<IllegalArgumentException> {
                Lotto(lottoNumbers = lottoNumbers)
            }
        }
    }

    context("로또 숫자가 1~45 아닌 경우 IllegalArgumentException throw") {
        withData(
            nameFn = { "lottNumbers : $it" },
            setOf(-1, 2, 3, 4, 5, 6),
            setOf(0, 4, 10, 22, 1, 2),
            setOf(46, 44, 43, 42, 41, 40),
        ) { lottoNumbers ->
            shouldThrow<IllegalArgumentException> {
                Lotto(lottoNumbers = lottoNumbers)
            }
        }
    }

    context("로또끼리 몇개의 숫자가 일치하는지 비교할 수 있다.") {
        withData(
            LottoMatchNumberCountTestData(setOf(1, 2, 3, 4, 5, 6), setOf(1, 2, 3, 4, 5, 6), 6),
            LottoMatchNumberCountTestData(setOf(1, 2, 3, 4, 5, 6), setOf(1, 2, 3, 4, 5, 7), 5),
            LottoMatchNumberCountTestData(setOf(10, 20, 30, 40, 41, 42), setOf(10, 2, 3, 4, 5, 6), 1),
            LottoMatchNumberCountTestData(setOf(10, 20, 30, 40, 41, 42), setOf(1, 2, 3, 4, 5, 6), 0),
        ) { (lottoNumbers1, lottoNumbers2, matchNumberCount) ->

            val lotto1 = Lotto(lottoNumbers1)
            val lotto2 = Lotto(lottoNumbers2)
            lotto1.matchNumberCount(lotto2) shouldBe matchNumberCount
        }
    }
})

data class LottoMatchNumberCountTestData(val lottoNumbers1: Set<Int>, val lottoNumbers2: Set<Int>, val matchNumberCount: Int) : WithDataTestName {
    override fun dataTestName(): String = "$lottoNumbers1, $lottoNumbers2 => matchNumberCount : $matchNumberCount"
}
