package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain

class LottoTest : FreeSpec({

    "로또 자동 생성 시 1~45 사이 숫자 6개로 구성된다." {
        val lotto = Lotto.ofAuto()
        lotto.numbers.size shouldBe Lotto.LOTTO_NUMBER_COUNT
        lotto.numbers.all { it.number in LottoNumber.MINIMUM_LOTTO_NUMBER..LottoNumber.MAXIMUM_LOTTO_NUMBER } shouldBe true
    }
    "수동 로또 생성 시 문자가 포함된 경우 예외 발생" {
        val exception =
            shouldThrow<IllegalArgumentException> { Lotto.ofManual("1, 2, 3, 4, 5, 육") }
        exception.message shouldContain "올바른 숫자를 입력하세요"
    }
    "수동 로또 생성 시  1보다 작거나 45보다 큰 숫자가 포함된 경우 예외 발생" {
        val exception =
            shouldThrow<IllegalArgumentException> { Lotto.ofManual("0, 2, 3, 4, 5, 46") }
        exception.message shouldBe "1부터 45까지의 숫자를 입력하세요"
    }
    "수동 로또 생성 시 5개의 숫자를 입력하는 경우 예외 발생" {
        val exception =
            shouldThrow<IllegalArgumentException> { Lotto.ofManual("2, 4, 6, 8, 10") }
        exception.message shouldBe "6개의 서로 다른 숫자를 입력하세요"
    }
    "수동 로또 생성 시 6개 숫자 간 중복이 있는 경우" {
        val exception =
            shouldThrow<IllegalArgumentException> { Lotto.ofManual("2, 4, 6, 8, 10, 2") }
        exception.message shouldBe "6개의 서로 다른 숫자를 입력하세요"
    }
})
