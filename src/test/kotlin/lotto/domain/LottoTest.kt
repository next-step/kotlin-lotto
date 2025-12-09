package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class LottoTest : FreeSpec({

    "로또 생성 시 1~45 사이 숫자 6개로 구성된다." {
        val lotto = Lotto.createRandom()
        lotto.numbers.size shouldBe 6
        lotto.numbers.all { it.number in 1..45 } shouldBe true
    }

    "6개의 숫자가 아니면 안된다." {
        val exception =
            shouldThrow<IllegalArgumentException> {
                Lotto(listOf(LottoNumber(1)))
            }

        exception.message shouldBe "다른 숫자 6개가 아니면 안됩니다."
    }

    "다른 숫자 6개가 아니면 안된다." {
        val exception =
            shouldThrow<IllegalArgumentException> {
                Lotto(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(1),
                        LottoNumber(1),
                        LottoNumber(1),
                        LottoNumber(1),
                        LottoNumber(1),
                    ),
                )
            }

        exception.message shouldBe "다른 숫자 6개가 아니면 안됩니다."
    }
})
