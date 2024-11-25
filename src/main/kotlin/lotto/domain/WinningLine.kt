package lotto.domain

class WinningLine(
    val line: LottoLine,
    val bonus: LottoNumber,
) {
    init {
        require(!line.contains(bonus)) { "보너스 볼이 이미 추첨되었습니다." }
    }
}
