package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class LottoTest : StringSpec({

    "로또를 뽑으면 6개 숫자를 반환한다" {
        val lotto = Lotto.draw(RandomLottoGenerator())

        lotto.lottoNumbers shouldHaveSize 6
    }

    "로또 번호는 모두 1~45 숫자여야 한다" {
        val lotto = Lotto.draw(RandomLottoGenerator())

        lotto.lottoNumbers.forEach {
            (1..45).contains(it.number)
        }
    }

    "로또 번호에 중복이 있으면 예외가 발생한다" {
        val exception = shouldThrow<IllegalArgumentException> {
            Lotto.of(listOf(1, 1, 3, 4, 5, 6))
        }

        exception.message shouldBe "로또번호는 중복이 없어야 합니다."
    }

    "로또 번호가 6개가 아니면 예외가 발생한다" {
        val exception = shouldThrow<IllegalArgumentException> {
            Lotto.of(listOf(1, 2, 3, 4))
        }

        exception.message shouldBe "로또번호는 6개 이어야 합니다."
    }

    "로또번호가 개수별로 일치하는지 반환한다" {
        val lotto = Lotto.of(listOf(1, 2, 3, 4, 5, 6))
        val otherLotto = Lotto.of(listOf(1, 2, 3, 10, 11, 12))

        lotto.isMatchedByMatchCount(otherLotto, 3) shouldBe true
    }
})
