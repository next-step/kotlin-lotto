package lotto.domain

import org.junit.jupiter.api.Test

class KoreanLottoNumberMakerTest {
    @Test
    fun `랜덤 수가 1~45에 중복없는지 테스트`() {
        val lottoMaker = KoreanLottoNumberMaker()
        val randomList = lottoMaker.makeLottoNumbers()

        require(randomList.lottoNumbers.all { it in 1..45 })
        require(randomList.lottoNumbers.distinct().size == randomList.lottoNumbers.size)
    }
}
