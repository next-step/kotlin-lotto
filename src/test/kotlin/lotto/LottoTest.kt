package lotto

import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoTest {
    private lateinit var lotto: Lotto

    @BeforeEach
    fun setUp() {
        lotto = Lotto()
    }

    @Test
    fun `로또 1 장의 가격은 1000원이다`() {
        lotto.price shouldBe 1000
    }

    @Test
    fun `로또는 6개의 번호를 가진다`() {
        lotto.numbers shouldHaveSize 6
    }
}
