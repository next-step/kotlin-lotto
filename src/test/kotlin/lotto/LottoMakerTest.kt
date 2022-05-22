package lotto

import lotto.domain.LottoMakerImpl
import org.junit.jupiter.api.Test

class LottoMakerTest {
    @Test
    fun `랜덤 수가 1~45에 중복없는지 테스트`() {
        val lottoMaker = LottoMakerImpl()
        val randomList = lottoMaker.makeLottoNumbers()

        require(randomList.all { it in 1..45 })
        require(randomList.distinct().size == randomList.size)
    }
}