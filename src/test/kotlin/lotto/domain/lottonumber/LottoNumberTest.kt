package lotto.domain.lottonumber

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoNumberTest : StringSpec({

    "0을 입력하면 RuntimeException 예외 처리를 한다" {
        shouldThrow<RuntimeException> { LottoNumber(0) }
    }

    "음수를 입력하면 RuntimeException 예외 처리를 한다" {
        shouldThrow<RuntimeException> { LottoNumber(-1) }
    }

    "45를 초과한 수를 입력하면 RuntimeException 예외 처리를 한다" {
        shouldThrow<RuntimeException> { LottoNumber(46) }
    }

    "1이상 45 이하의 수를 로또 번호로 변환할 수 있다" {
        val isAllSuccess = (1..45)
            .map { runCatching { LottoNumber(it) } }
            .all { it.isSuccess }
        isAllSuccess shouldBe true
    }

    "로또 번호는 내부의 값을 키 값으로 정렬할 수 있다" {
        val numbers = listOf(1, 10, 3, 2, 5, 4, 20, 14, 13)
        val lottoNumbers = numbers.map { LottoNumber(it) }
        val sortedLottoNumbers = numbers.sorted().map { LottoNumber(it) }
        lottoNumbers.sorted() shouldBe sortedLottoNumbers
    }

    "모든 로또 번호를 반환한다" {
        val allLottoNumbers = LottoNumber.allLottoNumbers()
            .map { it.value }
            .sorted()
        allLottoNumbers shouldBe (1..45).toList()
    }
})
