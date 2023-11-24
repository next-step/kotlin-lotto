package lotto.domain.model

import lotto.domain.model.vo.LottoNumber
import lotto.domain.model.vo.LottoNumbers
import lotto.domain.model.vo.WinningLottoNumbers

/**
 * 로또 객체
 * */
data class Lotto(val lottoNumbers: LottoNumbers) {

    /**
     * 로또 맞은 횟수 반환
     * */
    fun getMatchCount(winningLottoNumbers: WinningLottoNumbers): Int {
        return lottoNumbers.numbers.filter { winningLottoNumbers.winningLottoNumbers.contains(it) }.size
    }

    /**
     * 특정 로또 번호가 맞는지 확인
     * */
    fun matchNumber(lottoNumber: LottoNumber): Boolean {
        return lottoNumbers.numbers.contains(lottoNumber)
    }

    companion object {
        fun from(lottoNumbers: Set<Int> = LottoNumbers.createPrimitiveLottoNumberList()): Lotto {
            return Lotto(LottoNumbers.valueOf(lottoNumbers))
        }
    }
}
