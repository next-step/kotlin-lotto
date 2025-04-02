package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe

class LottoTest : FunSpec({
    context("lotto must contain 6 numbers") {
        test("with lotto numbers") {
            shouldNotThrowAny {
                Lotto(
                    listOf(
                        LottoNumber.from(1),
                        LottoNumber.from(2),
                        LottoNumber.from(3),
                        LottoNumber.from(4),
                        LottoNumber.from(5),
                        LottoNumber.from(6),
                    ),
                )
            }
        }

        test("with raw numbers") {
            shouldNotThrowAny {
                Lotto(1, 2, 3, 4, 5, 6)
            }
        }

        context("throw exception if list is below or above 6") {
            withData(
                listOf(1),
                listOf(1, 2, 3, 4, 5),
                listOf(1, 2, 3, 4, 5, 6, 7),
                listOf(1, 2, 3, 4, 5, 6, 7, 8),
            ) {
                shouldThrow<IllegalArgumentException> {
                    Lotto(*it.toIntArray())
                }
            }
        }
    }

    test("get raw numbers") {
        val expected = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(*expected.toIntArray())

        lotto.rawNumbers shouldContainAll listOf(1, 2, 3, 4, 5, 6)
    }

    test("lotto numbers are sorted after creation") {
        val lottoNumbers = listOf(1, 5, 2, 11, 6, 3)
        val lotto = Lotto(*lottoNumbers.toIntArray())
        val expected = lottoNumbers.sorted()

        lotto.rawNumbers shouldContainExactly expected
    }

    context("count matches") {
        withData(
            listOf(1, 2, 3, 4, 5, 6) to 6,
            listOf(1, 2, 3, 4, 5, 45) to 5,
            listOf(1, 2, 3, 4, 44, 45) to 4,
            listOf(1, 2, 3, 43, 44, 45) to 3,
            listOf(1, 2, 42, 43, 44, 45) to 2,
            listOf(1, 41, 42, 43, 44, 45) to 1,
            listOf(40, 41, 42, 43, 44, 45) to 0,
        ) { (numbers, matchCount) ->
            val lotto = Lotto(*numbers.toIntArray())
            val winningLotto = Lotto(1, 2, 3, 4, 5, 6)

            lotto.compareMatches(winningLotto) shouldBe matchCount
        }
    }
})
