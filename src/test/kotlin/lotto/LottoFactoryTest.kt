package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class AutoLottoFactoryTest : StringSpec({
    val sut = AutoLottoFactory

    "6개의 번호를 가진 로또를 생성한다" {
        sut.create(1000).numbers.size shouldBe 6
    }
})
