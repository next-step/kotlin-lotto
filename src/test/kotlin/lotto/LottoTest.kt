package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.row
import io.kotest.datatest.withData
import io.kotest.inspectors.forAll
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf

class LottoTest : FunSpec({
    test("로또 한 장은 숫자 6개를 가진다.") {
        val lotto = Lotto(setOf(10, 20, 17, 45, 15, 6))
        lotto.numbers.size shouldBe 6
        lotto.numbers.shouldBeInstanceOf<Set<Int>>()
    }

    test("로또에 적힌 숫자 개수가 6개를 넘는다면 예외가 발생한다.") {
        shouldThrow<IllegalArgumentException> { Lotto(setOf(10, 15, 20, 25, 30, 35, 40)) }
    }

    test("로또에 적힌 숫자는 1부터 45 사이의 숫자다.") {
        val lotto = Lotto(setOf(10, 20, 17, 45, 16, 29))
        lotto.numbers.forAll { it shouldBeInRange (1..45) }
    }

    context("로또에 적힌 숫자가 1부터 45 사이의 숫자가 아니라면 예외가 발생한다.") {
        withData(
            setOf(0, 10, 20, 30, 35, 40),
            setOf(1, 20, 30, 40, 15, 46),
            setOf(1, 20, 30, 40, 15, 70),
            setOf(-10, 20, 30, 45, 15, 1)
        ) { numbers ->
            shouldThrow<IllegalArgumentException> { Lotto(numbers) }
        }
    }

    test("로또에 적힌 숫자가 중복된다면 예외가 발생한다.") {
        shouldThrow<IllegalArgumentException> { Lotto(setOf(10, 10, 20, 30, 40, 45)) }
    }

    context("당첨 로또는 다른 로또와 비교하여 일치 개수를 계산할 수 있다.") {
        val lotto = Lotto(setOf(10, 15, 20, 25, 30, 35))
        withData(
            row(setOf(9, 14, 19, 24, 29, 34), 0),
            row(setOf(10, 14, 19, 24, 29, 34), 1),
            row(setOf(10, 15, 19, 24, 29, 34), 2),
            row(setOf(10, 15, 20, 24, 29, 34), 3),
            row(setOf(10, 15, 20, 25, 29, 34), 4),
            row(setOf(10, 15, 20, 25, 30, 34), 5),
            row(setOf(10, 15, 20, 25, 30, 35), 6),
        ) { (winningNumbers, expected) ->
            lotto.match(winningNumbers) shouldBe expected
        }
    }

    context("당첨 로또에 6개가 아닌 숫자를 전달하면 예외가 발생한다.") {
        val lotto = Lotto(setOf(10, 15, 20, 25, 30, 35))
        withData(
            setOf(10, 15),
            setOf(10, 15, 20, 25, 29, 29),
            setOf(10, 15, 20, 25, 30, 35, 40)
        ) { winningNumbers ->
            shouldThrow<IllegalArgumentException> { lotto.match(winningNumbers) }
        }
    }

    context("일치 개수를 계산할 때, 로또에 1부터 45 외의 숫자를 전달하면 예외가 발생한다.") {
        val lotto = Lotto(setOf(10, 15, 20, 25, 30, 35))
        withData(
            setOf(10, 15, 20, 25, 30, 46),
            setOf(10, 15, 20, 25, 29, -1),
        ) { winningNumbers ->
            shouldThrow<IllegalArgumentException> { lotto.match(winningNumbers) }
        }
    }
})
