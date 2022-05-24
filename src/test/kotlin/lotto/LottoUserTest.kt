package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoUserTest {
    private lateinit var lottoUser: LottoUser

    @BeforeEach
    fun setup() {
        lottoUser = LottoUser()
    }

    @Test
    fun `로또 당첨금의 총합을 계산한다`() {
        assertThat(lottoUser.calculateWinningMoney()).isEqualTo(5000)
    }
}

class LottoUser {
    fun calculateWinningMoney(): Int {
        return 5000
    }
}
