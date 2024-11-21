package lotto

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoLineTest : StringSpec({
    "하나의 문자열을 입력받아 하나의 로또 라인으로 변환할 수 있다." {
        LottoLine("1, 2, 3, 4, 5, 6")
    }

    "로또 라인에 로또 볼이 6개가 아니면 예외 처리한다." {
        forAll(
            row(listOf()),
            row(listOf(1, 2, 3, 4)),
            row(listOf(1, 2, 3, 4, 5)),
            row(listOf(1, 2, 3, 4, 5, 6, 7)),
        ) { numbers ->
            val exception =
                shouldThrowExactly<IllegalArgumentException> { LottoLine(numbers.map { LottoBall(it) }.toList()) }
            exception.message shouldBe "로또 번호는 6개여야 합니다."
        }
    }

    "로또 라인에 중복된 로또 볼이 존재하면 예외 처리한다." {
        forAll(
            row(listOf(1, 1, 3, 4, 5, 6)),
            row(listOf(1, 2, 3, 4, 4, 6)),
            row(listOf(1, 2, 5, 5, 5, 6)),
        ) { numbers ->
            val exception =
                shouldThrowExactly<IllegalArgumentException> { LottoLine(numbers.map { LottoBall(it) }.toList()) }
            exception.message shouldBe "로또 번호는 중복되지 않아야 합니다."
        }
    }
})
