package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import lotto.util.LottoNumberGenerator
import lotto.util.LottoNumberRandomGenerator

class LottoNumberRandomGeneratorTest : FreeSpec({

    "value" - {

        "1 ~ 41 사이의 값이어야한다." {
            LottoNumberRandomGenerator().numberSet().all {
                it in 1..45
            } shouldBe true
        }

        "6개의 수가 나와야한다." {
            LottoNumberRandomGenerator().numberSet().size shouldBe 6
        }

        "중복되지 않는 값이어야한다." {
            val origin = LottoNumberRandomGenerator().numberSet()
            val originToSet = origin.toSet()
            origin.size shouldBe originToSet.size
        }

        "테스트를 위해 입력한 로또 랜덤 리스트가 나와야한다." {
            val input = listOf(1, 2, 3, 4, 5, 6)
            LottoNumberGenerator.Fake(input).numberSet() shouldBe input
        }

        "정렬되어야한다." {
            val input = listOf(6, 2, 3, 4, 5, 1)
            LottoNumberGenerator.Fake(input).numberSet() shouldBe listOf(1, 2, 3, 4, 5, 6)
        }
    }
})
