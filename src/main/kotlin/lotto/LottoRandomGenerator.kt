package lotto

import lotto.LottoConstants.LOTTO_SIZE

class LottoRandomGenerator {
    fun randomGenerate(): Lotto {
        return Lotto((1..LOTTO_SIZE).map { LottoNumber((1..45).random()) })
    }
}
