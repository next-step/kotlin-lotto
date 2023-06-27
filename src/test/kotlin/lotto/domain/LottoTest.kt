package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoTest : StringSpec({

    "로또 번호를 입력시 숫자가 6개가 아니면 예외가 발생한다." {
        shouldThrow<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5).map { LottoNumber(it) })
        }.message shouldBe "6개의 숫자가 필요합니다."
    }

    "중복 숫자가 존재하면 예외가 발생한다." {
        shouldThrow<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5).map { LottoNumber(it) })
        }.message shouldBe "중복되지 않은 6개의 숫자가 필요합니다."
    }

    "1~45를 입력하지 않으면 예외가 발생한다." {
        shouldThrow<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 55).map { LottoNumber(it) })
        }.message shouldBe "1~45의 수만 가능합니다"
    }

    "로또에서 인자로 받은 LottoNumber가 있는지 판단한다.." {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        lotto.containNumber(LottoNumber(5)) shouldBe true
        lotto.containNumber(LottoNumber(10)) shouldBe false
    }
})
