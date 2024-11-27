package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class LottoTest : StringSpec({
    "로또를 발급한다." {
        shouldNotThrowAny {
            Lotto(RandomGenerator)
        }
    }

    "로또를 직접 초기화할때 중복되지 않은 6개의 숫자를 입력해야한다." {
        listOf(listOf(1, 2, 3, 4), listOf(1, 1, 2, 3, 4, 5)).forAll { numberList ->
            shouldThrowAny {
                Lotto(null, *numberList.toIntArray())
            }
        }
    }

    "발급된 로또의 로또번호 갯수는 6개이다." {
        Lotto(RandomGenerator).lottoNumbers.size shouldBe 6
    }
})
