package lotto.domain.generator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainAnyOf
import lotto.domain.LottoNumber

class LotteryGeneratorTest : StringSpec({

    "복권 생성을 요청하면 1 ~ 45 범위의 복권이 생성된다." {
        val lottoNumbers: List<LottoNumber> = LottoNumber.LOTTO_NUMBER_RANGE
            .map(::LottoNumber)

        repeat(times = 10) {
            val generateLottery = LotteryGenerator.draw()
                .map { it }

            generateLottery shouldContainAnyOf lottoNumbers
        }
    }
})
