package lotto

class LottoLines(private val lines: List<LottoLine>) {
    init {
        require(lines.isNotEmpty()) { "1개 이상의 로또 라인을 가지고 있어야 합니다." }
    }
}
