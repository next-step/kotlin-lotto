package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class LottoTest : StringSpec({

    "로또를 뽑으면 6개 숫자를 반환한다" {
        Lotto().lottoNumbers shouldHaveSize 6
    }

    "로또 번호는 모두 1~45 숫자여야 한다" {
        Lotto().lottoNumbers.forEach {
            (1..45).contains(it.number)
        }
    }

    "로또 번호에 중복이 있으면 예외가 발생한다" {
        val exception = shouldThrow<IllegalArgumentException> {
            Lotto(
                listOf(
                    LottoNumber(1),
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                )
            )
        }

        exception.message shouldBe "로또번호는 중복이 없어야 합니다."
    }

    "로또번호가 개수별로 일치하는지 반환한다" {
        val lotto = Lotto(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6),
            )
        )
        val otherLotto = Lotto(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(10),
                LottoNumber(11),
                LottoNumber(12),
            )
        )

        lotto.isMatchedByMatchCount(otherLotto, 3) shouldBe true
    }
})
