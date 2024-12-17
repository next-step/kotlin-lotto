package lotto.repository

import lotto.entity.Lotto

class LottoRepository {
    private lateinit var lotto: Lotto

    fun save(lotto: Lotto) {
        this.lotto = lotto
    }

    fun findAll(): Lotto {
        return this.lotto
    }
}
