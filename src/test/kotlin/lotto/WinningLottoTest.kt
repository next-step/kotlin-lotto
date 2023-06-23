package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class WinningLottoTest : StringSpec({
    "중복되는 당첨번호가 입력되면 예외가 발생한다" {
        shouldThrow<IllegalArgumentException> {
            WinningLotto(LottoNumber.of(listOf(1, 1, 2, 3, 4, 5)), emptyList())
        }
    }

    "당첨번호와 보너스 번호에 중복이 있다면 예외가 발생한다" {
        shouldThrow<IllegalArgumentException> {
            WinningLotto(LottoNumber.of(listOf(1, 2, 3, 4, 5, 6)), LottoNumber.of(listOf(1)))
        }
    }

    "주어진 로또의 추첨 결과를 반환한다" {
        val sut = WinningLotto(LottoNumber.of(listOf(1, 2, 3, 4, 5, 6)), LottoNumber.of(listOf(7)))
        val lotto = Lotto(LottoNumber.of(listOf(1, 2, 3, 4, 10, 7)))
        val matchResult = sut.countMatch(lotto)
        matchResult.getTotalMatch() shouldBe 4
    }
})
