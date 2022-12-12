package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoTest : StringSpec({
    "로또는 중복 없이 6개의 로또 번호를 가진다" {
        shouldNotThrowAny {
            Lotto(
                setOf(
                    LottoNumber.from(1),
                    LottoNumber.from(2),
                    LottoNumber.from(3),
                    LottoNumber.from(4),
                    LottoNumber.from(5),
                    LottoNumber.from(6)
                )
            )
        }
    }

    "범위를 벗어난 로또를 생성할 시 예외를 던진다" {
        forAll(
            row(intArrayOf(1, 2, 3, 4, 5)),
            row(intArrayOf(1, 2, 3, 4, 5, 6, 7))
        ) {
            shouldThrowAny {
                Lotto(*it)
            }
        }
    }

    "로또에 특정 로또 번호가 존재하는지 확인한다" {
        val lotto = Lotto(1, 2, 3, 4, 5, 6)

        forAll(
            row(LottoNumber.from(1), true),
            row(LottoNumber.from(6), true),
            row(LottoNumber.from(7), false),
            row(LottoNumber.from(8), false)
        ) { number, expected ->
            lotto.contains(number) shouldBe expected
        }
    }
})
