package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class LottoTest : StringSpec({
    "자동생성 로또는 중복되지 않는 6개의 숫자를 가지고 있다" {
        val lotto = Lotto()

        lotto.numbers shouldHaveSize 6
        lotto.numbers shouldBe lotto.numbers.distinct()
    }

    "중복되지 않은 숫자여야 한다" {
        val wrongLotto = listOf(
            LottoNumber.from(1),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(3),
            LottoNumber.from(3),
            LottoNumber.from(3)
        )

        assertThrows<IllegalArgumentException> {
            Lotto(wrongLotto)
        }
    }

    "로또 숫자는 6개여야 한다" {
        val wrongLotto = listOf(
            LottoNumber.from(1)
        )

        assertThrows<IllegalArgumentException> {
            Lotto(wrongLotto)
        }
    }
})
