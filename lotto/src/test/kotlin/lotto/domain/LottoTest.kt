package lotto.domain

import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test

class LottoTest{

    @Test
    fun `각 로또마다 6개의 숫자를 가지고 있다`() {
        val lotto = Lotto()

        lotto.values.size shouldBe 6
    }

    @Test
    fun `로또의 숫자들은 무작위로 섞여 있다`() {
        val lotto = Lotto()

        lotto.values.sorted() shouldNotBe lotto.values
    }

    @Test
    fun `로또의 숫자는 1~45 까지 이다`() {
        val lotto = Lotto()

        lotto.values.all { it in 1..45 } shouldBe true
    }
}
