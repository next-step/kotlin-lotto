package lotto.repository

import lotto.entity.Lotto

class LottoRepository {
    private val lottoGames: MutableList<Lotto> = mutableListOf()

    fun save(lotto: Lotto) {
        this.lottoGames.add(lotto)
    }

    fun findAll(): List<Lotto> {
        return this.lottoGames.toList()
    }
}
