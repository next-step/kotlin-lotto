package lotto.domain

object LottoGenerator {
    fun generateLottos(amount: Int): List<Lotto> {
        require(amount > 0) { "금액은 음수일 수 없습니다" }
        return Array(amount / 1000) { Lotto(emptyList()) }.toList()
    }
}
