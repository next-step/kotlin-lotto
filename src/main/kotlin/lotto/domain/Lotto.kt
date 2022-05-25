package lotto.domain

import lotto.domain.vo.LottoNumber

private const val LOTTO_SIZE = 6

class Lotto(val lottoNumbers: Set<LottoNumber>) {
    init {
        require(lottoNumbers.size == LOTTO_SIZE) { "로또는 $LOTTO_SIZE 개의 숫자로 이루어져야 합니다." }

        lottoNumbers.sorted()
    }
}
