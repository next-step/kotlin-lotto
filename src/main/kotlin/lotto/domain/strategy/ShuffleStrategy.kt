package lotto.domain.strategy

import lotto.domain.LottoNumber

val RANDOM_SHUFFLE = { lottoNumbers: List<LottoNumber> -> lottoNumbers.shuffled() }
