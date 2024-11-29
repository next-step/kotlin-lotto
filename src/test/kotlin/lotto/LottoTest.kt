package lotto

import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.fake.FakeLottoNumbersGenerator
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `번호 6개를 가진 로또를 생성할 수 있다`() {
        val expect = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(lottoNumbersGenerator = FakeLottoNumbersGenerator(expect))
        lotto.lottoNumbers shouldBe expect
    }
}
