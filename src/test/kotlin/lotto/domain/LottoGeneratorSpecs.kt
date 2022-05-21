package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.DescribeSpec

class LottoGeneratorSpecs : DescribeSpec({

    describe("랜덤 로또 생성기는") {
        it("로또를 생성한다") {
            val lottoGenerator = RandomLottoGenerator
            shouldNotThrowAny {
                lottoGenerator.generate()
            }
        }
    }
})
