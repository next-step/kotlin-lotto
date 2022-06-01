package lotto.domain

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.ints.shouldBeLessThan

internal class LottoTest : FreeSpec({

    "중복되지 않는 6개의 번호를 가진 로또를 자동으로 생성한다." {
        // when
        val lotto = Lotto.autoCreate()

        // then
        lotto.lottoNumbers.shouldHaveSize(6)
    }

    "각각의 번호는 오름차순으로 정렬되어 있다." {
        // when
        val lotto = Lotto.autoCreate()

        // then
        for (i in (0..4)) {
            val frontNumber = lotto.lottoNumbers.elementAt(index = i)
            val secondNumber = lotto.lottoNumbers.elementAt(index = i + 1)
            frontNumber.value.shouldBeLessThan(secondNumber.value)
        }
    }
})
