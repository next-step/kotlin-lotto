package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import lotto.fixture.LottoNumbersFixtureMaker.createLottoNumbers
import lotto.domain.generator.RandomLottoNumbersGenerator

class WinningNumbersTest : FreeSpec({
    "당첨 번호는 중복되지 않는 6개의 로또 번호를 가진다." {
        repeat((0 until 100).count()) {
            val actual = WinningNumbers(RandomLottoNumbersGenerator.generate())

            actual.size shouldBe 6
        }
    }

    "6개가 아닌 로또 번호를 전달하면 예외를 던진다." - {
        (1..45).filter { it != 6 }.forEach {
            "$it 개의 로또 번호를 전달하면 예외를 던진다." {
                val actual = createLottoNumbers(it)

                shouldThrow<IllegalArgumentException> {
                    WinningNumbers(actual)
                }
            }
        }
    }

    "로또를 전달하면 당첨 등수를 반환 한다." {
        val winnerNumbers = createLottoNumbers(items = listOf(1, 2, 3, 4, 5, 6)).let(::WinningNumbers)

        listOf(
            createLottoNumbers(items = listOf(1, 2, 3, 4, 5, 6)).let(::Lotto) to Rank.FIRST,
            createLottoNumbers(items = listOf(1, 2, 3, 4, 5, 7)).let(::Lotto) to Rank.SECOND,
            createLottoNumbers(items = listOf(1, 2, 3, 4, 7, 8)).let(::Lotto) to Rank.THIRD,
            createLottoNumbers(items = listOf(1, 2, 3, 7, 8, 9)).let(::Lotto) to Rank.FOURTH,
            createLottoNumbers(items = listOf(1, 2, 7, 8, 9, 10)).let(::Lotto) to Rank.MISS,
            createLottoNumbers(items = listOf(1, 7, 8, 9, 10, 11)).let(::Lotto) to Rank.MISS
        ).forEach {
            val actual: Rank = winnerNumbers.matches(it.first)

            actual shouldBe it.second
        }
    }
})
