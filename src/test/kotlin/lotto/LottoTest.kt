package lotto

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoTest : StringSpec({

    "로또를 생성한다." {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        lotto shouldBe Lotto(listOf(1, 2, 3, 4, 5, 6))
    }

    "로또 번호가 6개 미만이라면 예외를 던진다." {
        shouldThrowWithMessage<IllegalArgumentException>("로또 번호는 6개여야 합니다.") {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }
    
    "로또 번호 중 중복된 수가 있다면 예외를 던진다." {
        shouldThrowWithMessage<IllegalArgumentException>("중복된 로또 번호가 존재합니다.") {
            Lotto(listOf(1, 1, 2, 3, 4, 5))
        }
    }
})
