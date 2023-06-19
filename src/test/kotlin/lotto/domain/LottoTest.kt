package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class LottoTest : FunSpec({

    test("로또를 뽑으면 6개 숫자를 반환한다") {
        val lotto = Lotto.draw(RandomLottoGenerator())

        lotto.lottoNumbers shouldHaveSize 6
    }

    test("로또 번호는 모두 1~45 숫자여야 한다") {
        val lotto = Lotto.draw(RandomLottoGenerator())

        lotto.lottoNumbers.forEach {
            (1..45).contains(it.number)
        }
    }

    test("로또 번호에 중복이 있으면 예외가 발생한다") {
        val exception = shouldThrow<IllegalArgumentException> {
            Lotto.of(listOf(1, 1, 3, 4, 5, 6))
        }

        exception.message shouldBe "로또번호는 중복이 없어야 합니다."
    }

    test("로또 번호가 6개가 아니면 예외가 발생한다") {
        val exception = shouldThrow<IllegalArgumentException> {
            Lotto.of(listOf(1, 2, 3, 4))
        }

        exception.message shouldBe "로또번호는 6개 이어야 합니다."
    }

    context("당첨로또와 보너스번호를 받아 상금을 반환한다") {
        data class WinningLottoPrize(val winningLottoNumbers: List<Int>, val bonusNumber: Int, val prize: Prize)

        val lotto = Lotto.of(listOf(1, 2, 3, 4, 5, 6))

        withData(
            nameFn = { "${it.winningLottoNumbers}, ${it.bonusNumber}, ${it.prize}" },
            WinningLottoPrize(listOf(40, 41, 42, 43, 44, 45), 9, Prize.MISS),
            WinningLottoPrize(listOf(40, 41, 42, 43, 44, 45), 6, Prize.MISS),
            WinningLottoPrize(listOf(1, 41, 42, 43, 44, 45), 9, Prize.MISS),
            WinningLottoPrize(listOf(1, 41, 42, 43, 44, 45), 6, Prize.MISS),
            WinningLottoPrize(listOf(1, 2, 42, 43, 44, 45), 9, Prize.MISS),
            WinningLottoPrize(listOf(1, 2, 42, 43, 44, 45), 6, Prize.MISS),
            WinningLottoPrize(listOf(1, 2, 3, 43, 44, 45), 9, Prize.FIFTH),
            WinningLottoPrize(listOf(1, 2, 3, 43, 44, 45), 6, Prize.FIFTH),
            WinningLottoPrize(listOf(1, 2, 3, 4, 44, 45), 9, Prize.FOURTH),
            WinningLottoPrize(listOf(1, 2, 3, 4, 44, 45), 6, Prize.FOURTH),
            WinningLottoPrize(listOf(1, 2, 3, 4, 5, 45), 9, Prize.THIRD),
            WinningLottoPrize(listOf(1, 2, 3, 4, 5, 45), 6, Prize.SECOND),
            WinningLottoPrize(listOf(1, 2, 3, 4, 5, 6), 9, Prize.FIRST),
            WinningLottoPrize(listOf(1, 2, 3, 4, 5, 6), 10, Prize.FIRST),
        ) { (winningLottoNumbers, bonusNumber, prize) ->
            val winningLotto = WinningLotto(Lotto.of(winningLottoNumbers), LottoNumber(bonusNumber))
            lotto.matchPrize(winningLotto) shouldBe prize
        }
    }
})
