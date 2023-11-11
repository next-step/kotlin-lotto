package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.row
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf

class LottoTest : FunSpec({
    test("로또 한 장은 숫자 6개를 가진다.") {
        val lotto = Lotto(LottoNumbers(setOf(10, 20, 17, 45, 15, 6)))
        lotto.lottoNumbers.value.size shouldBe 6
        lotto.lottoNumbers.shouldBeInstanceOf<LottoNumbers>()
    }

    context("당첨 로또는 다른 로또와 비교하여 일치 개수를 계산할 수 있다.") {
        val lotto = Lotto(LottoNumbers(setOf(10, 15, 20, 25, 30, 35)))
        withData(
            row(setOf(9, 14, 19, 24, 29, 34), 0),
            row(setOf(10, 14, 19, 24, 29, 34), 1),
            row(setOf(10, 15, 19, 24, 29, 34), 2),
            row(setOf(10, 15, 20, 24, 29, 34), 3),
            row(setOf(10, 15, 20, 25, 29, 34), 4),
            row(setOf(10, 15, 20, 25, 30, 34), 5),
            row(setOf(10, 15, 20, 25, 30, 35), 6),
        ) { (winningNumbers, expected) ->
            lotto.match(LottoNumbers(winningNumbers)) shouldBe expected
        }
    }

    context("당첨 로또에 6개가 아닌 숫자를 전달하면 예외가 발생한다.") {
        val lotto = Lotto(LottoNumbers(setOf(10, 15, 20, 25, 30, 35)))
        withData(
            setOf(10, 15),
            setOf(10, 15, 20, 25, 29, 29),
            setOf(10, 15, 20, 25, 30, 35, 40)
        ) { winningNumbers ->
            shouldThrow<IllegalArgumentException> { lotto.match(LottoNumbers(winningNumbers)) }
        }
    }

    context("일치 개수를 계산할 때, 로또에 1부터 45 외의 숫자를 전달하면 예외가 발생한다.") {
        val lotto = Lotto(LottoNumbers(setOf(10, 15, 20, 25, 30, 35)))
        withData(
            setOf(10, 15, 20, 25, 30, 46),
            setOf(10, 15, 20, 25, 29, -1),
        ) { winningNumbers ->
            shouldThrow<IllegalArgumentException> { lotto.match(LottoNumbers(winningNumbers)) }
        }
    }
})
