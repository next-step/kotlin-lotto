package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class LottoTest : FunSpec({
    context("로또 번호는 6개이고 보너스 번호는 1개입니다.") {
        val lotto = Lotto(setOf(1, 2, 3, 4, 5, 6), 7)
        lotto.numbers.size shouldBe 6
        lotto.bonusNumber shouldBe 7
    }

    context("로또 번호가 6개가 아니면 오류가 발생합니다.") {
        withData(
            setOf(1, 2, 3, 4, 5) to "로또 번호는 6개여야 합니다.",
            setOf(1, 2, 3, 4, 5, 6, 7) to "로또 번호는 6개여야 합니다.",
        ) { (input, expected) ->
            shouldThrow<IllegalArgumentException> {
                Lotto(input, 45)
            }.message shouldBe expected
        }
    }

    context("로또 번호는 1~45 범위를 갖습니다.") {
        Lotto(setOf(1, 2, 3, 4, 5, 6), 45).numbers.numbers.forEach {
            // it이 1~45 범위인지 확인
            (it in 1..45) shouldBe true
        }
    }

    context("로또 번호가 1~45 범위가 아니면 오류가 발생합니다.") {
        withData(
            setOf(1, 2, 3, 4, 5, 46) to "로또 번호는 1부터 45 사이여야 합니다.",
            setOf(1, 2, 3, 4, 5, 0) to "로또 번호는 1부터 45 사이여야 합니다.",
        ) { (input, expected) ->
            shouldThrow<IllegalArgumentException> {
                Lotto(input, 45)
            }.message shouldBe expected
        }
    }

    context("로또의 일치 개수를 확인한다.") {
        withData(
            Pair(Lotto(listOf(1, 2, 3, 4, 5, 6)), Lotto(listOf(1, 2, 3, 4, 5, 6))) to 6,
            Pair(Lotto(listOf(1, 2, 3, 4, 5, 6)), Lotto(listOf(1, 2, 3, 4, 5, 7))) to 5,
            Pair(Lotto(listOf(1, 2, 3, 4, 5, 6)), Lotto(listOf(1, 2, 3, 4, 7, 8))) to 4,
            Pair(Lotto(listOf(1, 2, 3, 4, 5, 6)), Lotto(listOf(7, 8, 9, 10, 11, 12))) to 0,
        ) { (lottoAndWinningLotto, expectedCount) ->
            val (lotto, winningLotto) = lottoAndWinningLotto
            val matchCount = lotto.countMatch(winningLotto)
            matchCount shouldBe expectedCount
        }
    }
})
