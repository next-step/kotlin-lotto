package lottery.domain.lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.shouldForAll
import io.kotest.matchers.collections.shouldHaveSize

class LottoSpec : StringSpec({
    val lotto = Lotto()

    "로또는 6개의 숫자를 가진다" {
        lotto.numbers shouldHaveSize 6
    }

    "로또의 각 숫자는 1 이상 45 이하다" {
        lotto.numbers.shouldForAll {
            it in 1..45
        }
    }

})
