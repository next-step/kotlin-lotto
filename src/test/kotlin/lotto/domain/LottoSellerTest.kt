package lotto.domain

import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class LottoSellerTest {

    @ParameterizedTest
    @ValueSource(ints = [1000, 2000])
    internal fun `로또의 가격을 설정할 수 있다`(lottoPrice: Int) {
        val sut = LottoSeller(lottoPrice)
        sut.lottoPrice shouldBe lottoPrice
    }

    @ParameterizedTest
    @CsvSource(
        "1000, 14000, 14",
        "2000, 14000, 7"
    )
    internal fun `로또 구입 금액을 받으면 구입 가능한 수량의 로또를 발급해야 한다`(
        lottoPrice: Int,
        money: Int,
        expectedLottoCount: Int,
    ) {
        val sut = LottoSeller(lottoPrice)
        val issuedLottos: IssuedLottos = sut.sell(money)
        issuedLottos.lottos shouldHaveSize expectedLottoCount
    }
}
