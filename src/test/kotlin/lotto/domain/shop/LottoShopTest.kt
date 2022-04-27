package lotto.domain.shop

import lotto.domain.money.BuyMoney
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("로또 복권을 판매하는 상점 오브젝트 `LottoShop` 테스트")
internal class LottoShopTest {

    @DisplayName("로또 자동 구매 시 유효한 `BuyMoney`가 주어지면 해당하는 만큼 `LottoGame` 리스트 반환")
    @ParameterizedTest
    @ValueSource(ints = [1_000, 12_000, 540_000, 1_000_000, 2_263_000])
    fun `return LottoGame list if given valid money`(givenMoney: Int) {
        // Arrange
        val buyMoney = BuyMoney(value = givenMoney)

        // Act
        val lottoGames = LottoShop.quickPickBuy(buyMoney)

        // Assert
        assertThat(lottoGames.size).isEqualTo(buyMoney.howManyBuyLottoGames)
    }
}
