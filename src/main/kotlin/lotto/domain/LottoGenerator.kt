package lotto.domain

interface LottoGenerator {

    fun generateLotto(money: Money): List<Lotto>
}
