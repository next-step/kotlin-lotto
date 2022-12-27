package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoTest : StringSpec({

    "로또 번호가 6개를 넘으면 에러 발생 테스트" {
        val numbers = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6),
            LottoNumber(7)
        )
        val exception = shouldThrowExactly<IllegalArgumentException> {
            Lotto(numbers)
        }
        exception.message shouldBe "로또 번호는 6개가 필요합니다."
    }

    "로또 번호 중복 에러 테스트" {
        val numbers = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(1)
        )
        val exception = shouldThrowExactly<IllegalArgumentException> {
            Lotto(numbers)
        }
        exception.message shouldBe "번호에 중복이 있습니다."
    }

    "당첨 번호 개수 카운트 테스트" {
        // given
        val numbers = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6)
        )
        val lotto = Lotto(numbers)

        val luckyNumbers = listOf(
            LottoNumber(2),
            LottoNumber(4),
            LottoNumber(6),
            LottoNumber(8),
            LottoNumber(10),
            LottoNumber(12)
        )
        val luckyLotto = Lotto(luckyNumbers)
        // when
        val actual = lotto.countHitNumbers(luckyLotto)
        // then
        actual shouldBe 3
    }

    "보너스 번호 포함되면 containsBonusNumber에서 true를 반환" {
        // given
        val numbers = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6)
        )
        val lotto = Lotto(numbers)
        val bonusNumber = LottoNumber(1)
        // when
        val actual = lotto.hasBonusNumber(bonusNumber)
        // then
        actual shouldBe true
    }

    "보너스 번호 포함 안되면 containsBonusNumber에서 false를 반환" {
        // given
        val numbers = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6)
        )
        val lotto = Lotto(numbers)
        val bonusNumber = LottoNumber(7)
        // when
        val actual = lotto.hasBonusNumber(bonusNumber)
        // then
        actual shouldBe false
    }
})
