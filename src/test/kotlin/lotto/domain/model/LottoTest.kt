package lotto.domain.model

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoTest : StringSpec({
    "로또의 숫자 개수가 6이면 로또를 생성한다." {
        val list = listOf(1, 2, 3, 4, 5, 6)
        Lotto.valueOf(list) shouldBe list.map { LottoNumber(it) }
    }

    "로또의 숫자 개수가 6이 아니면 IllegalArgumentException 예외를 던진다." {
        forAll(
            row(listOf(1, 2, 3, 4, 5)),
            row(listOf(1, 2, 3, 4, 5, 6, 7))
        ) { list ->
            shouldThrowWithMessage<IllegalArgumentException>("로또의 숫자 개수는 6입니다.") {
                Lotto.valueOf(list)
            }
        }
    }

    "자동으로 생성한 로또 번호의 수는 6이다." {
        val lotto = Lotto.auto()
        lotto.size shouldBe 6
    }
})
