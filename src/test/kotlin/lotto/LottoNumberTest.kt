package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainInOrder

class LottoNumberTest : StringSpec({
    "로또 번호는 1부터 45까지의 숫자만 허용한다" {
        val outOfRange = listOf(0, 46)

        outOfRange.forEach { number ->
            shouldThrow<IllegalArgumentException> {
                LottoNumber(number)
            }
        }
    }

    "로또 번호목록은 내부의 value를 기준, 오름차순 정렬할 수 있다" {
        val lottoNumbers = listOf(3, 2, 4, 6, 5, 1).map(::LottoNumber)

        val sortedLottoNumbers = lottoNumbers.sorted()

        sortedLottoNumbers shouldContainInOrder listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber)
    }
})
