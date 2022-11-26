package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions

class LottoTest : StringSpec({

    "로또 1장의 가격은 1000원 이다" {

        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Lotto(100) }
    }

    "1-45 사이의 난수 6개 생성" {
        val lotto = Lotto(1000)

        lotto.createNumbers().size shouldBe 6
        lotto.createNumbers().forEach { num ->
            num shouldBeInRange IntRange(1, 45)
        }
    }

    "생성한 난수 6개는 중복이 없어야 한다." {
        val lotto = Lotto(1000)

        val numbers = lotto.createNumbers()

        numbers.size shouldBe numbers.distinct().size
    }
})
