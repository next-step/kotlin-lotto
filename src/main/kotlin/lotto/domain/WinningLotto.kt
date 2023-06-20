package lotto.domain

class WinningLotto(private val winning: Lotto, private val bonus: LottoNumber) {

    init {
        require(!winning.contains(bonus)) {
            "당첨 번호와 보너스 번호는 같을 수 없습니다."
        }
    }

    fun match(lotto: Lotto): LottoResult {
        val matchCount = winning.matchCount(lotto)
        return LottoResult.lottoResult(matchCount)
    }
}
