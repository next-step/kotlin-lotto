package lotto.service

import lotto.domain.LottoPurchaseCount
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class AutomaticLottoNumberPackagesGeneratorTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 5, 10])
    fun `게임 개수를 입력하면 개수만큼의 LottoNumberPackage가 생성된다`(count: Int) {
        val lottoNumberPackages = AutomaticLottoNumberPackagesGenerator().generate(LottoPurchaseCount(count))

        assertThat(lottoNumberPackages).isNotNull
        assertThat(lottoNumberPackages.size).isEqualTo(count)
    }
}
